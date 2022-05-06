<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 13/04/2022
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consulta de Livro</title>
</head>
<body>
  <form action="buscar-livro" method="post">
      <label for="titulo">TÍTULO DO LIVRO</label>
      <input type="text" id="titulo" name="titulo" placeholder="digite o título"/>
      <input type="submit" value="BUSCAR">
  </form>
</body>
</html>
