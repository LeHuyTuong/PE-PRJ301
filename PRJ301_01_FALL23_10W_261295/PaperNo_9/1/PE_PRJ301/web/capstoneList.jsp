<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capstone list</title>
    </head>
    <body>
        Welcome ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>

        <form action="MainController">
            Search Value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="action" />
        </form>

        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Description</th>
                            <th>userID</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.capstoneID}
                                </td>
                                <td>
                                    ${dto.description}
                                </td>
                                <td>
                                    ${dto.userID}
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="Delete" />
                                        <c:param name="pk" value="${dto.capstoneID}" />
                                        <c:param name="lastSearchValue" value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty result}">
                No recording
            </c:if>
        </c:if>

    </body>
</html>
