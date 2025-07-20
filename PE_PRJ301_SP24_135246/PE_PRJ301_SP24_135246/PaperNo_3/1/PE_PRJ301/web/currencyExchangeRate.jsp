<%-- 
    Document   : currencyExchangeRate
    Created on : Jul 19, 2025, 6:33:34 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Currency Exchange</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            header {
                background-color: #333;
                padding: 10px;
                color: #fff;
                text-align: center;
            }

            nav {
                margin-bottom: 20px;
            }

            nav a {
                text-decoration: none;
                color: #333;
                padding: 10px;
                margin-right: 10px;
                border-radius: 5px;
                background-color: #eee;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #333;
                color: #fff;
            }
        </style>
    </head>

    <body>
        <header>
            <h1>Currency Exchange Rates</h1>
        </header>
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <nav>
            <a href="#">Currency List</a>
            <a href="#">Welcome, ${sessionScope.USER_INFO.fullName}</a>
            <a href="MainController?action=Logout" >
                Logout
            </a>
        </nav>

        <form id="searchForm" action="MainController" >
            <label for="code">Code:</label>
            <input type="text" id="code" name="code" value="${param.code}">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${param.name}">

            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchName" value="${param.name}" />
        <c:set var="searchCode" value="${param.code}" />
        <c:if test="${not empty searchName or not empty searchCode}">
            <c:set var="result" value="${requestScope.SEARCH_VALUE}" />
            <c:if test="${not empty result}">
                <table>
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Rate</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" >
                        <form action="MainController">
                            <tbody>
                                <tr>
                                    <td>
                                        ${dto.code}
                                        <input type="hidden" name="txtCode" value="${dto.code}" />
                                    </td>
                                    <td>
                                        ${dto.name}
                                        <input type="hidden" name="txtName" value="${dto.name}" />
                                    </td>
                                    <td>
                                        ${dto.description}
                                    </td>
                                    <td>
                                        ${dto.rate}
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="action"/>
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty result}">
                No Recording
            </c:if>
        </c:if>
    </body>
</html>
