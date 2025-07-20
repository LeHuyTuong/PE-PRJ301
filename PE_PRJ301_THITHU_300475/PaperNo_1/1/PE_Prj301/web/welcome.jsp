<%-- 
    Document   : welcome
    Created on : Apr 26, 2025, 8:58:34 AM
    Author     : Computing Fundamental - HCM Campus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        Welcome , ${sessionScope.USER_INFO.fullName} <br/>
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user}" >
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <a href="search.jsp">go to search page</a>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
    </body>
</html>
