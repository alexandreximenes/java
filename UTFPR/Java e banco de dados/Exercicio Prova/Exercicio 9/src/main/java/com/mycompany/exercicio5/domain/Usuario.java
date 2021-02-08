package com.mycompany.exercicio5.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@NamedStoredProcedureQuery(
        name = "Usuario.soma",
        procedureName = "procedure_soma",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "arg",
                        type = Integer.class),
                @StoredProcedureParameter(
                        mode = ParameterMode.OUT,
                        name = "res",
                        type = Integer.class)
        })
@Entity
public class Usuario extends AbstractAuditable<Usuario, Long> {

    private Integer arg;
    private Integer res;

    public Integer getArg() {
        return arg;
    }

    public void setArg(Integer arg) {
        this.arg = arg;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }
}
