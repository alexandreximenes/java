/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre Ximenes
 */
public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private List<Cliente> clientes = new ArrayList<>();
    
    public Cliente(int id, String cpf, String nome, String sobrenome){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Cliente(String cpf, String nome, String sobrenome){
        this(0, cpf, nome, sobrenome);
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
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    @Override
    public String toString() {
        return nome.toUpperCase()+ " "+ sobrenome.toUpperCase();
    }    
}
