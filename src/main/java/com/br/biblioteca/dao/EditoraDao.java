package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Editora;

import javax.persistence.EntityManager;
import java.util.List;

public class EditoraDao {
    private EntityManager entityManager;

    public EditoraDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarEditora(final Editora editora){
        this.entityManager.persist(editora);
    }

    public List<Editora> consultarTodos(){
        String jpql = "SELECT e FROM e";
        return this.entityManager.createQuery(jpql, Editora.class).getResultList();
    }

    public Editora consultarPorId(final Integer id){
        return this.entityManager.find(Editora.class, id);
    }

    public void atualizar(final Editora editora){
        this.entityManager.merge(editora);
    }

    public void excluir(final Editora editora){
        this.entityManager.remove(editora);
    }
}
