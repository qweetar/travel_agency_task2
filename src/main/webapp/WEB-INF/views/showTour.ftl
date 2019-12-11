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
        <td><img src="${tour.tourPhoto}"/></td>
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
        <td><a href="/hotel/${tour.hotel.hotelId}">${tour.hotel.hotelName}</a></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><a href="/country/${tour.country.countryId}">${tour.country.countryName}</a></td>
    </tr>
</table>
<br>
    <div>
        <table>
            <tr>
                <th>Id</th>
                <th>Date</th>
                <th>Review</th>
                <th>User</th>
            </tr>

            <#list reviews as review>
                <tr>
                    <td>${review.reviewId}</td>
                    <td>${review.reviewDate}</td>
                    <td>${review.reviewText}</td>
                    <td>${review.user.userName}</td>
                    <td><a href="/deleteReview/${review.reviewId}">Delete</a></td>
                    <td><a href="/updateReview/${review.reviewId}">Update</a></td>
                </tr>
                <#else>
                No reviews
            </#list>
        </table>
    </div>
<br>
<a href="/tours">Back</a>
</@c.page>