<#import "macros/common.ftl" as macros/>

<@macros.pageTemplate>
<script src="resources/js/viewFirefightersPosts.js"></script>

<div class="container" id="firefightersPosts"> 
    <div class="row">
        <table class="table table-stripped"> 
            <tr>
                <th></th>
                <th>Nazwa</th>
                <th>Adres</th>
                <th>Miasto</th>
                <th>Gmina</th>
                <th>IP</th>
            </tr>
            <tr v-repeat="posts">
                <td># {{$index + 1}}</td>
                <td><input v-model="name" type="text"></td>
                <td><input v-model="address" type="text"></td>
                <td><input v-model="city" type="text"></td>
                <td><input v-model="community" type="text"></td>
                <td><input v-model="systemIpAddress" type="text"></td>
                <td>
                    <button class="btn btn-danger  btn-xs" v-on="click: removePost($index, $event)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>           
                </td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <button class="btn btn-success  btn-xs" v-on="click: addNewPost"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>           
                </td>
            </tr>
        </table>
    </div>
    
    <div class="row">
        <div class="col-md-offset-5 col-md-1">
        <button class="btn btn-primary" v-on="click: savePosts"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span>&nbsp; Zapisz zmiany</button>           
        </div>
    </div> 
</div>


</@macros.pageTemplate>
