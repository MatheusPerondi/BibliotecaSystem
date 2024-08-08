package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Categoria;
import com.br.biblioteca.entity.Editora;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastar(final Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria consultarId(final Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos(){
        String jpql = "SELECT c FROM c";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
