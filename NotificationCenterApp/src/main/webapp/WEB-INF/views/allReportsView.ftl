<#import "macros/common.ftl" as macros/>

<@macros.pageTemplate>
    
<script> 
</script>

<!--Cyba jesdnak to wyleci-->

<table class="table">
    <#list actionReports as actionReport>
        <tr>
            <td>${actionReport.notification.id}</td>
            <td>${actionReport.notification.city}</td>
            <td>${actionReport.notification.address}</td>
            <td>${actionReport.notification.notificationDate?datetime}</td>
            <td><#if actionReport.notification.finishDate??>${actionReport.notification.finishDate?datetime}<#else>W trakcie</#if></td>

        </tr>
    </#list>
</table>


</@macros.pageTemplate>
