<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product Page</title>
    </head>
    <body>
        Welcome . ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            name <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}" >
            <c:set var="result" value="${requestScope.SEARCH_VALUE}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>name</th>
                            <th>description</th>
                            <th>price</th>
                            <th>size</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}"  varStatus="counter"> 
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
                                <td>
                                    ${dto.description}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.size}
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty result}" >
                No recording
            </c:if>
        </c:if>
    </body>
</html>
