/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.basealunos.model;

import java.util.List;

/**
 *
 * @author Alex
 */
public class Aluno {
    
    private int matriculaID;
    private String cpf;
    private String nome;
    private int idade;
    private Endereco endereco;

    public int getMatriculaID() {
        return matriculaID;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setMatriculaID(int matriculaID) {
        this.matriculaID = matriculaID;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
