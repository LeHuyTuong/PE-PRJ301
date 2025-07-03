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
                            <th>Update</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DispatchServlet">
                        <tbody>

                            <tr>
                                <td>
                                    ${counter.count}
                                    .
                                </td>
                                <td>${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>${dto.fullname}</td>
                                <td>
                                    <input type="checkbox" name="chkRole" value="ON" />
                                    <c:if test="${dto.role}">
                                        checked = "checked"
                                    </c:if>
                                        />
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="DispatchServlet">
                                        <c:param name="btAction" value="Delete" />
                                        <c:param name="pk" value="${dto.username}" />
                                        <c:param name="lastSearchValue" 
                                                 value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    
                                    <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                    <input type="submit" value="Update" name="btAction" />
                                    
                                </td>
                            </tr>
                        </tbody>
                        </form>
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