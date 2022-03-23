<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-03-2022
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret Bruger</title>
</head>
<body>

<h1>Opret bruger</h1>

${requestScope.fejl}
<br>
<form action="ServletOpretBruger">
    <label for="name">Angiv navn på kontohaver:</label><br>
    <input type="text" id="name" name="navn" value=""><br>
    <label for="pwd1">Skriv password:</label><br>
    <input type="text" id="pwd1" name="pwd1" value=""><br>
    <label for="pwd2">Gentag password:</label><br>
    <input type="text" id="pwd2" name="pwd2" value=""><br>

    <input type="submit" value="opret" name="handling">


</form>
</body>
</html>
