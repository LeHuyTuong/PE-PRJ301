<%-- 
    Document   : welcome
    Created on : Apr 26, 2025, 8:58:34 AM
    Author     : Computing Fundamental - HCM Campus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <style>
        .logout{
            margin-left: 70%;
        }
    </style>
    <body>
        <font color="red">
                Welcome , ${sessionScope.USER_INFO.fullName}
        </font> 
        <form action="MainController">
            <input class="logout" type="submit" value="Logout" name="btAction" />
        </form>
    </body>
</html>
