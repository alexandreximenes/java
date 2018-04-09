/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Alexandre Ximenes
 */
public class Endereco implements Serializable{
    private int enderecoID;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private int matriculaID;
    
    public Endereco(){}

    public Endereco(String logradouro, int numero, String complemento, String bairro, String cep, String cidade, String estado, int matriculaID) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.matriculaID = matriculaID;
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEnderecoID() {
        return enderecoID;
    }

    public void setEnderecoID(int enderecoID) {
        this.enderecoID = enderecoID;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMatriculaID() {
        return matriculaID;
    }

    public void setMatriculaID(int matriculaID) {
        this.matriculaID = matriculaID;
    }
    
    @Override
    public String toString() {
        return "ID : "+ enderecoID + " MatriculaID : " +matriculaID+ "+ Logradouro: "+ logradouro+ ", "+ numero + " " +bairro + " " +cidade + " " +estado;
    }
}
