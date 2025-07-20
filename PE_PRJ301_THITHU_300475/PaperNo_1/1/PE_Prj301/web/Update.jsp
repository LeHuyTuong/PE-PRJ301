<%-- 
    Document   : Update
    Created on : Jul 18, 2025, 8:38:55 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update product from</h1>
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user}" >
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        
        <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
        <c:if test="${not empty errors.numberFormat}" >
            ${errors.numberFormat}
        </c:if>
        
        <form action="MainController" method="POST">
            
        ID <input type="text" name="txtID" value="${param.txtID}" readonly="readonly" /> <br/>
        Product name <input type="text" name="txtNamereal" value="${param.txtNamereal}" /> <br/>
        Description <input type="text" name="txtDescription" value="${param.txtDescription}" /> <br/>
        Price <input type="text" name="txtPrice" value="${param.txtPrice}" /> <br/>
        Size <input type="text" name="txtSize" value="${param.txtSize}" /> <br/>
        <input type="hidden" name="lastSearchValue" value="${param.lastSearchValue}" />
        <input type="submit" value="Update" name="action" />
        
        </form>
        
    </body>
</html>
