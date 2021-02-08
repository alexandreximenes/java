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


@NamedQuery(
        name = "Contato.byIdade",
        query = "SELECT c FROM Funcionario c WHERE c.idade = ?1"
)
@NamedNativeQuery(
        name = "Contato.byNome",
        query = "SELECT * FROM contato WHERE nome LIKE ?1",
        resultClass = Funcionario.class
)

/*
* Func: #IDFuncPK, Nome, Sexo, Telefone, IDCargoFK

Cargo: #IDCagoPK, Cargo
* */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends AbstractPersistable<Long> {

    @Column(name = "nome", length = 64, nullable = false)
    private String nome;

    @Column(name = "sexo", length = 64, nullable = false)
    private String sexo;

    @Column(name = "telefone", length = 64, nullable = false)
    private String Telefone;

    @OneToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo endereco) {
        this.cargo = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
}
