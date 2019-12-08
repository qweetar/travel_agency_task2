<#import "parts/common.ftl" as c>
<@c.page>
<div>List of Tours page</div>
<form method="get" action="/searchTour">
    <h3>Select a country</h3>
    <input type="text" name="country"><br>
    <h3>Select a tour date</h3>
    <input type="date" name="tour_date"><br>
    <h3>Select trip duration</h3>
    <input type="number" min="1" max="30" name="tourDuration"><br>
    <h3>Select tour price</h3>
    <input type="number" min="1" max="5000" name="tourPrice"><br>
    <h3>Select a number of hotel stars</h3>
    <input type="number" min="1" max="5" name="numStars"><br>
    <h3>Select tour type</h3>
    <p><select name="tourType" size="3" multiple>
            <option value=""></option>
            <option value="BUS_TOUR">Bus Tour</option>
            <option value="SPORT_TOUR">Sport Tour</option>
            <option value="SEA_VACATION">Sea Vacation</option>
            <option value="EVENT_TOUR">Event Tour</option>
            <option value="RECRIATION">Recreation</option>
            <option value="FESTIVAL">Festival</option>
            <option value="HEALTH">Health</option>
        </select></p>
    <button type="submit">Search</button>
</form>
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
            <td><a href="/deleteTour/${tour.tourId}">Delete</a></td>
            <td><a href="/updateTour/${tour.tourId}">Update</a></td>
        </tr>
    </#list>
</table>
</div>
</@c.page>