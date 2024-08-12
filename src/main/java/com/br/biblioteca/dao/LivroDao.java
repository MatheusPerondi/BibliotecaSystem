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
        livro.setExemplaresDisponiveis(10);
        livro.setQuantidadeEstoque(10);
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

    public void emprestarLivro(Livro livro){
        if (livro.getExemplaresDisponiveis() > 0){
            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() -1);
            this.entityManager.merge(livro);
        }else {
            System.out.println("Livro indisponivel para emprestimo!");
        }
    }

    public void devolverLivro(Livro livro){
        if (livro.getExemplaresDisponiveis() < livro.getQuantidadeEstoque()){
            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() + 1);
            this.entityManager.merge(livro);
        }else {
            System.out.println("Todos os exemplares ja foram devolvidos");
        }
    }

    public boolean isLivroDisponivel(Livro livro){
        return livro.getExemplaresDisponiveis() > 0;
    }

    public void atualizarLivro(final Livro livro){
        this.entityManager.merge(livro);
    }

    public void excluir(final Livro livro){
        this.entityManager.remove(livro);
    }
}
