<#import "common.ftl" as macros/>



<#macro notificationForm>


<style>
#newEditNofiticationForm{
    position: relative;
}

#newEditNofiticationFormInputs{
    width: 30%;
    float: left;
    margin: 50px;
    padding: 50px;
}

#map-canvas{
    height: 500px;
    width: 50%;
    margin: 50px;
    padding: 50px;
}

</style>

<div id="newEditNofiticationForm">
    <form id="newEditNofiticationFormInputs">
        <div class="form-group"> 
            <label for="adres">Adres</label>
            <input class="form-control" v-on="change: changeLocation" v-model="adres" type="text" id="adres" placeholder="Adres"/>
        </div>
        <div class="form-group"> 
            <label for="city">Miasto</label>
            <input class="form-control" v-on="change: changeLocation" v-model="miasto" type="text" id="miasto" placeholder="Miasto"/>
        </div>
        <div class="form-group"> 
            <label for="typ">Typ akcji</label>
            <input class="form-control" v-model="typ" type="text" id="typ" placeholder="Typ akcji"/>
        </div>
    </form>
    <div id="map-canvas" class="mapContainer"></div>
</div> 



</#macro>