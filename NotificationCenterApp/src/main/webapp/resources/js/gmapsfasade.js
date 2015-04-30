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
        var addressObj = {
            address: address
        };
        geocoder.geocode(addressObj, onNotificationLocationFound);
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
        var obj = notificationFormMVVM.$data.notification;
        obj.gpsXCoordinate = location.lat();
        obj.gpsYCoordinate = location.lng();
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
            //place a marker at the location
            setNotificationLocation(results[0].geometry.location);
        } else {
            console.log('Geocode was not successful for the following reason: ' + status);
        }
    }

}