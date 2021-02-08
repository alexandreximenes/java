/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.entity.Produto;
import br.ejb.EJBProduto;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jSFProduto")
@RequestScoped
public class JSFProduto {

    @EJB
    private EJBProduto eJBProduto;

    /**
     * Creates a new instance of JSFProduto
     */
    public JSFProduto() {
    }
    
    public ArrayList<Produto> getAll(){
        return eJBProduto.getAll();
    }
    
}
