package com.br.biblioteca.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name = "ano_de_publicacao")
    private Integer ano;
    @ManyToMany(mappedBy = "livroList")
    private List<Autor> autorList =  new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Editora editora;
    @Column(name = "quantidade_em_estoque")
    private Integer quantidadeEstoque;
    @Column(name = "exemplares_disponiveis")
    private Integer exemplaresDisponiveis;

    public Livro(String nome, Integer ano, List<Autor> autorList, Categoria categoria, Editora editora, Integer quantidadeEstoque, Integer exemplaresDisponiveis) {
        this.nome = nome;
        this.ano = ano;
        this.autorList = autorList;
        this.categoria = categoria;
        this.editora = editora;
        this.quantidadeEstoque = quantidadeEstoque;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public void addAutor(Autor autor){
        autorList.add(autor);
        autor.getLivroList().add(this);
    }

    public Livro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", autorList=" + autorList +
                ", categoria=" + categoria +
                ", editora=" + editora +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", exemplaresDisponiveis=" + exemplaresDisponiveis +
                '}';
    }
}
