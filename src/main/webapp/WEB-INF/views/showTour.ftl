<#import "parts/common.ftl" as c>
<@c.page>
Tour page
<table>
    <tr>
        <td>Id</td>
        <td>${tour.tourId}</td>
    </tr>
    <tr>
        <td>Photo</td>
        <td>${tour.tourPhoto}</td>
    </tr>
    <tr>
        <td>Tour date</td>
        <td>${tour.tourDate}</td>
    </tr>
    <tr>
        <td>Duration</td>
        <td>${tour.tourDuration}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${tour.tourDescription}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${tour.tourCost}</td>
    </tr>
    <tr>
        <td>Type</td>
        <td>${tour.tourType}</td>
    </tr>
    <tr>
        <td>Hotel</td>
        <td>${tour.hotel}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${tour.country}</td>
    </tr>
</table>

<br>
<a href="/tours">Back</a>
</@c.page>