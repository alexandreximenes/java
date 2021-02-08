/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBCalculadoraSimplesLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author UTFPR
 */
@Named(value = "jsfCalcSimples")
@RequestScoped
public class JsfCalcSimples {

    @EJB
    private EJBCalculadoraSimplesLocal eJBCalculadoraSimples;

    /**
     * Creates a new instance of JsfCalcSimples
     */
    public JsfCalcSimples() {
    }
    
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void dobrar(){
        this.valor = eJBCalculadoraSimples.dobrar(valor);
    }
    
}
