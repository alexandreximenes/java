/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.ufpr.sistemapedidos.infra.ProdutoDAO;

/**
 *
 * @author Alexandre Ximenes
 */
public class TableModelProduto extends AbstractTableModel{
    private List<Produto> listaDeProduto;
    private ProdutoDAO produtoDAO;
    private String[] colunas = {"Codigo", "Descrição"};

    public TableModelProduto() {
        this.listaDeProduto = new ArrayList<Produto>();
        this.produtoDAO = new ProdutoDAO();
        this.listaDeProduto = produtoDAO.getProdutos();
    }
    public void addProduto(Produto pProduto){
        this.listaDeProduto.add(pProduto);
        fireTableDataChanged();
    }
    public void removerProduto(int rowIndex){
        this.listaDeProduto.remove(rowIndex);
        fireTableDataChanged();
    }
    public Produto getProduto(int rowIndex){
        return this.listaDeProduto.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return listaDeProduto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
            case 0:
                return this.listaDeProduto.get(rowIndex).getId();
            case 1:
                return this.listaDeProduto.get(rowIndex).getDescricao(); 
            default:
                return this.listaDeProduto.get(rowIndex);
        }
    }
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
        
    }
    
}
