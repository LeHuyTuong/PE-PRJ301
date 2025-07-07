
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <c:set var="errors" value="${requestScope.CREATE_ERRORS}"/>
            <c:if test="${not empty errors.incorrectUserIDorPassword}">
                ${errors.incorrectUserIDorPassword}
            </c:if>
    </body>
</html>
