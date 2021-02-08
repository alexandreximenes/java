/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.entity.ItensCompra;
import br.data.entity.Produto;
import br.ejb.EJBCompra;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jSFCompra")
@SessionScoped
public class JSFCompra implements Serializable {

    @EJB
    private EJBCompra eJBCompra;

    /**
     * Creates a new instance of JSFCompra
     */
    public JSFCompra() {
    }
    
    public void add(Produto prod){
        eJBCompra.add(prod);
    }
    
    public ArrayList<ItensCompra> getItens(){
      return eJBCompra.getAll();
    }
    
    public void fechar(){
        eJBCompra.fechar_pedido();
    }
    
}
