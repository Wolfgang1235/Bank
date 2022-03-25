<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-03-2022
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>    ${requestScope.fejl}  </h2>
<br>
<form action="TransaktionServlet">

    <label>Angiv konto nummer du vil bruge til at ${sessionScope.handling}</label><br>
    <input type="text" id="${sessionScope.indsætNummer}" name="kontonr" value="${sessionScope.kontoNummer}"><br>
    <label for="${sessionScope.handling}">Angiv beløb som du vil ${sessionScope.handling}:</label><br>
    <input type="text" id="${sessionScope.handling}" name="beløb" value=0 ><br>
    <input type="submit" value="${sessionScope.handling}" name="handling">
</form>
</body>
</html>
