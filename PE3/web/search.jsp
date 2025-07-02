<%-- 
    Document   : search
    Created on : Jul 2, 2025, 3:39:27 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SEARCH PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        .logout{
            margin-left: 70%;
        }
    </style>
    <body>
        <font color="red">
        Welcome , ${sessionScope.USER_INFO.username}
        </font>
        <form action="DispatchServlet">
            <input class="logout" type="submit" value="Logout" name="btAction" />
        </form>
        <form action="DispatchServlet">
            Search Value <input type="text" name="txtSearchValue" value="btAction" />
            <input type="submit" value="Search" name="btAction" />
        </form>
    </body>
</html>