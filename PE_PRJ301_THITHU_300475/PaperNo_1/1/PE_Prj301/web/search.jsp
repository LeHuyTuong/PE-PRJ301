<%-- 
    Document   : search
    Created on : Apr 26, 2025, 8:59:02 AM
    Author     : Computing Fundamental - HCM Campus
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
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user} ">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <form action="MainController">
            Name <input type="text" name="txtName" value="${param.txtName}" />
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtName}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}"/>
            <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
            <c:if test="${not empty errors.numberFormat}" >
                ${errors.numberFormat}
            </c:if>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>name</th>
                            <th>description</th>
                            <th>price</th>
                            <th>size</th>
                            <th>status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" >
                        <form action="Update.jsp" method="POST">
                            <tbody>
                                <tr>
                                    <td>
                                        ${dto.id}
                                        <input type="hidden" name="txtID" value="${dto.id}" />
                                    </td>
                                    <td>
                                        ${dto.name}
                                        <input type="hidden" name="txtNamereal" value="${dto.name}" />
                                    </td>
                                    <td>
                                        ${dto.description}
                                        <input type="hidden" name="txtDescription" value="${dto.description}" />

                                    </td>
                                    <td>
                                        ${dto.price}
                                        <input type="hidden" name="txtPrice" value="${dto.price}" />
                                    </td>
                                    <td>
                                        ${dto.size}
                                        <input type="hidden" name="txtSize" value="${dto.size}" />
                                    </td>
                                    <td>
                                        ${dto.status}
                                        <input type="hidden" name="txtStatus" value="${dto.status}" />
                                    </td>
                                    <td>
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                        <input type="submit" value="UpdateLink" name="action" />
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </c:forEach>
                </table>

            </c:if>
            <c:if test="${empty result}">
                No data matching the search criteria found!
            </c:if>
        </c:if>

    </body>
</html>
