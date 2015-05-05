<#macro navigationBar>
  <div class="navbar navbar-inverse" role="navigation">
      <div class="container">
      
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
              <span class="sr-only">Nawigacja</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Centrum Dyspozytora</a>
        </div>
       <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active">
            <button type="button" class="menu_element_btn btn btn-primary navbar-btn active" onclick="location.href='newFireNotication.htm'">${text.newNotificationBtnMsg}</button>
          </li>
          <li>
            <button type="button" class="menu_element_btn btn btn-danger  navbar-btn" onclick="location.href='allFireNotification.htm'">${text.notifitacionBtnMsg}</button>
          </li>
          <li>
            <button type="button" class="menu_element_btn btn btn-danger  navbar-btn" onclick="location.href='allFirefightersPosts.htm'">${text.stationsBtnMsg}</button>
          </li>
        </ul>
      </div>
      </div>
    </div>
</#macro>

<#macro pageTemplate>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title!}</title>
  
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/styles.css" rel="stylesheet">
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/jquery-dateFormat.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/commons.js"></script>
    <script src="resources/js/constants.js"></script>
    <script src="resources/js/underscore.string.min.js"></script>
    <script src="resources/js/vue.js"></script>
  </head>
  <body>

  <@navigationBar>
  </@navigationBar>

	<#nested>
  
  </body>
</html>
</#macro>


<#macro errorList listId>
	<div id=${listId}  class="error_div center-block"> </div>
</#macro>

<#macro divWithHeader header="" class="" id="">
<div class="panel panel-primary  center-block ${class}">
	<div class="panel-heading">
		<h3 class="panel-title">${header}</h3>
	</div>
	<div class="panel-body" id="${id}">
		<#nested>
	</div>
</div>
</#macro>


<#macro modal_window id="" title="" onclose="" showSubmit=false onSubmit="" submitBtnText="" closeBtnText="Close" isLarge=false>
<div class="modal fade " id="${id}" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
  <div class="modal-dialog <#if isLarge==true>modal-lg</#if>">
      <div class="modal-content">
      <div class="modal-header bg-primary">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"  onclick="${onclose}">&times;</button>
        <h4 class="modal-title" id="myModalLabel">${title}</h4>
      </div>
      <div class="modal-body">
        <#nested>
      </div>
      <div class="modal-footer">
        <#if showSubmit == true>
          <button type="button" class="btn-save btn btn-primary"  onclick="${onSubmit}">${onSubmitText}</button>
        </#if>
          <button type="button" class="btn-cancel btn btn-default" data-dismiss="modal" onclick="${onclose}">${closeBtnText}</button>
      </div>
    </div>
  </div>
</div>
</#macro>
