<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ghenn
  Date: 27.03.2021
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student confirmation</title>
    </head>

    <body>

        The student is confirmed: ${student.lastName} ${student.firstName}
        <br><br>
        This student is from: ${student.country}
        <br><br>
        His favorite programming language is : ${student.favoriteLanguage}
        <br><br>
        Operating Systems:
            <ul>
                <c:forEach var="temp" items="${student.operatingSystems}">
                <li>${temp}</li>
                </c:forEach>
            </ul>
    </body>
</html>
