<%-- 
    Document   : login
    Created on : 113
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            UserID <input type="text" name="txtUserID" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="action" />
            <input type="reset" value="Reset" />
        </form>
        <c:import url="error.jsp" >
            
        </c:import>
    </body>
    
</html>

