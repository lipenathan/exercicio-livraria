package com.github.lipenathan.exerciciolivraria.dao;

import com.github.lipenathan.exerciciolivraria.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class LivroDao {
    private final EntityManager entityManager;
    private final String PERSISTENCE_UNIT_NAME = "livraria";

    public LivroDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = emf.createEntityManager();
    }

    public void inserir(Livro livro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Livro> listar() {
        System.out.println("Método listar");
        Query queryLivros = entityManager.createQuery("from Livro l");
        List<Livro> livros =(List<Livro>) queryLivros.getResultList();
        return livros;
    }

    public Livro buscarLivro(String titulo) {
        return (Livro) entityManager.createQuery("select l from Livro l where l.titulo like :tit")
                .setParameter("tit", "%"+titulo+"%")
                .getResultList().get(0);
    }
}