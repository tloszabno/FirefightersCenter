function GmapFasade(notificationFormMVVM){

    var notificationPlaceMarkers = [];
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

    function removeAllNotificationPlaceMarkers() {
        for (var i = 0; i < notificationPlaceMarkers.length; i++) {
            notificationPlaceMarkers[i].setMap(null);
        }
    }

    function setModelGPSLocation(location) {
        //sconsole.log('location=' + location.lat() + " lng=" + location.lng() );
        setProgressState(true);
        var obj = notificationFormMVVM.$data.notification;
        obj.gpsXCoordinate = location.lat();
        obj.gpsYCoordinate = location.lng();
        setProgress(100);
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

    function setNotificationLocation(location) {
        removeAllNotificationPlaceMarkers();

        setModelGPSLocation(location);

        var marker = new google.maps.Marker({
            map: map,
            position: location
        });
        notificationPlaceMarkers.push(marker);
        map.setZoom(10);
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

}