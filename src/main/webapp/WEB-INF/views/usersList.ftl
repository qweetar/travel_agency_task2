<#import "parts/common.ftl" as c>
<@c.page>
List of Users page
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Login</th>
    </tr>

    <#list users as user>
        <tr>
            <td><a href="/user/${user.id}">${user.id}</a></td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.login}</td>
            <td><a href="/delete/${user.id}">Delete</a></td>
            <td><a href="/update/${user.id}">Update</a></td>
        </tr>
    </#list>
</table>

<a href="/addUser">Create user</a>
</@c.page>