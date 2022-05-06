<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 04/05/2022
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<h1>Cadastro de Usuário</h1>
<form action="cadastrar-usuario" method="post">
    <label for="email">E-MAIL</label>
    <input type="text" id="email" name="email" placeholder="digite o e-mail"/>
    <label for="senha">SENHA</label>
    <input type="password" id="senha" name="senha" placeholder="digite a senha"/>
    <input type="submit" value="CADASTRAR">
</form>
</body>
</html>
