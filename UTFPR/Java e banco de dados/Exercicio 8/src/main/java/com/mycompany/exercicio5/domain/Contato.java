/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio5.domain;

import java.util.Date;
import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author xiiim
 */
@Entity
@Table(name = "CONTATO")
@NamedQuery(
        name = "Contato.byIdade",
        query = "SELECT c FROM Contato c WHERE c.idade = ?1"
)
@NamedNativeQuery(
        name = "Contato.byNome",
        query = "SELECT * FROM contato WHERE nome LIKE ?1",
        resultClass = Contato.class
)
public class Contato extends AbstractPersistable<Long> {

    @Column(name = "nome", length = 64, nullable = false)
    private String nome;

    @Column(name = "sobre_nome", length = 64, nullable = false)
    private String sobreNome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setId(Long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Transient
    public boolean isNew() {
        return null == getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
