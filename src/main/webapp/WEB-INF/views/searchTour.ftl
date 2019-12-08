<#import "parts/common.ftl" as c>
<@c.page>
Tour search page

<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${user.id}">
    <p>Login</p>
    <input title="Login" type="text" name="login" value="${user.login}">
    <p>Name</p>
    <input title="Name" type="text" name="userName" value="${user.userName}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>Password</p>
    <input title="Password" type="text" name="pass" value="${user.pass}">
    <input type="submit" value="OK">
</form>
</@c.page>