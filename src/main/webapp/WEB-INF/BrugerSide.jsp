<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-03-2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brugerside</title>
</head>
<body>

<h1>Velkommen ${sessionScope.navn}, du er nu logget ind på din konto</h1>
din saldo er ${sessionScope.konto.saldo}

<br>
<br>

<a href="ServletLogAf">Log af og gå til indeks</a>




<h2>    ${requestScope.fejl}  </h2>

<h2>    ${requestScope.fejl}   </h2>

<form action="TransaktionServlet">

    <p>Hvad ønsker du at gøre?:</p>
    <input type="radio" id="indsæt" name="handling" value="indsæt">
    <label for="indsæt">Indsæt penge</label><br>
    <input type="radio" id="hæve" name="handling" value="hæve">
    <label for="hæve">Hæv penge</label><br>
    <input type="radio" id="overførTilAndenKonto" name="handling" value="overførTilAndenKonto">
    <label for="overførTilAndenKonto">Overføre til anden konto</label><br>
    <input type="radio" id="nedlægKonto" name="handling" value="nedlægKonto">
    <label for="nedlægKonto">Nedlæg konto</label><br>
    <input type="radio" id="skiftPassword" name="handling" value="skiftPassword">
    <label for="skiftPassword">Skift password</label><br><br>
    <input type="submit" value="Submit">
</form>


<h2>    ${requestScope.fejl} <br>  </h2>



</body>
</html>

