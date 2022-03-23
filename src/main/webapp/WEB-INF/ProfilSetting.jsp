<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-03-2022
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TProfil settings</title>
</head>
<body>
<h1>Profil settings</h1>




<form action=ServletLogAf>
    <input type="submit" id="${sessionScope.navn}" name="handling" value="slet konto" onclick="return confirm('Vil du virkelig slette din konto?')" />
</form>

${requestScope.fejl}
<br>
<form action="ServletLogAf">

    <label for="pwd1">Skriv nye password:</label><br>
    <input type="text" id="pwd1" name="pwd1" value=""><br>
    <label for="pwd2">Gentag nye password:</label><br>
    <input type="text" id="pwd2" name="pwd2" value=""><br>

    <input type="submit" value="opdater password" name="handling">


</form>

<br>
<a href="ServletLogAf">Log af og gå til indeks</a>
</body>
</html>
