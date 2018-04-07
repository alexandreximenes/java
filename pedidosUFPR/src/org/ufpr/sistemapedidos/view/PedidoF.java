/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.view;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.ufpr.sistemapedidos.helper.FormataData;
import org.ufpr.sistemapedidos.infra.ClienteDAO;
import org.ufpr.sistemapedidos.infra.PedidoDAO;
import org.ufpr.sistemapedidos.infra.ProdutoDAO;
import org.ufpr.sistemapedidos.model.Cliente;
import org.ufpr.sistemapedidos.model.ItemPedido;
import org.ufpr.sistemapedidos.model.Pedido;
import org.ufpr.sistemapedidos.model.Produto;

/**
 *
 * @author Alexandre Ximenes
 */
public class PedidoF extends javax.swing.JFrame {
    Cliente cliente;
    Pedido pedido;
    ItemPedido itemPedido;
    Produto produto;
    ClienteDAO clienteDAO = new ClienteDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    boolean habilita = false;
    DefaultTableModel tabela;
    /**
     * Creates new form PedidoJFrame
     */
    public PedidoF() {
        initComponents();
        desabilitarCampos();
        preencherComboboxCliente();
        preencherComboboxProduto();
        tabela =  (DefaultTableModel) pedidoTabela.getModel();
        pedidoTabela.setRowSorter(new TableRowSorter(tabela));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pedidoAddItem = new javax.swing.JButton();
        pedidoQuantidade = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pedidoCPF = new javax.swing.JTextField();
        pedidoFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pedidoLimpar = new javax.swing.JButton();
        pedidoProdutos = new javax.swing.JComboBox<>();
        pedidoNome = new javax.swing.JLabel();
        pedidoBuscar = new javax.swing.JButton();
        pedidoIncluir = new javax.swing.JButton();
        pedidoAddItem1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidoTabela = new javax.swing.JTable();
        cbClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de pedidos");
        setAlwaysOnTop(true);

        pedidoAddItem.setText("Adicionar item");
        pedidoAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoAddItemActionPerformed(evt);
            }
        });
        pedidoAddItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoAddItemKeyPressed(evt);
            }
        });

        pedidoQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel4.setText("Quantidade");

        jLabel2.setText("Produto");

        pedidoFechar.setText("Fechar");
        pedidoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoFecharActionPerformed(evt);
            }
        });
        pedidoFechar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoFecharKeyPressed(evt);
            }
        });

        jLabel3.setText("CPF");

        pedidoLimpar.setText("Limpar");
        pedidoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoLimparActionPerformed(evt);
            }
        });
        pedidoLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoLimparKeyPressed(evt);
            }
        });

        pedidoProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pedidoProdutosMouseReleased(evt);
            }
        });

        pedidoNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pedidoNome.setToolTipText("Cliente");
        pedidoNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pedidoNome.setEnabled(false);

        pedidoBuscar.setText("Buscar");
        pedidoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoBuscarActionPerformed(evt);
            }
        });
        pedidoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoBuscarKeyPressed(evt);
            }
        });

        pedidoIncluir.setText("Incluir Pedido");
        pedidoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoIncluirActionPerformed(evt);
            }
        });
        pedidoIncluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoIncluirKeyPressed(evt);
            }
        });

        pedidoAddItem1.setText("Remover Item");
        pedidoAddItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoAddItem1ActionPerformed(evt);
            }
        });
        pedidoAddItem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pedidoAddItem1KeyPressed(evt);
            }
        });

        pedidoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedidoTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pedidoTabelaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(pedidoTabela);

        cbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cliente" }));
        cbClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClientesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pedidoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                            .addComponent(pedidoProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pedidoAddItem1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pedidoAddItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pedidoLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pedidoIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pedidoFechar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pedidoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(pedidoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pedidoBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidoCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pedidoBuscar)
                        .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(pedidoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(pedidoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pedidoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedidoLimpar)
                    .addComponent(pedidoAddItem)
                    .addComponent(pedidoAddItem1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedidoFechar)
                    .addComponent(pedidoIncluir))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(940, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pedidoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoBuscarActionPerformed
       buscarCliente();
    }//GEN-LAST:event_pedidoBuscarActionPerformed

    private void pedidoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoLimparActionPerformed
        limpar();
        
    }//GEN-LAST:event_pedidoLimparActionPerformed

    private void pedidoProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoProdutosMouseReleased
        
    }//GEN-LAST:event_pedidoProdutosMouseReleased

    @SuppressWarnings("empty-statement")
    private void pedidoAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoAddItemActionPerformed
        habilitarCampos(false);
        adicionaItem();
        
    }//GEN-LAST:event_pedidoAddItemActionPerformed

    private void pedidoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoIncluirActionPerformed
        incluirPedido();
    }//GEN-LAST:event_pedidoIncluirActionPerformed

    private void pedidoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_pedidoFecharActionPerformed

    private void pedidoAddItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoAddItem1ActionPerformed
        removerLinha();
    }//GEN-LAST:event_pedidoAddItem1ActionPerformed

    private void pedidoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoBuscarKeyPressed
        buscarCliente();
    }//GEN-LAST:event_pedidoBuscarKeyPressed

    private void pedidoAddItem1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoAddItem1KeyPressed
        removerLinha();
    }//GEN-LAST:event_pedidoAddItem1KeyPressed

    private void pedidoAddItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoAddItemKeyPressed
        habilitarCampos(false);
        adicionaItem();
    }//GEN-LAST:event_pedidoAddItemKeyPressed

    private void pedidoLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoLimparKeyPressed
        limpar();
    }//GEN-LAST:event_pedidoLimparKeyPressed

    private void pedidoFecharKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoFecharKeyPressed
        this.dispose();
    }//GEN-LAST:event_pedidoFecharKeyPressed

    private void pedidoIncluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoIncluirKeyPressed
        incluirPedido();
    }//GEN-LAST:event_pedidoIncluirKeyPressed

    private void pedidoTabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pedidoTabelaKeyReleased
        if(evt.getKeyCode() == 127){
            removerLinha();
        }
      
    }//GEN-LAST:event_pedidoTabelaKeyReleased

    private void cbClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClientesItemStateChanged
        selecionarCliente(); 
    }//GEN-LAST:event_cbClientesItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbClientes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pedidoAddItem;
    private javax.swing.JButton pedidoAddItem1;
    private javax.swing.JButton pedidoBuscar;
    private javax.swing.JTextField pedidoCPF;
    private javax.swing.JButton pedidoFechar;
    private javax.swing.JButton pedidoIncluir;
    private javax.swing.JButton pedidoLimpar;
    private javax.swing.JLabel pedidoNome;
    private javax.swing.JComboBox<Object> pedidoProdutos;
    private javax.swing.JSpinner pedidoQuantidade;
    private javax.swing.JTable pedidoTabela;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        pedidoCPF.setText("");
        pedidoNome.setText("");
        tabela.setRowCount(0);
      //  ItemPedido.limparItens(); ver
        pedidoCPF.requestFocus();
    }

    private void preencherComboboxProduto() {
        for(Produto p : produtoDAO.getProdutos()){
            pedidoProdutos.addItem(p);
        }
    }

    private void desabilitarCampos() {
        pedidoNome.setEnabled(false);
        pedidoQuantidade.setEnabled(false);
        pedidoAddItem1.setEnabled(false);
        pedidoProdutos.setEnabled(false);
        pedidoAddItem.setEnabled(false);
        pedidoLimpar.setEnabled(false);
        pedidoTabela.setEnabled(false);
    }
    
    private void habilitarCampos(){
        habilita = !habilita;
        pedidoNome.setEnabled(habilita);
        pedidoQuantidade.setEnabled(habilita);
        pedidoProdutos.setEnabled(habilita);
        pedidoAddItem.setEnabled(habilita);
        pedidoLimpar.setEnabled(habilita);
        pedidoTabela.setEnabled(habilita);
    }

    private void habilitarCampos(boolean b) {
        pedidoCPF.setEditable(b);
        pedidoBuscar.setEnabled(b);
        pedidoLimpar.setEnabled(b);
        pedidoAddItem1.setEnabled(!b);
        pedidoIncluir.setEnabled(!b);
    }

    private void adicionarItemTabela(Produto produto, int quantidade) {
        
        Object[] dados = {produto, quantidade};
        
        tabela.addRow(dados);
        
        
    }

    private void removeItem(int selectedRow) {
        if(selectedRow != -1){
            Produto produto1 = (Produto) pedidoTabela.getValueAt(pedidoTabela.getSelectedRow(), 0);
            
            tabela.removeRow(selectedRow);
            
            JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um item para remoção!");
        }
    }

    private void adicionaItem() {
        produto = (Produto) pedidoProdutos.getSelectedItem();
        int quantidade = (int) pedidoQuantidade.getValue();
        
        if(!verificaProduto(produto)){
        itemPedido = new ItemPedido(produto, quantidade);
        adicionarItemTabela(produto, quantidade);
    
        }else{
            JOptionPane.showMessageDialog(this, "Produdo ja foi inserido\nSe quiser aumentar a quantidade deste item, modifique na propria tabela");
        }
    }

    private boolean verificaProduto(Produto produto) {
        for(int i=0; i< tabela.getRowCount(); i++){
            Produto outroProduto = (Produto) pedidoTabela.getValueAt(i, 0);
            if(produto.equals(outroProduto)){
               return true; 
            }
        }
        return false;
        
    }

    private void buscarCliente() {
       cliente = clienteDAO.getClientePorCPF(pedidoCPF.getText());
       if(!pedidoCPF.equals("") && cliente != null){
            pedidoCPF.setText(cliente.getCpf());
            pedidoNome.setText((cliente.getNome() + " "+ cliente.getSobrenome()).toUpperCase());
            habilitarCampos();
        }else{
            JOptionPane.showMessageDialog(this, "CPF não encontrado!");
            pedidoCPF.requestFocus();
        }
    }

    private void incluirPedido() {
       List<ItemPedido> itensPedido = new LinkedList<>();
       ItemPedido item;
       if(tabela.getRowCount()>0){
            for(int i=0; i< tabela.getRowCount(); i++){
                Produto produto = (Produto) pedidoTabela.getValueAt(i, 0);
                int quantidade = (int) pedidoTabela.getValueAt(i, 1);
                item = new ItemPedido(produto, quantidade);
                itensPedido.add(item);
    //            ItemPedido.adicionarItem(itemPedido);
    
                System.out.println(item);
            }
            pedido = new Pedido(FormataData.format(new Date()), cliente, itensPedido);
            pedidoDAO.adicionar(pedido); 
            System.out.println(pedido);
            JOptionPane.showMessageDialog(this, "Pedido adicionado com sucesso!");
            habilitarCampos(true);
            habilitarCampos();
            limpar();
        }else{
            JOptionPane.showMessageDialog(this, "Complete seu pedido! [adicione itens no seu pedido]");
        }
    }

    private void removerLinha() {
        removeItem(pedidoTabela.getSelectedRow());
    }

    private void preencherComboboxCliente() {
        List<Cliente> clientes = new ClienteDAO().getClientes();
         for(Cliente c : clientes){
             cbClientes.addItem(c);
         }
    }

    private void selecionarCliente() {
       if(cbClientes.getSelectedIndex()>0){
            cliente = (Cliente) cbClientes.getSelectedItem();
            pedidoCPF.setText(cliente.getCpf());
            pedidoNome.setText((cliente.getNome() + " " + cliente.getSobrenome()).toUpperCase());
            pedidoNome.setEnabled(true);
            
            pedidoQuantidade.setEnabled(true);
            pedidoProdutos.setEnabled(true);
            pedidoAddItem.setEnabled(true);
            pedidoLimpar.setEnabled(true);
            pedidoTabela.setEnabled(true);
         
       }else{
             JOptionPane.showConfirmDialog(this, "Selecione um cliente");
         } 
       
    }
    
    
}
