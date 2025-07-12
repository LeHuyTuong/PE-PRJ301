<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of the appointments </title>
    </head>
    <body>
        <h1>The appointments</h1>
        <hr/>
        Welcome , ${sessionScope.USER_INFO.fullName}
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <a href="create.jsp">Link Create</a>
        <c:set var="items" value="${requestScope.VALUE}" />
        <c:if test="${not empty items}" >
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>account</th>
                        <th>partnerPhone</th>
                        <th>partnerName</th>
                        <th>timeToMeet</th>
                        <th>place</th>
                        <th>expense</th>
                        <th>note</th>
                    </tr>
                </thead>
                <c:forEach var="dto" items="${items}" varStatus="counter" >

                    <tbody>
                        <tr>
                            <th>
                                ${counter.count}
                            </th>
                            <th>
                                ${dto.idApp}
                            </th>
                            <th>
                                ${dto.account}
                            </th>
                            <th>
                                ${dto.partnerPhone}
                            </th>
                            <th>
                                ${dto.partnerName}
                            </th>
                            <th>
                                ${dto.timeToMeet}
                            </th>
                            <th>
                                ${dto.place}
                            </th>
                            <th>
                                ${dto.expense}
                            </th>
                            <th>
                                ${dto.note}
                            </th>
                        </tr>
                    </tbody>
                </c:forEach> 

            </table>


        </c:if>

    </body>
</html>
