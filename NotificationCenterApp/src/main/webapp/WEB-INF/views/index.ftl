<#import "macros/common.ftl" as macros/>
    
<@macros.pageTemplate>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&sensor=false"></script>
<script type="text/javascript">
      function initialize() {
        var mapOptions = {
          center: { lat: -34.397, lng: 150.644},
          zoom: 8
        };
        var map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);
      }
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
    
<div id="helloContainter">

    Witaj {{time}} <br/>
    <input type="text" v-model="time">
</div> 

<div id="map-canvas"></div>


</@macros.pageTemplate>
