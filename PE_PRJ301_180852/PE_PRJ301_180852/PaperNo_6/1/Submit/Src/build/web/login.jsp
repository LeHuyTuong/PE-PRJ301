<%-- 
    Document   : login
    Created on : Aug 7, 2024, 11:04:18 AM
    Author     : hoadnt
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
        <h1>Login Information</h1>
        <form action="MainController" method="POST">
            userID <input type="text" name="txtUserID" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="action" />
            <input type="reset" value="Reset" />
        </form>
        <c:set var="errors" value="${requestScope.CREATE_ERR}"/>
        <c:if test="${not empty errors.userNotMatch}" >
            ${errors.userNotMatch}
        </c:if>
    </body>
</html>
