package com.br.biblioteca.util;

import com.br.biblioteca.dao.AutorDao;
import com.br.biblioteca.dao.CategoriaDao;
import com.br.biblioteca.dao.EditoraDao;
import com.br.biblioteca.dao.LivroDao;
import com.br.biblioteca.dao.ClienteDao;
import com.br.biblioteca.dao.EmprestimoDao;
import com.br.biblioteca.entity.Autor;
import com.br.biblioteca.entity.Categoria;
import com.br.biblioteca.entity.Editora;
import com.br.biblioteca.entity.Livro;
import com.br.biblioteca.entity.Cliente;
import com.br.biblioteca.entity.Emprestimo;
import com.br.biblioteca.entity.Contato;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Arrays;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil() {
    }

    public static void cadastrarDados(EntityManager entityManager) {
        AutorDao autorDao = new AutorDao(entityManager);
        LivroDao livroDao = new LivroDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        EditoraDao editoraDao = new EditoraDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EmprestimoDao emprestimoDao = new EmprestimoDao(entityManager);

        // Criar Categorias e Editoras
        Categoria categoriaFantasia = new Categoria("Fantasia");
        Categoria categoriaAventura = new Categoria("Aventura");
        Editora editoraBloomsbury = new Editora("Bloomsbury", null);
        Editora editoraHarperCollins = new Editora("HarperCollins", null);

        // Criar Autores
        Autor autor1 = new Autor("J.K. Rowling", LocalDate.of(1965, 7, 31), "Britânica");
        Autor autor2 = new Autor("George R.R. Martin", LocalDate.of(1948, 9, 20), "Americano");
        Autor autor3 = new Autor("J.R.R. Tolkien", LocalDate.of(1892, 1, 3), "Britânico");

        // Criar Livros
        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", 1997, Arrays.asList(autor1), categoriaFantasia, editoraBloomsbury);
        Livro livro2 = new Livro("A Guerra dos Tronos", 1996, Arrays.asList(autor2), categoriaFantasia, editoraHarperCollins);
        Livro livro3 = new Livro("O Senhor dos Anéis", 1954, Arrays.asList(autor3), categoriaAventura, editoraHarperCollins);

        // Criar Clientes
        Cliente cliente1 = new Cliente("Alice");
        cliente1.setContato(new Contato("123456789"));  // Definindo o contato
        Cliente cliente2 = new Cliente("Bob");
        cliente2.setContato(new Contato("987654321"));  // Definindo o contato

        // Criar Empréstimos
        Emprestimo emprestimo1 = new Emprestimo(cliente1, livro1, LocalDate.of(2024, 8, 1), null, LocalDate.of(2024, 8, 15), 0.0);
        Emprestimo emprestimo2 = new Emprestimo(cliente2, livro2, LocalDate.of(2024, 8, 2), null, LocalDate.of(2024, 8, 16), 0.0);

        // Persistir Categorias e Editoras
        categoriaDao.cadastar(categoriaAventura);
        categoriaDao.cadastar(categoriaFantasia);
        editoraDao.cadastrarEditora(editoraBloomsbury);
        editoraDao.cadastrarEditora(editoraHarperCollins);

        // Associar autores aos livros
        autor1.setLivroList(Arrays.asList(livro1));
        autor2.setLivroList(Arrays.asList(livro2));
        autor3.setLivroList(Arrays.asList(livro3));

        // Persistir Autores e Livros
        autorDao.cadastrarAutor(autor1);
        autorDao.cadastrarAutor(autor2);
        autorDao.cadastrarAutor(autor3);
        livroDao.cadastrarLivro(livro1);
        livroDao.cadastrarLivro(livro2);
        livroDao.cadastrarLivro(livro3);

        // Persistir Clientes
        clienteDao.cadastrar(cliente1);
        clienteDao.cadastrar(cliente2);

        // Persistir Empréstimos
        emprestimoDao.cadastar(emprestimo1);
        emprestimoDao.cadastar(emprestimo2);

        // Consultar todos os autores
        System.out.println("Autores cadastrados:");
        autorDao.consultarTodod().forEach(System.out::println);
        System.out.println("----------------------------------");

        // Consultar todos os livros
        System.out.println("Livros cadastrados:");
        livroDao.consultarTodosLivros().forEach(System.out::println);
        System.out.println("----------------------------------");

        // Consultar todos os clientes
        System.out.println("Clientes cadastrados:");
        clienteDao.consultarTodos().forEach(System.out::println);
        System.out.println("----------------------------------");

        // Consultar todos os empréstimos
        System.out.println("Empréstimos cadastrados:");
        emprestimoDao.consultarTodos().forEach(System.out::println);
        System.out.println("----------------------------------");

        entityManager.getTransaction().commit();
        entityManager.clear();
    }
}
