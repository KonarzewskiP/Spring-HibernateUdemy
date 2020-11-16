<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 14/11/2020
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lov2Code Company Home Page</title>
</head>
<body>
<h2>Hey Welcome to the Lov2Code Company</h2>
<hr>
<p>
    Welcome Stranger!
</p>

<%-- Add a logout button --%>
<form:form action="${pageContext.request.contextPath}/logout"
       method="POST">

    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
