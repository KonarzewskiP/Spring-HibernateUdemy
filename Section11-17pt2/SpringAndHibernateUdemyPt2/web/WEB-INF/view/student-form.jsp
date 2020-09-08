<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 07/09/2020
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- allow to use form tags --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name:<form:input path="firstName"/>

    <br><br>

    Last name:<form:input path="lastName"/>

    <br><br>

    Country:

    <form:select path="country">
        <form:options items="${theCountryOptions}"/>
    </form:select>

<%--  items refer to the collection of data  --%>
<%--
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
--%>

<%--
    <form:select path="country">
        <form:option value="Brazil" label="Brazil"/>
        <form:option value="France" label="France"/>
        <form:option value="Germany" label="Germany"/>
        <form:option value="India" label="India"/>

    </form:select>
--%>

    <br><br>

    Favorite Language:
<%--    on submit Spring will call student.setFavoriteLanguage()  --%>
<%--    Java <form:radiobutton path="favoriteLanguage" value="Java" />
    C# <form:radiobutton path="favoriteLanguage" value="C#" />
    PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />--%>

    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />

    <br><br>

    Operating Systems:

    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
    MS Windows <form:checkbox path="operatingSystems" value="MS Window" />


    <input type="submit" value="Submit">
</form:form>

</body>
</html>

<%-- When form is loaded, Spring MVC will call:
        student.getFirstName()
        student.getLastName()   --%>

<%-- When form is sumbitted, Spring MVC will call:
        student.setFirstName()
        student.setLastName()   --%>