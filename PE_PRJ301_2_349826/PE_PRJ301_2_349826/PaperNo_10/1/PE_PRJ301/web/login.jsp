<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
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
            userID <input type="text" name="txtUserID" value="" /><br/>
            password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="action" />
        </form>
        <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
         ${errors}
        <c:if test="${not empty errors.notMatch}" >
            ${errors.notMatch}
        </c:if>
    </body>
    
</html>

