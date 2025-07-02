<%-- 
    Document   : search
    Created on : Jul 1, 2025, 9:20:16 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Welcome, ${sessionScope.USER_INFO.fullName}</h1>
        <h1>Search Page</h1>
        <form name="DispatchServlet">
            Search Value<input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        
        <c:set var="searchValue" value="${param.txtSearchValue}param.txtSearchValue}}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>fullName</th>
                            <th>role</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            .</td>
                            <td>${dto.username}</td>
                            <td>${dto.password}</td>
                            <td>${dto.fullName}</td>
                            <td>${dto.role}</td>
                            
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <font color="red">
                    No have record
                </font>
            </c:if>
        </c:if>
        
    </body>
</html>
