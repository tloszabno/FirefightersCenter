function editNotification(id){
    location.href="newFireNotication.htm?id=" + id;
}
function showNotificationReports(id){
    loadHtml("showPossibleReports.htm?notificationId=" + id, $("#dropbox_holder"), 
        function(){
            $("#possibleReportDropbox").modal("show");
        }
    );
}


function showReport(id){
    loadHtml("viewReport.htm?id=" + id, $("#dropbox_holder"), 
        function(){
            $(".modal-backdrop").remove();
            $("#reportViewDropbox").modal("show");
        }
    );
}