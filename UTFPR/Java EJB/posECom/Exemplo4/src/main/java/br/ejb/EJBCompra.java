/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.data.entity.ItensCompra;
import br.data.entity.Produto;
import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author alexandrelerario
 */
@Stateful
public class EJBCompra {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ArrayList<ItensCompra> lcompra;

    public EJBCompra() {
        lcompra = new ArrayList<>();
    }
    
    public void add(Produto prod){
        boolean existente=false;
        for (ItensCompra itensCompra : lcompra) {
            if(itensCompra.getProduto().getCodigo()==prod.getCodigo()){
                itensCompra.setQuantidade(itensCompra.getQuantidade()+1);
                existente=true;
            }
        }
        if(!existente){
            lcompra.add(new ItensCompra(prod, 1));
        }
        
        
    }
    
    public ArrayList<ItensCompra> getAll(){
        return lcompra;
    }
    
    
    public void fechar_pedido() {
       //metodo de pagamento...
        lcompra = new ArrayList<>();
    }
}
