<%-- 
    Document   : createAccount
    Created on : Jul 3, 2025, 10:14:30 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Create Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(6-20 character)<br/>
            <c:if test="${not empty errors.usernameLengthErr}">
                ${errors.usernameLengthErr}
            </c:if>
            <c:if test="${not empty errors.usernameIsExist}">
                ${errors.usernameIsExist}
            </c:if>
            
            Password* <input type="password" name="txtPassword" value="" />(8-20 character)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                ${errors.passwordLengthErr}
            </c:if>
            Confirm* <input type="text" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                ${errors.confirmNotMatch}
            </c:if>
            Fullname* <input type="text" name="txtFullname" value="${param.txtFullname}" />(8-40 character)<br/>
            <c:if test="${not empty errors.fullnameLengthErr}">
                ${errors.fullnameLengthErr}
            </c:if>
            <input type="submit" value="Create" name="btAction" />

        </form>
    </body>
</html>
