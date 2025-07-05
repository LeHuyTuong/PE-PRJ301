<%-- 
    Document   : login
    Created on : Jul 5, 2025, 5:23:03 PM
    Author     : USER
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
        <h1>Login</h1>
        <form action="MainController" method="POST">
            userID <input type="text" name="txtUserID" value="" /> <br/>
            password <input type="password" name="txtPassword" value="" /> <br/>
            <input type="submit" value="Login" name="action" />
            <input type="reset" value="Reset" />
        </form>
        
        <c:set var="errors" value="${requestScope.CREATE_ERR}" />
        <c:if test="${not empty errors.passwordNotCorrect}">
            ${errors.passwordNotCorrect}
        </c:if>
    </body>
</html>
