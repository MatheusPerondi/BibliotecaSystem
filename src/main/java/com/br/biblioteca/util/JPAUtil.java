package com.br.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory BIBLIOTECA = Persistence.createEntityManagerFactory("biblioteca");

    public static EntityManager getEntityManager(){
        return BIBLIOTECA.createEntityManager();
    }
}
