<#macro login path>

    <form name="user" action="${path}" method="post">
        <p>Login</p>
        <input title="Login" type="text" name="login">
        <p>Name</p>
        <input title="Name" type="text" name="userName">
        <p>Email</p>
        <input title="Email" type="text" name="email">
        <p>Password</p>
        <input title="Password" type="text" name="pass">
        <input type="submit" value="OK">
    </form>
</#macro>