<%-- 
    Document   : createAccount
    Created on : Jul 3, 2025, 4:48:35 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERROR}" />
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" /> <6-20 character> <br/>
            <c:if test="${not empty errors.usernameNotLength}">
                <font color="red">
                ${errors.usernameNotLength}<br/>
                </font>
            </c:if>
            <c:if test="${not empty errors.usernameIsExist}">
                <font color="red">
                ${errors.usernameIsExist}<br/>
                </font>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" /> <8-20 character> <br/> 
            <c:if test="${not empty errors.passwordNotLength}">
                <font color="red">
                ${errors.passwordNotLength}<br/>
                </font>
            </c:if>
            Confirm* <input type="text" name="txtConfirm" value="" /> <br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch}<br/>
                </font>
            </c:if>
            Fullname* <input type="text" name="txtFullname" value="${param.txtFullname}" /> <8-40 character> <br/>
            <c:if test="${not empty errors.fullnameNotLength}">
                <font color="red">
                ${errors.fullnameNotLength}<br/>
                </font>
            </c:if>
            <input type="submit" value="Signin" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
