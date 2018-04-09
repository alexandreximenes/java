/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Aluno implements Serializable{
    
    private int matriculaID;
    private String cpf;
    private String nome;
    private int idade;
    private Endereco endereco;

    public Aluno(){}
    public Aluno(String cpf, String nome, int idade, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Aluno(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }
    
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

    @Override
    public String toString() {
        return "ID : "+ matriculaID + " Nome: "+ nome+ ", CPF : "+ cpf + " Idade : " +idade;
    }
    
    
    
}
