<%-- 
    Document   : paintingList
    Created on : Jul 5, 2025, 5:23:12 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Welcome, ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
    </body>
</html>
