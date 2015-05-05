<#import "macros/common.ftl" as macros/>

<@macros.modal_window id="possibleReportDropbox" title="Mozliwe raporty dla akcji" closeBtnText="Zamknij">

<style>
    .table-striped tbody tr.highlight td { background-color: #F7B537; }
</style>

<script>
    $(document).ready(function(){
        $('#availableReportForActionTable').on('mouseover', 'tbody tr', function(event) { 
            $(this).addClass('highlight').siblings().removeClass('highlight'); 
        }) 
    });
</script>

<table class="table table-striped table-condensed" id="availableReportForActionTable">
    <tr>
        <th>Nazwa posterunku</th>
        <th>Adres</th>
        <th>Miejscowosc</th>
        <th>Gmina</th>
    </tr>

    <#list possibleReports as reportEntry>
    <tr id="${reportEntry.id}" onclick="showReport('${reportEntry.id}')" data-dismiss="modal" aria-hidden="true">
        <td>${reportEntry.firefightersPost.name}</td>
        <td>${reportEntry.firefightersPost.address}</td>
        <td>${reportEntry.firefightersPost.city}</td>
        <td>${reportEntry.firefightersPost.community}</td>
    </tr>
    </#list>

    

</table>


</@macros.modal_window>