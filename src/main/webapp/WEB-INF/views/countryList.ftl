<#import "parts/common.ftl" as c>
<@c.page>
List of Countries
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <#list countries as country>
        <tr>
            <td><a href="/country/${country.countryId}">${country.countryId}</a></td>
            <td>${country.countryName}</td>
            <td><a href="/deleteCountry/${country.countryId}">Delete</a></td>
            <td><a href="/updateCountry/${country.countryId}">Update</a></td>
        </tr>
    </#list>
</table>

<a href="/hello">Back to the main page</a>
</@c.page>