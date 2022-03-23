<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-03-2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; meta charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Brugerside</title>
    </head>
    <body>
        <h1>Velkommen ${sessionScope.navn}, du er nu logget ind på din konto</h1>
        Din saldo er ${sessionScope.konto.saldo}

        <br>
        <br>
        <br>

        <a href="LogOutServlet">Log af og gå til index</a>

        <h2>Indsæt</h2>

        <h1>${requestScope.fejl}</h1>

        <form action="TransaktionServlet">
            <label for="indsæt">Angiv beløb:</label><br>
            <input type="text" id="indsæt" name="beløb" value=0><br>
            <input type="submit" value="indsæt">
        </form>

        <br>
        <br>
        <br>

        <h2>Hæv</h2>

        <h1>${requestScope.fejl}</h1>

        <form action="TransaktionServlet" method="post">
            <label for="hæv">Angiv beløb:</label><br>
            <input type="text" id="hæv" name="beløb" value=0><br>
            <input type="submit" value="hæv">
        </form>



    </body>
</html>
