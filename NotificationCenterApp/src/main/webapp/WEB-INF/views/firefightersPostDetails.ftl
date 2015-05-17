
<div id="container_${post.firefightersPost.id}">
    <h5>${post.firefightersPost.name}</h5>
    <h5>${post.firefightersPost.address}</h5>
    <table class="table">
        <tr>
            <td>Dostepny:</td>
            <td>
                <#if post.available == true>
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                <#else>
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </#if>
            <td>
        </tr>
        <tr>
            <td>Zastepow:</td>
            <td>
                <span>${post.availableUnits!}</span>
            </td>
        </tr>
        <#list post.equipmentInfo as eqInfo>
        <tr class="equipmentInfo">
            <td><span class="equipmentName">${eqInfo.equipmentName}</span> (${eqInfo.count})</td>
            <td>
                <input class="equipmentCount" type="number" min="0" max="${eqInfo.count}" value="0">
            </td>
        </tr>
        </#list>


    </table>


    <button class="btn btn-primary" v-on="click: addFirefightersPost">Dodaj do akcji</button>
</div>

