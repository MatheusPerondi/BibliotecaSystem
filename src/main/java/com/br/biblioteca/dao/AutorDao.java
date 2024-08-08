package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Autor;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorDao {
    private EntityManager entityManager;

    public AutorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarAutor(final Autor autor){
        this.entityManager.persist(autor);
    }

    public Autor consultarPorid(final Integer id){
        return this.entityManager.find(Autor.class, id);
    }

    public List<Autor> consultarTodod(){
        String jpql = "SELECT a FROM Autor a";
        return this.entityManager.createQuery(jpql, Autor.class).getResultList();
    }

    public List<Autor> consultarPorNome(final String nome){
        String jpql = "SELECT a FROM Autor a WHERE LOWER(a.nome) LIKE LOWER(:nome)";
        return this.entityManager.createQuery(jpql, Autor.class).setParameter("nome", "%"+ nome + "%").getResultList();
    }

    public void atualizar(final Autor autor){
        this.entityManager.merge(autor);
    }

    public void excluir(final Autor autor){
        this.entityManager.remove(autor);
    }
}
