<%-- 
    Document   : editCurrencyRate
    Created on : Jul 19, 2025, 8:19:16 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Currency Rate</title>
        <style>

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
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            form {
                max-width: 400px;
                margin: 0 auto;
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            input {
                width: 100%;
                padding: 10px;
                margin-bottom: 16px;
                box-sizing: border-box;
            }

            button {
                background-color: #333;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>
    </head>

    <body>


        <header>
            <h1>Currency Exchange Rates</h1>
        </header>

        <c:set var="url" value="${requestScope.URL}" />

        <nav>
            <a href="${url}">Currency List</a>
            <a href="#">Welcome, ${sessionScope.USER_INFO.fullName}</a>
            <a href="MainController?action=Logout" >
                Logout
            </a>
        </nav>

        <h2>Update Currency Rate</h2>
        <c:set var="result" value="${requestScope.Code}" />
        <form id="updateCurrencyForm" action="MainController"  >
            <label for="code">Code: ${result}</label>
            <input type="hidden" id="code" name="code" value="${result}" required>
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="" required>

            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>

            <label for="rate">Rate:</label>
            <input type="number" id="rate" name="rate" step="0.01" required>

            <input type="submit" value="Update Rate" name="action" onclick="updateCurrency()">
        </form>

        <c:set var="errors" value="${requestScope.CREATE_ERR}" />
        <c:if test="${empty errors.emptyRate}" >
            <script>
                function updateCurrency() {
                    // Add your logic here to handle the form submission
                    // You can use JavaScript to send the form data to a server for processing
                    // For this example, we're keeping it simple with just the form structure
                    alert("Currency rate updated successfully!");
                }
            </script>
        </c:if>
        <c:if test="${not empty errors.emptyRate}" >
            ${errors.emptyRate}
        </c:if>
    </body>

</html>
