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
<a href="/users">Back</a>
</@c.page>