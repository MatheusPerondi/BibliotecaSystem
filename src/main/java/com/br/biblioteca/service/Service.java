package com.br.biblioteca.service;

import com.br.biblioteca.dao.*;
import com.br.biblioteca.entity.*;
import com.br.biblioteca.util.CargaDeDadosUtil;
import com.br.biblioteca.util.JPAUtil;

import javax.persistence.EntityManager;

public class Service {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        AutorDao autorDao = new AutorDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EditoraDao editoraDao = new EditoraDao(entityManager);
        EmprestimoDao emprestimoDao = new EmprestimoDao(entityManager);
        LivroDao livroDao = new LivroDao(entityManager);

        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarDados(entityManager);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();


        Livro livro = livroDao.consultarLivroPorId(1);
        System.out.println("Tentando emprestar o livro: " + livro.getNome());
        livroDao.emprestarLivro(livro);
        System.out.println("Exemplares disponíveis após empréstimo: " + livro.getExemplaresDisponiveis());

        System.out.println("Tentando devolver o livro: " + livro.getNome());
        livroDao.devolverLivro(livro);
        System.out.println("Exemplares disponíveis após devolução: " + livro.getExemplaresDisponiveis());

        System.out.println("--------------------------------------");
        System.out.println("Consulta por ID");
        System.out.println(autorDao.consultarPorid(1));

        System.out.println("--------------------------------------");
        System.out.println("Consulta Por nome");
        System.out.println(autorDao.consultarPorNome("J.K. Rowling"));
        System.out.println("--------------------------------------");

        System.out.println("Consultar categoria por ID");
        System.out.println(categoriaDao.consultarId(1));
        System.out.println("--------------------------------------");

        System.out.println("Consultar cliente por ID");
        System.out.println(clienteDao.consultarId(1));
        System.out.println("--------------------------------------");

        System.out.println("Consultar cliente por nome");
        System.out.println(clienteDao.consultarNome("Alice"));
        System.out.println("--------------------------------------");

        System.out.println("Consultar editora por id");
        System.out.println(editoraDao.consultarPorId(1));
        System.out.println("--------------------------------------");

        System.out.println("Consultar emprestimo por nome de cliente");
        System.out.println(emprestimoDao.consultarNomeCliente("Alice"));
        System.out.println("--------------------------------------");

        System.out.println("Consultar emprestimo por id");
        System.out.println(emprestimoDao.consultarId(1));
        System.out.println("--------------------------------------");

        System.out.println("Consultar livro por id");
        System.out.println(livroDao.consultarLivroPorId(1));
        System.out.println("--------------------------------------");

        System.out.println("Consultar livro por nome");
        System.out.println(livroDao.consultarLivroPorNome("Harry Potter e a Pedra Filosofal"));
        System.out.println("--------------------------------------");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
