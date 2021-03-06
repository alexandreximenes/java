package com.alexandre.springmvc.domains;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
public class User extends AbstractEntity{

    private String nome;

    @Transient
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Adress adress;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private Customer customer;

    private String encryptedPassword;

    private Boolean enabled = true;

    public User() { }

    public User(String nome, String password, Adress adress, Boolean enabled) {
        this.nome = nome;
        this.password = password;
        this.adress = adress;
        this.enabled = enabled;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
