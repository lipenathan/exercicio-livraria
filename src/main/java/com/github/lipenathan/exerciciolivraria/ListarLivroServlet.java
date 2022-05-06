package com.github.lipenathan.exerciciolivraria;

import com.github.lipenathan.exerciciolivraria.dao.LivroDao;
import com.github.lipenathan.exerciciolivraria.model.Livro;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listarlivro", value = "/listar-livro")
public class ListarLivroServlet extends HttpServlet {

    LivroDao livroDao;
    List<Livro> livros;

    public void init() {
        System.out.println("init listar livros");
        livroDao = new LivroDao();
        livros = livroDao.listar();
        System.out.println(livros);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("livros", livros);
        response.sendRedirect("lista-livros.jsp");
    }
}