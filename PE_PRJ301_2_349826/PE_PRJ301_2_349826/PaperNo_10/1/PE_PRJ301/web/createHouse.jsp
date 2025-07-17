<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House List</title>
    </head>
    <body>
        Welcome, ${sessionScope.USER_INFO.name}
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <c:set var="errors" value="${requestScope.ERROR}" />
        <form action="MainController" method="POST">
            id <input type="text" name="txtID" value="" /><br/>
            <c:if test="${not empty errors.notFormat}">
                ${errors.notFormat}
            </c:if>
            <c:if test="${not empty errors.duplicateID}">
                ${errors.duplicateID}
            </c:if>
            name <input type="text" name="txtName" value="" /><br/>
            description<input type="text" name="txtDescription" value="" /><br/>
            price <input type="text" name="txtPrice" value="" /><br/>
            <c:if test="${not empty errors.dataType}">
                ${errors.dataType}
            </c:if>
            size <input type="text" name="txtSize" value="" /><br/>
            <c:if test="${not empty errors.dataType}">
                ${errors.dataType}
            </c:if>
            <input type="submit" value="Create" name="action" />
        </form>
    </body>
</html>
