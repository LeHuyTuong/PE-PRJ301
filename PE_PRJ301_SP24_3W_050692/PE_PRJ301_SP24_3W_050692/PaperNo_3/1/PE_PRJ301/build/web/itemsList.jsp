<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
    </head>
    <body>
        ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            Value 1 <input type="text" name="txtValue1" value="${param.txtValue1}" /><br/>
            Value 2 <input type="text" name="txtValue2" value="${param.txtValue2}" /><br/>
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue1" value="${param.txtValue1}" />
        <c:set var="searchValue2" value="${param.txtValue2}" />
        <c:if test="${not empty searchValue1 or not empty searchValue2}" >
            <c:set var="result" value="${requestScope.SEARCH_VALUE}"/>
            <c:if test="${not empty result}" >
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>name</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>subtotal</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${result}" varStatus="counter">       
                    <tbody>
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.itemID}
                            </td>
                            <td>
                                ${dto.name}
                            </td>
                            <td>
                                ${dto.price}
                            </td>
                            <td>
                                ${dto.quantity}
                            </td>
                            <td>
                                ${dto.price * dto.quantity}
                            </td>
                            <td>
                                
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
