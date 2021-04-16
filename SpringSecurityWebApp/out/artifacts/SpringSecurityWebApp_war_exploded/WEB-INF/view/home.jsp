<%--
  Created by IntelliJ IDEA.
  User: ghenn
  Date: 14.04.2021
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>HOME</title>
</head>
  <body>

  <h2> Company Home Page</h2>

    <p>
      Welcome to our Company.
    </p>

    <p>
      User: <security:authentication property="principal.username" />
      <br><br>
      Role(s): <security:authentication property="principal.authorities" />
    </p>
  <security:authorize access="hasRole('MANAGER')">

    <hr>
    <p>
      <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
      (Only for Manager peeps)
    </p>
    <hr>

  </security:authorize>

  <security:authorize access="hasRole('BOSS')">

    <hr>
    <p>
      <a href="${pageContext.request.contextPath}/systems">Boss Meeting</a>
      (Only for Boss peeps)
    </p>
    <hr>

  </security:authorize>




    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
      <input type="submit" value="Logout" />
    </form:form>
  </body>
</html>
