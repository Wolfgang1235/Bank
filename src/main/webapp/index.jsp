<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<br>
${requestScope.msg}
<br>
<br>
<br>
<br>

<c:forEach items="${applicationScope.kontiMap}" var="item">
    ${item.value.navn} : ${item.value.saldo}
    <br>
</c:forEach>


</body>
</html>