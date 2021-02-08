/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBSomar;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Adm
 */
@Named(value = "jSFSomar")
@RequestScoped
public class JSFSomar {

    @EJB
    private EJBSomar eJBSomar;

    private Double n1;
    private Double n2;
    private Double res;

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }
    
    public JSFSomar() {
    }
    
    public Double somar(){
       res = eJBSomar.somar(n1, n2);
       return res;
    }

    public Double getRes() {
        return res;
    }

    public void setRes(Double res) {
        this.res = res;
    }
}
