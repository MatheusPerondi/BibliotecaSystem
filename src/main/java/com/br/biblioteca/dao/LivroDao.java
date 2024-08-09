package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Livro;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroDao {
    private EntityManager entityManager;

    public LivroDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarLivro(final Livro livro){
        this.entityManager.persist(livro);
    }

    public Livro consultarLivroPorId(final Integer id){
        return this.entityManager.find(Livro.class, id);
    }

    public List<Livro> consultarTodosLivros(){
        String jpql = "SELECT l FROM Livro l";
        return this.entityManager.createQuery(jpql, Livro.class).getResultList();
    }

    public List<Livro> consultarLivroPorNome(final String nome){
        String jpql = "SELECT l FROM Livro l WHERE UPPER(l.nome) LIKE UPPER(:nome)";
        return this.entityManager.createQuery(jpql, Livro.class).setParameter("nome", "%"+nome+"%").getResultList();
    }

    public void atualizarLivro(final Livro livro){
        this.entityManager.merge(livro);
    }

    public void excluir(final Livro livro){
        this.entityManager.remove(livro);
    }
}
