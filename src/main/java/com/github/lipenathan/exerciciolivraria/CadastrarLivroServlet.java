package com.github.lipenathan.exerciciolivraria;

import com.github.lipenathan.exerciciolivraria.dao.LivroDao;
import com.github.lipenathan.exerciciolivraria.model.Livro;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cacdastrarlivro", value = "/cadastrar-livro")
public class CadastrarLivroServlet extends HttpServlet {

    Livro livro;
    LivroDao livroDao;

    public void init() {
        System.out.println("init cadastrar livros");
        livro = new Livro();
        livroDao = new LivroDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        String autor = request.getParameter("autor");
        livro.setTitulo(titulo);
        livro.setCategoria(categoria);
        livro.setAutor(autor);
        try {
            livroDao.inserir(livro);
            System.out.println(livro + "\nINSERIDO COM SUCESSO");
        } catch (Exception e) {
            PrintWriter writer = response.getWriter();
            writer.println(
                    "<html><body><h2>Erro ao Inserir Livro<br/><h3><%=" + e.getMessage() + "%></h3></h2></body></html>");
            return;
        }
        response.sendRedirect("index.jsp");
    }
}