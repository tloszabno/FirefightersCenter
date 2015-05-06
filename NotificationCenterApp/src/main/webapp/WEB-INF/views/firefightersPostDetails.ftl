
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

    </table>

    Uzupelnic reszte danych, dodac inputy itd <br/>

    <button class="btn btn-primary" v-on="click: addFirefightersPost">Dodaj do akcji</button>
</div>

