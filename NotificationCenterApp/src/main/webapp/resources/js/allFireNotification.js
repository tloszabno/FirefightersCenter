function editNotification(id){
    console.log('edit notification=' + id);
}
function showNotificationReports(id){
    loadHtml("showPossibleReports.htm?notificationId=" + id, $("#div_holder"), 
        function(){
            $("#div_holder").modal("show");
        }
    );



}
