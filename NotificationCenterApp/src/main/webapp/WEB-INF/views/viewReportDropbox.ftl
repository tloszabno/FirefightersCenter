<#import "macros/common.ftl" as macros/>

<style>
#reportViewDropbox{
    width: 500px!
}

</style>


<@macros.modal_window id="reportViewDropbox" title="Raport id:${report.id} ${report.firefightersPost.name} " closeBtnText="Zamknij" isLarge=true>


<table class="table table-condensed">
    <tr>
        <td colspan="2">
            Sprawozdanie Jednoski Strazy Pozarnej ${report.firefightersPost.name}
            w ${report.firefightersPost.city} z akcji, ktora miala miejsce w dniu ${report.fireNotification.notificationDate?date}
            adres ${report.fireNotification.address!} gmina ${report.community!}. 
        </td>
    </tr>

    <tr>
        <td>Rodzaj zdarzenia</td>
        <td>${report.fireNotification.type!}</td>
    </tr>
    <tr>
        <td>Wielkosc</td>
        <td>${report.size!} [m^2/ha]</td>
    </tr>
    <tr>
        <td>Obiekt</td>
        <td>${report.object!}</td>
    </tr>
    <tr>
        <td>Wlasciciel</td>
        <td>${report.owner!}</td>
    </tr>
</table>

<h4>1. W akcji braly udzial zastepy:</h4>
<table class="table table-condensed">
    <tr>
        <td>Zastep</td>
        <td>Ilosc osob</td>
        <td>Ilosc przejechanych km</td>
        <td>Godzina wyjazdu</td>
        <td>Godzina powrotu</td>
        <td>Czas pracy autopompy</td>
        <td>Zrodlo tankowania</td>
    </tr>

    <#list report.firefightersBrigades as fb>
    <tr>
        <td>${fb.name}</td>
        <td>${fb.memberNumber}</td>
        <td>${fb.distanceKM}</td>
        <td>${fb.departureTime?time}</td>
        <td>${fb.arrivalTime?time}</td>
        <td>${fb.pumpWorktime}</td>
        <td>${fb.tankSource}</td>
    </tr>
    </#list>
</table>
<br/>

<h4>2. Wykaz osob biaracych udzial w akcji</h4>
<ul>
    <#list report.firemans as f>
        <li>${f.firstName} ${f.surname}</li>
    </#list>
</ul>
<br/>

<h4>3. Sprzet wykorzystywany podczas akcji</h4>
<table class="table table-condensed">
    <tr>
        <td>Rodzaj</td>
        <td>Czas pracy [h]</td>
        <td>Rodzaj paliwa</td>
    </tr>
    <#list report.equipment as eq>
        <td>${eq.equipmentType}</td>
        <td>${eq.workTimeH}</td>
        <td>${eq.fuelType}</td>
    </#list>
</table>

<br/>
<h4>4. Pozostale uszkodzenia</h4> <br/>

${report.otherDamage!}


</@macros.modal_window>