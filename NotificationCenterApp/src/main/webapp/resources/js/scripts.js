$(document).ready(function (){

	var v = new Vue({
		el: "#helloContainter",
		data: {
			time: 14
		}

	});


	var notificationData = {
		adres: "",
		miasto: "",
		typ : ""
	}

	var notificationFormMVVM = new Vue({
		el: "#newEditNofiticationForm",
		data: notificationData,
		methods: {
			changeLocation:function(){
				var address = this.$data.adres;
				var city = this.$data.miasto;
				if(  address.length > 0  && city.length > 0 ){
					codeNotificationAddress(city + "," + address + ",POLAND" );
				}
			}
		}
	});


});