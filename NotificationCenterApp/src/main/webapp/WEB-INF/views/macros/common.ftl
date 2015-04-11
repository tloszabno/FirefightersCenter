<#macro pageTemplate>
<!DOCTYPE html>
<html lang="en">
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
    <script src="resources/js/scripts.js"></script>

    
  </head>
  <body>

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
	<div class="panel-body" id=${id}>
		<#nested>
	</div>
</div>
</#macro>