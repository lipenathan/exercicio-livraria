<%@ page import="com.github.lipenathan.exerciciolivraria.dao.LivroDao" %>
<%@ page import="com.github.lipenathan.exerciciolivraria.model.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.lipenathan.exerciciolivraria.ListarLivroServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.github.lipenathan.exerciciolivraria.model.Livro" %>
<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 06/04/2022
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Livro livro = (Livro) request.getSession().getAttribute("Livro");
%>
<html>
<head>
    <title>Lista de Livros</title>
</head>
<body>
<h1>Lista de livros</h1>
<table>
    <tr>
    <th>Título</th>
    <th>Categoria</th>
    <th>Autor</th>
    </tr>
    <tr>
        <td> ${livro.getTitulo()} </td>
        <td> ${livro.getCategoria()} </td>
        <td> ${livro.getAutor()} </td>
    </tr>
</table>
</body>
</html>
