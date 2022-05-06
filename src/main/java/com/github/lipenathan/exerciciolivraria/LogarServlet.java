package com.github.lipenathan.exerciciolivraria;

import com.github.lipenathan.exerciciolivraria.dao.LivroDao;
import com.github.lipenathan.exerciciolivraria.dao.UsuarioDao;
import com.github.lipenathan.exerciciolivraria.model.Livro;
import com.github.lipenathan.exerciciolivraria.model.Usuario;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logar", value = "/logar")
public class LogarServlet extends HttpServlet {

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
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            boolean loginOk = usuarioDao.validarLogin(usuario);
            if (loginOk) {
                outputStream.print("Login efetuado com sucesso!");
                outputStream.print("<meta http-equiv='refresh' content='2, url=index.jsp'>");
            } else {
                outputStream.print("Usuário não encontrado!");
                outputStream.print("<meta http-equiv='refresh' content=2; url='index.jsp'>");
            }
        } catch (Exception e) {

        }
    }
}