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
            description: "",
            firefightersPosts:[]
        },
        gmap: {
        	loadProgress : 0,
        	progressBarClass: "progress-bar-success",
        	progressBarMsg: ""
        },
        availableFirefightersPosts: []
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
            },
            saveNotification: function(){
                $.ajax({
                    type: "POST",
                    url: "saveFireNotification",
                    data: JSON.stringify(this.$data.notification),
                    contentType: "application/json; charset=utf-8",
                    success: function(e){ alert("Zapisano"); refreshPage();  },
                    error: function(e){ alert("Błąd");  }
                });
            },
            removePostFromNotification: function(i,e){
                var posts = this.$data.notification.firefightersPosts;
                if( i > -1){
                    posts.splice(i, 1);
                }
            }
        }
    });
    window.notificationFormMVVM = notificationFormMVVM;

    var gmapFasade = new GmapFasade(notificationFormMVVM);
    gmapFasade.initialize();


    $.getJSON("getAllFirefightersPosts", function(gotData){
        data.availableFirefightersPosts = gotData;    
        gmapFasade.addFirefightersPosts(gotData);        
    });

    gmapFasade.optimizeSize()
    $(window).resize(gmapFasade.optimizeSize);

    var isEdit = $("#isEdit").val() == "true";
    console.log("isEdit=" + isEdit);
    if( isEdit == true ){
        var editId = $("#editNotificationId").val();
        $.getJSON("getNotification?id="+ editId, function(gotData){
            data.notification = gotData;
        });

    }



});
