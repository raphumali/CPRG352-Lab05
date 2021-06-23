<%-- 
    Document   : login
    Created on : Jun 16, 2021, 8:58:57 PM
    Author     : 786097
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="">
        <h1>Login</h1>
        <label for="username" name="username" id="login">Login: </label>
        <input type="text" id="username" name="username"><br>
        <label for="password" name="password" id="password">Password: </label>
        <input type="password" id="title" name="password"><br>
        <input type="submit" value="Login" >
        <p>${message}</p>
        
        </form>
    </body>
</html>
