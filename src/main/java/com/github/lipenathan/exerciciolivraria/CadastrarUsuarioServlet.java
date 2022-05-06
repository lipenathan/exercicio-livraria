package com.github.lipenathan.exerciciolivraria;

import com.github.lipenathan.exerciciolivraria.dao.UsuarioDao;
import com.github.lipenathan.exerciciolivraria.model.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cacdastrarusuario", value = "/cadastrar-usuario")
public class CadastrarUsuarioServlet extends HttpServlet {

    Usuario usuario;
    UsuarioDao usuarioDao;

    public void init() {
        usuario = new Usuario();
        usuarioDao = new UsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        usuario.setEmail(email);
        usuario.setSenha(senha);
        try {
            usuarioDao.inserir(usuario);
            System.out.println(usuario + "\nINSERIDO COM SUCESSO");
        } catch (Exception e) {
            PrintWriter writer = response.getWriter();
            writer.println(
                    "<html><body><h2>Erro ao Inserir Usuário<br/><h3><%=" + e.getMessage() + "%></h3></h2></body></html>");
            return;
        }
        response.sendRedirect("index.jsp");
    }
}