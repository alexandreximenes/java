/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.ufpr.sistemapedidos.infra.ClienteDAO;

/**
 *
 * @author Alexandre Ximenes
 */
public class TableModelCliente extends AbstractTableModel {
    private List<Cliente> listaDeCliente;
    private ClienteDAO clienteDAO;
    private String[] colunas = {"Codigo", "CPF", "Nome", "Sobrenome"};
    public TableModelCliente(){
        this.listaDeCliente = new ArrayList<Cliente>();
        this.clienteDAO = new ClienteDAO();
        this.listaDeCliente = clienteDAO.getClientes();
    }
    public void addCliente(Cliente cCliente){
        this.listaDeCliente.add(cCliente);
        fireTableDataChanged();
    }
    public void removerCliente(int rowIndex){
        this.listaDeCliente.remove(rowIndex);
        fireTableDataChanged();
    }
    public Cliente getCliente(int rowIndex){
        return this.listaDeCliente.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaDeCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaDeCliente.get(rowIndex).getId();
            case 1:
                return this.listaDeCliente.get(rowIndex).getCpf();
            case 2:
                return this.listaDeCliente.get(rowIndex).getNome();
            case 3:
                return this.listaDeCliente.get(rowIndex).getSobrenome();  
            default:
                return this.listaDeCliente.get(rowIndex);
        }
    }
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
        
    }
    
}
