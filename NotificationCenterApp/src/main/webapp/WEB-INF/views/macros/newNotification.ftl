<#import "common.ftl" as macros/>



<#macro notificationForm>


<style>
    #newEditNofiticationForm{
        position: relative;
    }

    #newEditNofiticationDivInputs{
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
    <div id="newEditNofiticationDivInputs">
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
                <input class="form-control" v-model="notification.type" type="text" id="notification.type" placeholder="Typ akcji"/>
            </div>
            <div class="form-group"> 
                <label for="description">Opis</label>
                <textarea class="form-control" v-model="notification.description" id="description" rows="4" placeholder="Opis"></textarea>
            </div>
            <div class="form-group">
                <label for="selectedPosts">Wybrane posterunki</label>
                <table class="table table-stripped" id="selectedPosts">
                    <tr v-repeat="notification.firefightersPosts">
                        <td>{{name}}</td>
                        <td>{{address}}</td>
                        <td>{{city}}</td>
                        <template  v-if="canDelete">
                            <td><button class="btn btn-danger  btn-xs" v-on="click: removePostFromNotification($index, $event)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                        </template>
                        <template  v-if="confirmation">
                            <td><button class="btn btn-success btn-xs"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></td>
                        </template>
                        <template  v-if="!confirmation">
                            <template v-if="!canDelete">
                                <td><button class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td>
                            </template>
                        </template>
                    </tr>
                </table>
            </div>
            <div class="progress">
                <div class="progress-bar {{gmap.progressBarClass}}" role="progressbar" aria-valuenow="{{gmaps.loadProgress}}" aria-valuemin="0" aria-valuemax="100" style="width: {{gmap.loadProgress}}%">
                    {{gmap.progressBarMsg}}
                </div>
            </div>
        </form>
        <button class="btn btn-danger btn-lg" v-on="click: saveNotification"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span>&nbsp; Zapisz zgloszenie</button>
    </div>
    <div id="map-canvas" class="mapContainer"></div>
    
</div> 



</#macro>