<#import "parts/common.ftl" as c>
<@c.page>
Country page
<table>
    <tr>
        <td>Id</td>
        <td>${country.countryId}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${country.countryName}</td>
    </tr>
</table>
    <br>
    <a href="/tours">Back to Tours</a>

<br>
<a href="/countries">Back to Countries</a>
</@c.page>