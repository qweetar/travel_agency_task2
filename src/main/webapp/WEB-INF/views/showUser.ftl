<#import "parts/common.ftl" as c>
<@c.page>
User page
<table>
    <tr>
        <td>Id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>Login</td>
        <td>${user.login}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
</table>
    <br>
    <a href="/tourByUser/${user.id}">User reserved Tours</a>
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
<a href="/users">Back</a>
</@c.page>