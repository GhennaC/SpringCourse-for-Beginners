<%--
  Created by IntelliJ IDEA.
  User: ghenn
  Date: 28.03.2021
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Customer Confirmation Page</title>
    </head>

    <body>

    The customer is confirmed: ${customer.firstName} ${customer.lastName}<br>
    The customer has : ${customer.freePasses} freePasses<br>
    The customer's postal code is : ${customer.postalCode}<br>
    The customer's course code is : ${customer.courseCode}<br>

    </body>
</html>
