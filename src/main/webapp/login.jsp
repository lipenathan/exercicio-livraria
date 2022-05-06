<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 04/05/2022
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Página de login</title>
</head>
<body>
    <form method="post" action="logar">
        <label for="email">E-mail</label>
        <input type="text" placeholder="e-mail" id="email" name="email">
        <label for="email">Senha</label>
        <input type="password" placeholder="senha" id="senha" name="senha">
        <input type="submit" value="Logar">
    </form>
</body>
</html>
