<%-- 
    Document   : admin
    Created on : Aug 7, 2024, 11:40:23 AM
    Author     : hoadnt
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Room List Page</title>
    </head>
    <body>
        Welcome, ${sessionScope.USER_INFO.fullName}
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user}" >
            <c:redirect url="login.jsp">
            </c:redirect>
        </c:if>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            name <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <input type="submit" value="Search" name="action" />
        </form>
            <c:set var="searchValue" value="${param.txtSearchValue}" />
            <c:if test="${not empty searchValue}" >
                <c:set var="value" value="${requestScope.SEARCH_VALUE}" />
                <c:if test="${not empty value}" >
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>name</th>
                                <th>description</th>
                                <th>price</th>
                                <th>area</th>
                            </tr>
                        </thead>
                        <c:forEach var="dto" items="${value}" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.id}
                                </td>
                                <td>
                                    ${dto.name}
                                </td>
                                <td>${dto.description}</td>
                                <td>${dto.price}</td>
                                <td>${dto.area}</td>
                            </tr>
                        </tbody>
                        </c:forEach>
                    </table>

                </c:if>
                <c:if test="${empty value}">
                    No recording
                </c:if>
            </c:if>
    </body>
</html>
