<%--
  Created by IntelliJ IDEA.
  User: ghenn
  Date: 15.04.2021
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Login Form</title>
        <style>
            .failed {
                color: red;
            }
        </style>
    </head>

    <body>

        <h3>
            My Custom Login Page
        </h3>

        <form:form action="${pageContext.request.contextPath}/authentificateTheUser"
                    method="POST">
            <c:if test="${param.error != null}">
                <i class="failed">Sorry! You entered invalid username/password.</i>
            </c:if>

            <c:if test="${param.logout != null}">

                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                    You have been logged out.
                </div>

            </c:if>

            <p>
                User name: <input type="text" name="username">
            </p>

            <p>
                Password: <input type="password" name="password">
            </p>

            <input type="submit" value="Login">

        </form:form>


    </body>
</html>
