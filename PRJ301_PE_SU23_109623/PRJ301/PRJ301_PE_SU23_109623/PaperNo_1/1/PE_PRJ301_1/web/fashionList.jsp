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
        <title>Admin Page</title>
    </head>
    <body>
        welcome, ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            searchValue <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>name</th>
                            <th>price</th>
                            <th>size</th>
                            <th>description</th>
                            <th>status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tbody>
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.id}
                                        <input type="hidden" name="txtID" value="${dto.id}" />
                                    </td>
                                    <td>

                                        <input type="text" name="txtName" value="${dto.name}" />
                                    </td>
                                    <td>

                                        <input type="text" name="txtPrice" value="${dto.price}" />
                                    </td>
                                    <td>

                                        <input type="text" name="txtSize" value="${dto.size}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtDescription" value="${dto.description}" />
                                    </td>
                                    <td>
                                        ${dto.status}
                                    </td>
                                    <td>
                                        <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}" />
                                        <input type="submit" value="Update" name="action" />
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </c:forEach>
                </table>
                <c:set var="errors" value="${requestScope.CREATE_ERROR}" />
                <c:if test="${not empty errors.numberFormatWrong}">
                    ${errors.numberFormatWrong}
                </c:if>

            </c:if>
            <c:if test="${empty result}">
                No Recording
            </c:if>
        </c:if>

    </body>
</html>
