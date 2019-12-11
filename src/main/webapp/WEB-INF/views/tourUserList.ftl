<#import "parts/common.ftl" as c>
<@c.page>
<div>List of User Tours</div>
<div>
<table>
    <tr>
        <th>Id</th>
        <th>Tour date</th>
        <th>Duration</th>
        <th>Cost</th>
        <th>Type</th>
    </tr>

    <#list tours as tour>
        <tr>
            <td><a href="/tour/${tour.tourId}">${tour.tourId}</a></td>
            <td>${tour.tourDate}</td>
            <td>${tour.tourDuration}</td>
            <td>${tour.tourCost}</td>
            <td>${tour.tourType}</td>
        </tr>
        <#else>
        No tours
    </#list>
</table>
</div>
</@c.page>