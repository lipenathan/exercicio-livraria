package com.github.lipenathan.exerciciolivraria.dao;

import com.github.lipenathan.exerciciolivraria.model.Livro;
import com.github.lipenathan.exerciciolivraria.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UsuarioDao {
    private final EntityManager entityManager;
    private final String PERSISTENCE_UNIT_NAME = "livraria";

    public UsuarioDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = emf.createEntityManager();
    }

    public void inserir(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validarLogin(Usuario usuario) throws Exception {
        try {
            Query query = entityManager.createQuery("select u from Usuario u where u.email =: " +
                    "email and u.senha =:senha");
            query.setParameter("email", usuario.getEmail());
            query.setParameter("senha", usuario.getSenha());
            Usuario result = (Usuario) query.getSingleResult();
            if (usuario == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao consultar usuário - " + e.getMessage());
        }
    }
}