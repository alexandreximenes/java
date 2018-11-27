package com.alexandre.springmvc.domains;

import javax.persistence.*;

@Entity
public class User extends AbstractEntity{

    private String nome;

    @Transient
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Adress adress;

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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
