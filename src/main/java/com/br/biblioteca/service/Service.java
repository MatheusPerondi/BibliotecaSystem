package com.br.biblioteca.service;

import com.br.biblioteca.dao.AutorDao;
import com.br.biblioteca.entity.Autor;
import com.br.biblioteca.entity.Editora;
import com.br.biblioteca.util.CargaDeDadosUtil;
import com.br.biblioteca.util.JPAUtil;

import javax.persistence.EntityManager;

public class Service {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        AutorDao autorDao = new AutorDao(entityManager);
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarAutoresELivros(entityManager);

        entityManager.close();

    }
}
