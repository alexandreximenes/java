/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.basealunos.model;

/**
 *
 * @author Alex
 */
public class Endereco {
    private int enderecoID;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private int matriculaID;

    public void setMatriculaID(int matriculaID) {
        this.matriculaID = matriculaID;
    }

    public int getMatriculaID() {
        return matriculaID;
    }

    public int getEnderecoID() {
        return enderecoID;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }
    public void setEnderecoID(int enderecoID) {
        this.enderecoID = enderecoID;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
}
