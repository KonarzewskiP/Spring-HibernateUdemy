<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 07/09/2020
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>
<%--  Spring will call student.getCountry() --%>
Country: ${student.country}
<br><br>
<%--  Spring will call student.getFavoriteLanguage() --%>
Favourite Language: ${student.favoriteLanguage}
<br><br>
<%--  Spring will call student.getOperatingSystems() --%>
Favourite Operating System:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>
