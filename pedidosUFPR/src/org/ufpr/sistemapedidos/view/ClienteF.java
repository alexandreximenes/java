/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.view;

import java.util.List;
import javax.swing.JOptionPane;
import org.ufpr.sistemapedidos.infra.ClienteDAO;
import org.ufpr.sistemapedidos.model.Cliente;
import org.ufpr.sistemapedidos.model.TableModelCliente;

/**
 *
 * @author Programmer
 */
public class ClienteF extends javax.swing.JFrame {
    private TableModelCliente tableModelCliente;
    ClienteDAO dao = new ClienteDAO();
    /**
     * Creates new form ClienteJFrame
     */
    public ClienteF() {
        initComponents();
        this.tableModelCliente = new TableModelCliente();
        this.clienteTabela.setModel(tableModelCliente);
        clienteCPF.requestFocus();
        habilitarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteFechar = new javax.swing.JButton();
        clienteLimpar = new javax.swing.JButton();
        clienteSalvar = new javax.swing.JButton();
        clienteCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clienteBuscar = new javax.swing.JButton();
        clienteApagar = new javax.swing.JButton();
        clienteCPF = new javax.swing.JTextField();
        clienteSobrenome = new javax.swing.JTextField();
        clienteNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        clienteTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de clientes");
        setAlwaysOnTop(true);

        clienteFechar.setText("Fechar");
        clienteFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteFecharActionPerformed(evt);
            }
        });

        clienteLimpar.setText("Limpar");
        clienteLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteLimparActionPerformed(evt);
            }
        });

        clienteSalvar.setText("Salvar");
        clienteSalvar.setEnabled(false);
        clienteSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteSalvarActionPerformed(evt);
            }
        });

        clienteCodigo.setEditable(false);

        jLabel4.setText("Sobrenome");

        jLabel1.setText("Codigo");

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        clienteBuscar.setText("Buscar");
        clienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteBuscarActionPerformed(evt);
            }
        });
        clienteBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clienteBuscarKeyPressed(evt);
            }
        });

        clienteApagar.setText("Apagar");
        clienteApagar.setEnabled(false);
        clienteApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteApagarActionPerformed(evt);
            }
        });

        clienteCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clienteCPFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clienteCPFFocusLost(evt);
            }
        });
        clienteCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteCPFActionPerformed(evt);
            }
        });
        clienteCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clienteCPFKeyReleased(evt);
            }
        });

        clienteTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CPF", "NOME", "SOBRENOME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        clienteTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clienteTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clienteSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteApagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteFechar))
                            .addComponent(clienteBuscar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(clienteNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clienteSobrenome))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(clienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clienteSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteFechar)
                    .addComponent(clienteLimpar)
                    .addComponent(clienteSalvar)
                    .addComponent(clienteApagar))
                .addGap(35, 35, 35))
        );

        setSize(new java.awt.Dimension(878, 535));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clienteSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteSalvarActionPerformed
        String id =  clienteCodigo.getText();
        String cpf = clienteCPF.getText().trim();
        String nome = clienteNome.getText().trim();
        String sobrenome = clienteSobrenome.getText().trim();
        
        if(inseriuDadosCorretamente(cpf, nome, sobrenome)){
            int codigo = (id.equals("")) ? 0 : Integer.parseInt(id) ;  
            System.out.println("clienteCodigo.getText() ["+id+ "]");
            Cliente cliente = new Cliente(codigo, cpf, nome, sobrenome );
            String msg = dao.salvar(cliente);
            cliente = dao.getClientePorCPF(cpf);
            this.tableModelCliente.addCliente(cliente);
            JOptionPane.showMessageDialog(this, msg);
            limpar();
            
        }else{
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente");
        }
    }//GEN-LAST:event_clienteSalvarActionPerformed

    private void clienteFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_clienteFecharActionPerformed

    private void clienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteBuscarActionPerformed
        buscarCliente();
    }//GEN-LAST:event_clienteBuscarActionPerformed

    private void clienteLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteLimparActionPerformed
            limpar();
    }//GEN-LAST:event_clienteLimparActionPerformed

    private void clienteApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteApagarActionPerformed
            String msg = dao.excluir(clienteCodigo.getText());
            int linhaSelecionada = this.clienteTabela.getSelectedRow();
            tableModelCliente.removerCliente(linhaSelecionada);
            JOptionPane.showMessageDialog(this, msg);
            limpar();
    }//GEN-LAST:event_clienteApagarActionPerformed

    private void clienteCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteCPFActionPerformed

    private void clienteBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienteBuscarKeyPressed
        buscarCliente();
    }//GEN-LAST:event_clienteBuscarKeyPressed

    private void clienteCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienteCPFKeyReleased
 
    }//GEN-LAST:event_clienteCPFKeyReleased

    private void clienteCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clienteCPFFocusGained

    }//GEN-LAST:event_clienteCPFFocusGained

    private void clienteCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clienteCPFFocusLost
        if(clienteCPF.getText().length()>0){
            buscarCliente();
        }
    }//GEN-LAST:event_clienteCPFFocusLost

    private void clienteTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteTabelaMouseClicked
        if(evt.getClickCount() == 1){
            int linhaSelecionada = clienteTabela.getSelectedRow();
            clienteCodigo.setText("" + clienteTabela.getValueAt(linhaSelecionada, 0));
            clienteCPF.setText("" + clienteTabela.getValueAt(linhaSelecionada, 1));
            clienteNome.setText("" + clienteTabela.getValueAt(linhaSelecionada, 2));
            clienteSobrenome.setText("" + clienteTabela.getValueAt(linhaSelecionada, 3));
        }
    }//GEN-LAST:event_clienteTabelaMouseClicked

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
            java.util.logging.Logger.getLogger(ClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clienteApagar;
    private javax.swing.JButton clienteBuscar;
    private javax.swing.JTextField clienteCPF;
    private javax.swing.JTextField clienteCodigo;
    private javax.swing.JButton clienteFechar;
    private javax.swing.JButton clienteLimpar;
    private javax.swing.JTextField clienteNome;
    private javax.swing.JButton clienteSalvar;
    private javax.swing.JTextField clienteSobrenome;
    private javax.swing.JTable clienteTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
            clienteCodigo.setText("");
            clienteCPF.setText("");
            clienteNome.setText("");
            clienteSobrenome.setText("");
            clienteCPF.requestFocus();
    }

    private boolean inseriuDadosCorretamente(String cpf, String nome, String sobrenome) {
        if(!cpf.isEmpty() && !nome.isEmpty() && !sobrenome.isEmpty() && cpf.length()<=15 && nome.length()<=30 && sobrenome.length()<=50){
            return true;
        }else{
            return false;
        }
    }

    private void buscarCliente() {
       Cliente cliente = dao.getClientePorCPF(clienteCPF.getText());
        if(cliente != null){
            clienteCodigo.setText(String.valueOf(cliente.getId()));
            clienteCPF.setText(cliente.getCpf());
            clienteNome.setText(cliente.getNome());
            clienteSobrenome.setText(cliente.getSobrenome());
            habilitarCampos();
        }else{
            JOptionPane.showMessageDialog(this, "CPF não encontrado!");
            limpar();
            //clienteCPF.requestFocus();
        }
    }

    private void habilitarCampos() {
        clienteSalvar.setEnabled(true);
        clienteApagar.setEnabled(true);
    }  
}
