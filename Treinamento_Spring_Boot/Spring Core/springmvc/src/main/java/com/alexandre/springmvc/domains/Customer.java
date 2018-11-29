package com.alexandre.springmvc.domains;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer extends AbstractEntity{
    private String nome;
    private String email;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    public Customer() {
    }

    public Customer(String nome, String email, User user) {
        this.nome = nome;
        this.email = email;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
