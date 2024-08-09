package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Cliente;
import com.br.biblioteca.entity.Emprestimo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmprestimoDao {
    private EntityManager entityManager;

    public EmprestimoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastar(final Emprestimo emprestimo){
        this.entityManager.persist(emprestimo);
    }

    public Emprestimo consultarId(final Integer id){
        return this.entityManager.find(Emprestimo.class,id);
    }

    public List<Emprestimo> consultarNomeCliente(final String nome){
        String jpql = "SELECT e FROM Emprestimo e WHERE e.cliente.nome = :nome";
        TypedQuery<Emprestimo> query = entityManager.createQuery(jpql, Emprestimo.class);
        return query.setParameter("nome", nome).getResultList();
    }

    public List<Emprestimo> consultarTodos(){
        String jpql = "SELECT e FROM Emprestimo e";
        return this.entityManager.createQuery(jpql, Emprestimo.class).getResultList();
    }

    public void atualizar(final Emprestimo emprestimo){
        this.entityManager.merge(emprestimo);
    }

    public void excluir(final Emprestimo emprestimo){
        this.entityManager.remove(emprestimo);
    }
}
