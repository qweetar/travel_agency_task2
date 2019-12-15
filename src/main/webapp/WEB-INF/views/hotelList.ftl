<#import "parts/common.ftl" as c>
<@c.page>
List of Hotels
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Number fo Stars</th>
        <th>Website</th>
        <th>Features</th>
        <th>Latitude</th>
        <th>Longitude</th>
    </tr>

    <#list hotels as hotel>
        <tr>
            <td><a href="/hotel/${hotel.hotelId}">${hotel.hotelId}</a></td>
            <td>${hotel.hotelName}</td>
            <td>${hotel.hotelStars}</td>
            <td>${hotel.hotelWebSite}</td>
            <td>${hotel.hotelFeatures}</td>
            <td>${hotel.hotelLatitude}</td>
            <td>${hotel.hotelLongitude}</td>
            <td><a href="/deleteHotel/${hotel.hotelId}">Delete</a></td>
            <td><a href="/updateHotel/${hotel.hotelId}">Update</a></td>
        </tr>
    </#list>
</table>

<a href="/addHotel">Create Hotel</a>
</@c.page>