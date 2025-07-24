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
        <style>
            .link{
                color : red;
            }
        </style>
    </head>
    <body>
        <font color ="red"> 
        Welcome ${sessionScope.USER_INFO.fullName} !
        </font>
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            Criteria for searching <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}" >
            <c:set var="result" value="${requestScope.SEARCH_VALUE}"/>
            <c:if test="${not empty result}" >
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Location</th>
                            <th>Description</th>
                            <th>Posted Date</th>
                            <th>Price</th>
                            <th>Tool</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" >
                        <c:set var="status" value="${dto.status}" />
                        <c:if test="${status != -2}" >


                            <tbody>
                                <tr>
                                    <td>
                                        ${dto.id}
                                    </td>
                                    <td>
                                        ${dto.title}
                                    </td>
                                    <td>
                                        ${dto.location}
                                    </td>
                                    <td>
                                        ${dto.description}
                                    </td>
                                    <td>
                                        ${dto.postedDate}
                                    </td>
                                    <td>
                                        ${dto.price}
                                    </td>
                                    <td>

                                        <c:if test="${status != 1}" >
                                            <c:url var="deleteLink" value="MainController">
                                                <c:param name="action" value="Delete" />
                                                <c:param name="pk" value="${dto.id}" />
                                                <c:param name="lastSearchValue" value="${searchValue}" />
                                            </c:url>
                                            <a class="link" href="${deleteLink}" color ="red">Delete</a>
                                        </c:if>
                                    </td>

                                </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <font color ="red"> 
                No data matching the search criteria found!
                </font>
            </c:if>
        </c:if>


    </body>
</html>
