<%-- 
    Document   : login
    Created on : Apr 26, 2025, 8:58:20 AM
    Author     : Computing Fundamental - HCM Campus
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
        <h2>Login page</h2>
        <form action="MainController" method="POST">
            userID <input type="text" name="txtUserID" value="" /><br/>
            password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="action" />
        </form>
        <c:set var="errors" value="${requestScope.CREATE_ERROR}" />
        <c:if test="${not empty errors.invalidUserOrPassword}" >
            ${errors.invalidUserOrPassword}
        </c:if>
    </body>
</html>
