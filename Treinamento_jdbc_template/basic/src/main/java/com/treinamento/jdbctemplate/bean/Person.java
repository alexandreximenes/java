package com.treinamento.jdbctemplate.bean;


import java.util.Date;

public class Person {
    private Integer id;
    private String nome;
    private String location;
    private Date birthDate;

    public Person() {
    }

    public Person(Integer id, String nome, String location, Date birthDate) {
        this.id = id;
        this.nome = nome;
        this.location = location;
        this.birthDate = birthDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
