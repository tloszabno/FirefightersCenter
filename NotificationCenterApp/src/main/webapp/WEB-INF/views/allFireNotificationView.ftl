<#import "macros/common.ftl" as macros/>

<script src="resources/js/allFireNotification.js"></script>
 
<@macros.pageTemplate>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Typ</th>
            <th>Miasto</th>
            <th>Adres</th>
            <th>Zgloszono</th>
            <th>Zakonczono</th>
            <th>Stan</th>
            <th>Akcje</th>
        </tr>
        <#list notifications as notif>
            <tr>
                <td>${notif.id}</td>
                <td>${notif.type}</td>
                <td>${notif.city}</td>
                <td>${notif.address}</td>
                <td>${notif.notificationDate?datetime}</td>
                <td><#if notif.finishDate??>${notif.finishDate?datetime}<#else>Nie skonczona</#if></td>
                <td>${notif.actionState}</td>
                <td>
                    <button class="btn btn-warning btn-sm" onclick="editNotification(${notif.id});">Pokaz/Edytuj</button>
                    <button class="btn btn-primary btn-sm" onclick="showNotificationReports(${notif.id});">Raporty</button>
                </td>
            </tr>
        </#list>
    </table>

    <div id="dropbox_holder"></div>
</@macros.pageTemplate>
