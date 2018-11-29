package com.alexandre.api.api.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Email private String email;
    private String senha;

    public Autor() { }

    public Autor(String nome, @Email String email, String senha, List<Livro> livros) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.livros = livros;
    }

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha != null){
            this.senha = senha; //new BCryptPasswordEncoder().encode(senha);
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
