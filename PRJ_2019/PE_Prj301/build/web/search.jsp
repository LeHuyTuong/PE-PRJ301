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
        <c:import url="welcome.jsp" ></c:import>
            <form action="MainController">
                minimum value <input type="text" name="txtMin" value="${param.txtMin}" /><br/>
            maximum value <input type="text" name="txtMax" value="${param.txtMax}" /><br/>
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${requestScope.SEARCH_VALUE}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ordinary number</th>
                            <th>name</th>
                            <th>brand name</th>
                            <th>description</th>
                            <th>price</th>
                            <th>size</th>
                            <th>quantity</th>
                            <th>Edit Link</th>
                        </tr>
                    </thead>
                    <tbody>  
                        <c:forEach var="dto" items="${result}" >
                        <form action="MainController" method="POST">

                            <tr>
                                <td>${dto.id}
                                    <input type="hidden" name="txtId" value="${dto.id}" />
                                </td>
                                <td>${dto.name}
                                </td>
                                <td>${dto.brandName}</td>
                                <td>
                                    <input type="text" name="txtDescription" value="${dto.description}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPrice" value="${dto.price}" />
                                </td>
                                <td>${dto.size}</td>
                                <td>
                                    <input type="text" name="txtQuantity" value="${dto.quantity}" />
                                </td>
                                <td>
                                    <c:url var="editLink" value="MainController">
                                        <c:param name="action" value="Update" />
                                        <c:param name="pk" value="${dto.id}" />
                                        <c:param name="lastSearchValue" value="${searchValue}" />
                                    </c:url>
                                    <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                    <a href="editLink">Edit Link</a>
                                </td>

                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty searchValue}" >
            No recording
        </c:if>
    </c:if>
</body>
</html>
