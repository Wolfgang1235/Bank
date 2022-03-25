<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Business Banken forside</title>
</head>
<body>

<h1>Business Banken</h1>

${requestScope.msg}
${requestScope.fejl}
<br>
<br>

<c:forEach items="${applicationScope.kontiMap}" var="item">
    ${item.value.navn} : ${item.value.saldo}  : kontonr ${item.value.kontoNummer} : pwd ${item.value.kode} : brugere ${item.value.brugerListe} : kassekredit ${item.value.kasseKredit}
    : ${item.value.transaktionsListe} <br>
    <br>
</c:forEach>
<br>
<form action="LogIn">
    <label for="fname">Angiv navn på kontohaver:</label><br>
    <input type="text" id="fname" name="navn" value="long"><br>
    <label for="lname">Skriv kode:</label><br>
    <input type="text" id="lname" name="koden" value="1"><br><br>
    <input type="submit" value="log in">
</form>
<br>
<br>

<form action=ServletOpretBruger>
    <input type="submit" value="Opret ny bruger" name="handling"/>
</form>

</body>
</html>
