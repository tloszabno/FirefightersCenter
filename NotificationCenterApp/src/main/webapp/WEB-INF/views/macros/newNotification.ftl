<#import "common.ftl" as macros/>



<#macro notificationForm>


<style>
#newEditNofiticationForm{
    position: relative;
}

#newEditNofiticationFormInputs{
    width: 30%;
    float: left;
    margin-right: 20px;
    padding: 20px;
}

#map-canvas{
    height: 300px;
    width: 50%;
    margin: 50px;
    padding: 50px;
}

</style>

<div id="newEditNofiticationForm">
    <form id="newEditNofiticationFormInputs">
        <div class="form-group"> 
            <label for="address">Adres</label>
            <input class="form-control" v-on="change: changeLocation" v-model="notification.address" type="text" id="address" placeholder="Adres"/>
        </div>
        <div class="form-group"> 
            <label for="city">Miasto</label>
            <input class="form-control" v-on="change: changeLocation" v-model="notification.city" type="text" id="city" placeholder="Miasto"/>
        </div>
        <div class="form-group"> 
            <label for="type">Typ akcji</label>
            <input class="form-control" v-model="type" type="text" id="notification.type" placeholder="Typ akcji"/>
        </div>
        <div class="form-group"> 
            <label for="description">Opis</label>
            <textarea class="form-control" v-model="notification.description" id="description" rows="4" placeholder="Opis"></textarea>
        </div>
        <div class="progress">
          <div class="progress-bar {{gmap.progressBarClass}}" role="progressbar" aria-valuenow="{{gmaps.loadProgress}}" aria-valuemin="0" aria-valuemax="100" style="width: {{gmap.loadProgress}}%">
            {{gmap.progressBarMsg}}
          </div>
        </div>
    </form>
    <div id="map-canvas" class="mapContainer"></div>
</div> 



</#macro>