<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating an appointment </title>
    </head>
    <body>
        <h1>Creating appointment</h1>
        <hr/>
        <c:set var="errors" value="${requestScope.CREATE_ERROR_APP}" />

        <form action="MainController" method="POST">

            <input type="hidden" name="btAccount" value="${sessionScope.USER_INFO.roleDB}" />

            partnerPhone <input type="text" name="btPhone" value="${param.btPhone}" /> <br/>
            <c:if test="${not empty errors.phoneFormat}" >
                ${errors.phoneFormat} <br/>
            </c:if>
            partnerName <input type="text" name="btName" value="${param.btName}" /><br/>
            <c:if test="${not empty errors.nameFormat}" >
                ${errors.nameFormat} <br/>
            </c:if>
            timeToMeet	 <input type="text" name="btTime" value="${param.btTime}" /><br/>
            <c:if test="${not empty errors.wrongTimeFormat}" >
                ${errors.wrongTimeFormat}  <br/>
            </c:if>
            place <input type="text" name="btPlace" value="${param.btPlace}" /><br/>
            <c:if test="${not empty errors.emptyInfo}" >
                ${errors.emptyInfo} <br/>
            </c:if>
            expense <input type="text" name="btExpense" value="${param.btExpense}" /><br/>
            <c:if test="${not empty errors.wrongExpenseFormat}" >
                ${errors.wrongExpenseFormat} <br/> 
            </c:if>
            note <input type="text" name="btNote" value="${param.btNote}" /><br/>

            <input type="submit" value="Create" name="action" /><br/>
        </form>

    </body>
</html>
