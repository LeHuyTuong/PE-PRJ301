<%-- 
    Document   : search
    Created on : Jul 3, 2025, 5:54:04 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Welcome , ${sessionScope.USER_INFO.fullname}

        <h1>Search Page</h1>

        <form action="DispatchServlet">
            SearchValue <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <input type="submit" value="Search" name="btAction" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}" >
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"  />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tbody>

                            <tr>
                                <td>
                                    ${counter.count}
                                    .
                                </td>
                                <td>${dto.username}</td>
                                <td>${dto.password}</td>
                                <td>${dto.fullname}</td>
                                <td>${dto.role}</td>
                                <td>
                                    <c:url var="deleteLink" value="DispatchServlet">
                                        <c:param name="btAction" value="Delete" />
                                        <c:param name="pk" value="${dto.username}" />
                                        <c:param name="lastSearchValue" 
                                                 value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </c:if>
                <c:if test="${empty result}">
                    <font color="red">
                    No Recording
                    </font>
                </c:if>
            </c:if>

        </table>


    </body>
</html>