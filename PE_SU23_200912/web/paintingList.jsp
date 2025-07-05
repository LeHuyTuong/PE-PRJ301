<%-- 
    Document   : paintingList
    Created on : Jul 5, 2025, 5:23:12 PM
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
        Welcome, ${sessionScope.USER_INFO.fullName} <br/>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>

        <form action="MainController">
            description <input type="text" name="txtDescription" value="${param.txtDescription}" /> 
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtDescription}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}" />
            <c:if test="${not empty result}" >
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>id</th>
                            <th>description</th>
                            <th>height</th>
                            <th>width</th>
                            <th>price</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter" >
                        <form action="MainController" method="POST">
                            <tbody>
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.creator}
                                    </td>
                                    <td>
                                        ${dto.description}
                                    </td>
                                    <td>
                                        ${dto.height}
                                    </td>
                                    <td>
                                        ${dto.width}
                                    </td>
                                    <td>
                                        ${dto.price}
                                    </td>
                                    <td>                            
                                        <input type="hidden" name="txtID" value="${dto.id}" />
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                        <input type="submit" value="Delete" name="action" />
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty result}">
                No recording
            </c:if>
        </c:if>
    </body>
</html>
