<#import "macros/common.ftl" as macros/>
<#import "macros/newNotification.ftl" as notif>
<@macros.pageTemplate>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&sensor=false"></script>
<script type="text/javascript" src="resources/js/gmapsfasade.js"></script>
<script src="resources/js/newEditFireNotification.js"></script>


<input id="isEdit" value="${isEdit}" type="hidden"/>
<#if isEdit == "true">
<input id="editNotificationId" value="${editNotificationId}" type="hidden"/>
</#if>

    
<@notif.notificationForm></@notif.notificationForm>


</@macros.pageTemplate>
