<#import "parts/common.ftl" as c>
<@c.page>
Hotel page
<table>
    <tr>
        <td>Id</td>
        <td>${hotel.hotelId}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${hotel.hotelName}</td>
    </tr>
    <tr>
        <td>Number of stars</td>
        <td>${hotel.hotelStars}</td>
    </tr>
    <tr>
        <td>Website</td>
        <td>${hotel.hotelWebSite}</td>
    </tr>
    <tr>
        <td>Latitude</td>
        <td>${hotel.hotelLatitude}</td>
    </tr>
    <tr>
        <td>Longitude</td>
        <td>${hotel.hotelLongitude}</td>
    </tr>
    <tr>
        <td>Hotel features</td>
        <td>${hotel.hotelFeatures}</td>
    </tr>
</table>
    <br>
    <a href="/tours">Back to Tours</a>

<br>
<a href="/hotels">Back to Hotels</a>
</@c.page>