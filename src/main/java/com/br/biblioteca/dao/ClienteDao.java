package com.br.biblioteca.dao;

import com.br.biblioteca.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public List<Cliente> consultarTodos(){
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente consultarId(final Integer id){
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarNome(final String nome){
        String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE UPPER(:nome)";
        return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome", "%" + nome + "%").getResultList();
    }

    public void atualizar(final Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente){
        this.entityManager.remove(cliente);
    }
}
