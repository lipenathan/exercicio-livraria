package com.github.lipenathan.exerciciolivraria;

import com.github.lipenathan.exerciciolivraria.dao.LivroDao;
import com.github.lipenathan.exerciciolivraria.model.Livro;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "buscarlivro", value = "/buscar-livro")
public class BuscarLivroServlet extends HttpServlet {

    LivroDao livroDao;
    Livro livro;

    public void init() {
        System.out.println("init buscar livros");
        livroDao = new LivroDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Livro livro = livroDao.buscarLivro(titulo);
        request.getSession().setAttribute("livro", livro);
        response.sendRedirect("lista-livros.jsp");
    }
}