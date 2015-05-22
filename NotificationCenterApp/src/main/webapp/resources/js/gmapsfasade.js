function GmapFasade(notificationFormMVVM){

    var notificationPlaceMarkers = [];
    var firefightersPostsMarkers = [];
    var map;
    var self = this;

    this.initialize = function() {
        geocoder = new google.maps.Geocoder();
        var latlng = new google.maps.LatLng(51.919438, 19.14513599999998);
        var mapOptions = {
            zoom: 6,
            center: latlng
        }
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    }


    this.codeNotificationAddress = function(address) {
        setProgress(0);
        var addressObj = {
            address: address
        };
        geocoder.geocode(addressObj, onNotificationLocationFound);
        setProgress(30);
    }

    this.optimizeSize = function(){
        var h = $( window ).height();
        $("#map-canvas").height(h - 300);
    }


    this.addFirefightersPosts = function(posts_array){
        $.each(posts_array, function(i, v){
            var addressObj = {
                address: v.address + ", " + v.city + ", POLAND"
            };
            geocoder.geocode(addressObj, onFirefightersPostFoundFactory(v));

        });
    }


    function removeAllNotificationPlaceMarkers() {
        for (var i = 0; i < notificationPlaceMarkers.length; i++) {
            notificationPlaceMarkers[i].setMap(null);
        }
    }

    function setProgress(val){
        var obj = notificationFormMVVM.$data.gmap;
        obj.loadProgress = val;
    }

    function setProgressState(ok, errMsg){
        var obj = notificationFormMVVM.$data.gmap;
        if( ok ){
            obj.progressBarClass = "progress-bar-success";
            obj.progressBarMsg = "";
        }else{
            obj.progressBarClass = "progress-bar-danger";
            if( errMsg != undefined) {
                obj.progressBarMsg = errMsg;
            }
        }
        
    }

    function onNotificationLocationFound(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location); //center the map over the result
            setProgressState(true);
            //place a marker at the location
            setNotificationLocation(results[0].geometry.location);
        } else {
            setProgressState(false, "Nie mozna znalezc lokalizacji" );
            setProgress(100);
            console.log('Geocode was not successful for the following reason: ' + status);
        }
    }
    function setNotificationLocation(location) {
        removeAllNotificationPlaceMarkers();

        setModelGPSLocation(location);

        var marker = new google.maps.Marker({
            map: map,
            position: location,
            title: "Zadarzenie",
            icon: "resources/images/fire.png"
        });
        notificationPlaceMarkers.push(marker);
        map.setZoom(15);
    }

    function setModelGPSLocation(location) {
        //sconsole.log('location=' + location.lat() + " lng=" + location.lng() );
        setProgressState(true);
        var obj = notificationFormMVVM.$data.notification;
        obj.gpsXCoordinate = location.lat();
        obj.gpsYCoordinate = location.lng();
        setProgress(100);
    }



    function onFirefightersPostFoundFactory(postDTO){
        return function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                //place a marker at the location
                setFirefightersPostLocation(results[0].geometry.location, postDTO);
            } else {
                console.log('Geocode was not successful for the following reason: ' + status);
            }
        }    
    }

    function setFirefightersPostLocation(location, post){
        var marker = new google.maps.Marker({
            map: map,
            position: location,
            title: post.name,
            icon: "resources/images/fire_engine.png"

        });
        
        google.maps.event.addListener(marker, 'click', function() {
            var url = "getFirefightersPostDetails?id=" + post.id;
            $.get(url, function(data){
                var infowindow = new google.maps.InfoWindow({
                    content: data
                });
                


                infowindow.open(map,marker);
                google.maps.event.addListener(infowindow,'domready',function(){
                    setupFirefightersPopup(post);
                });
            });

        });

        firefightersPostsMarkers.push(marker);
    }

    function setupFirefightersPopup(post){
        var data = {
            id: post.id,
            name: post.name
        }
        var postInfoMVVM = new Vue({
            el: "#container_" + post.id,
            data: data,
            methods: {
                addFirefightersPost: function(){
                    var availablePosts = notificationFormMVVM.$data.availableFirefightersPosts;
                    for(var i=0; i < availablePosts.length; i++){
                        var v = availablePosts[i];
                        v.confirmation = false;
                        v.canDelete = true;
                        if( v.id == data.id ){
                            // add selected equipment
                            $(".equipmentInfo").each(function(idx){
                                var eqName = $(this).find(".equipmentName").text();
                                var eqCount = $(this).find(".equipmentCount").val();

                                var eqInfo = {
                                    equipmentName: eqName,
                                    count: eqCount
                                }
                                v.equipmentInfo.push(eqInfo);

                            });
                            var arr = notificationFormMVVM.$data.notification.firefightersPosts;
                            arr.push(v);      
                            //append some values to v
                            break;
                        }
                    }
                }
            }
        });
    }
}