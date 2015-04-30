$(document).ready(function() {

    var data = {
        notification: {
            id: null,
            gpsXCoordinate: null,
            gpsYCoordinate: null,
            actionState: "NEW",
            address: "",
            city: "",
            type: "",
            description: ""
        }
    };

    var notificationFormMVVM = new Vue({
        el: "#newEditNofiticationForm",
        data: data,
        methods: {
            changeLocation: function() {
                var address = this.$data.notification.address;
                var city = this.$data.notification.city;
                if (address.length > 0 && city.length > 0) {
                    gmapFasade.codeNotificationAddress(city + "," + address + ", POLAND");
                }
            }
        }
    });

    var gmapFasade = new GmapFasade(notificationFormMVVM);
    gmapFasade.initialize();
	gmapFasade.optimizeSize()
    $(window).resize(gmapFasade.optimizeSize);

});
