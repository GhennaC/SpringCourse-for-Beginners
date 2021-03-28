<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ghenn
  Date: 27.03.2021
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student form</title>
    </head>
    <body>

    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName"></form:input>

        <br><br>

        Last name: <form:input path="lastName"></form:input>
        <br><br>

        <form:select path="country">

            <form:options items="${student.countryOptions}"/>

        </form:select>
        <br><br>

        Favorite Language:
        <form:radiobuttons path="favoriteLanguage"
                           items="${student.favoriteLanguageOptions}"/>

        <br><br>

        Operating Systems:

        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Windows <form:checkbox path="operatingSystems" value="Windows" />
        MacOS <form:checkbox path="operatingSystems" value="MacOS" />

        <br><br>

        <input type="submit" value="Submit" />
    </form:form>


    </body>
</html>
