package com.alexandre.api.api.model.vo;

import com.alexandre.api.api.model.Autor;
import com.alexandre.api.api.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class AutorVO {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String [] livros = new String[1000] ;

    public AutorVO() {
    }


    public AutorVO(String nome, String email, String senha, String... livros) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.livros = livros;
    }
    public AutorVO(int id, String nome, String email, String senha, String... livros) {
        this(nome, email, senha, livros);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getLivros() {
        return livros;
    }

    public void setLivros(String... livros) {
        this.livros = livros;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Autor build(){
        List<Livro> livros = new ArrayList<>();
        for (String s : this.getLivros()) {
            livros.add(new Livro(s));
        }
        return new Autor(this.getNome(), this.getEmail(), this.getSenha(), livros);
    }
}
