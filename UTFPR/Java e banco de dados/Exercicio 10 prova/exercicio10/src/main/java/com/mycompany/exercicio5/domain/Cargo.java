/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio5.domain;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author xiiim
 */
/*
* Func: #IDFuncPK, Nome, Sexo, Telefone, IDCargoFK

Cargo: #IDCagoPK, Cargo
* */
@Entity
@Table(name = "CARGO")
public class Cargo extends AbstractPersistable<Long> {

    @Column(name = "cargo", length = 64, nullable = false)
    private String cargo;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @OneToOne(mappedBy = "cargo")
    private Funcionario funcionario;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
