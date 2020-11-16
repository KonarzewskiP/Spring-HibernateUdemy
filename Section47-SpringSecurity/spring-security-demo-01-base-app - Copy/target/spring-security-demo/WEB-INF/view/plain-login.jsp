<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 16/11/2020
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>
        Custom Login Page
    </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 class="row justify-content-md-center"> My Custom Login Page </h3>
    <div class="row justify-content-md-center">

        <div id="login-page">
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                       method="post">

                <%-- check for login error --%>

                <c:if test="${param.error != null}">
                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                        Sorry! You entered invalid username/password.
                    </div>
                </c:if>

                <%-- check for loggout --%>

                <c:if test="${param.logout != null}">
                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                        You have been logged out.
                    </div>
                </c:if>


                <p>
                    User name: <input type="text" name="username"/>
                </p>
                <p>
                    Password: <input type="password" name="password"/>
                </p>

                <input type="submit" value="Login"/>

            </form:form>
        </div>
    </div>
</div>
</body>

</html>
