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
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractPersistable<Long> {

    public enum TipoEndereco{
        RESIDENCIAL,  COMERCIAL
    }

    @Column(name = "tipo", length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @Column(name = "logradouro", length = 64, nullable = false)
    private String logradouro;

    @Column(name = "cidade", length = 64, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
}
