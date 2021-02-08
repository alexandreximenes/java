/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto1.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;

/**
 *
 * @author Adm
 */
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

   private String mensagem;
    
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String msg) {
        this.mensagem = msg;
    }
    
}
