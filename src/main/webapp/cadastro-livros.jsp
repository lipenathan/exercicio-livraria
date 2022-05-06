<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 06/04/2022
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de livros</title>
</head>
<body>
<h1>Cadastro de livros</h1>
<form action="cadastrar-livro" method="post">
    <label for="titulo">TÍTULO</label>
    <input type="text" id="titulo" name="titulo" placeholder="digite o título"/>
    <label for="categoria">CATEGORIA</label>
    <input type="text" id="categoria" name="categoria" placeholder="digite a categoria"/>
    <label for="autor">autor</label>
    <input type="text" id="autor" name="autor" placeholder="digite o autor"/>
    <input type="submit" value="CADASTRAR">
</form>
</body>
</html>
