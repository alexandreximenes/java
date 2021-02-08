package src.*;
/*
 * JanelaCliente.java
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JanelaCliente extends javax.swing.JFrame {

    private Cliente cliente = null;
    private ManipulaTexto mt = null;
    List<Cliente> clientes = new ArrayList<>();
    int index = 0;

    public JanelaCliente() {
        mt = new ManipulaTexto();
        initComponents();
        System.out.println("Index == " + index);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnNovo = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jTFNome = new javax.swing.JTextField();
        jTFFone = new javax.swing.JTextField();
        jSIdade = new javax.swing.JSpinner();
        jBtnGravar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();
        jBtnAnterior = new javax.swing.JButton();
        jBtnProximo = new javax.swing.JButton();

        jBtnNovo.setEnabled(false);
        jBtnEditar.setEnabled(false);
        jBtnRemover.setEnabled(false);
        jBtnAnterior.setEnabled(false);
        jBtnAnterior.setEnabled(false);
        jBtnProximo.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Fone:");

        jLabel3.setText("Idade:");

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparTela();
                jTFNome.requestFocus();
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    System.out.println("Index == " + index);
                    cliente = clientes.get(index);
                    System.out.println("Index == " + index);

                    String nome = jTFNome.getText();
                    String telefone = jTFFone.getText();
                    Integer idade = (Integer) jSIdade.getValue();

                    if (Objects.isNull(nome) || nome.equals("") || Objects.isNull(telefone) || telefone.equals("") || Objects.isNull(idade) || idade == 0) {
                        JOptionPane.showMessageDialog(null, "Informe nome, telefone e idade");
                        return;
                    }

                    cliente.setNome(nome);
                    cliente.setFone(telefone);
                    cliente.setIdade(idade);

                    atualizarTela();
                    clientes.remove(index);
                    clientes.add(cliente);
                    clientes.forEach(System.out::println);
                    JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");

                } catch (Exception e) {
                    if (clientes.isEmpty())
                        JOptionPane.showMessageDialog(null, "Nâo encontramos nenhum cliente cadastrado");
                    else
                        JOptionPane.showMessageDialog(null, "Esse é o primeiro registro, não existe anterior");
                }
            }
        });

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (mt != null) {
                    mt.fecharArquivo();
                }
                System.exit(0);
            }
        });

        jBtnGravar.setText("Gravar");
        jBtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String nome = jTFNome.getText();
                String telefone = jTFFone.getText();
                Integer idade = (Integer) jSIdade.getValue();

                if (Objects.isNull(nome) || nome.equals("") || Objects.isNull(telefone) || telefone.equals("") || Objects.isNull(idade) || idade == 0) {
                    JOptionPane.showMessageDialog(null, "Informe nome, telefone e idade");
                    return;
                }

                cliente = new Cliente(nome, telefone, idade);
                clientes.add(cliente);

                mt.GravaClientes(clientes);

                index++;
                System.out.println("Index == " + index);

                JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso!");
                limparTela();
                jTFNome.requestFocus();

                jBtnNovo.setEnabled(true);
                jBtnEditar.setEnabled(true);
                jBtnRemover.setEnabled(true);
                jBtnAnterior.setEnabled(true);
                jBtnAnterior.setEnabled(true);
                jBtnProximo.setEnabled(true);


            }
        });

        jBtnAnterior.setText("Anterior");
        jBtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anterior();
            }
        });

        jBtnProximo.setText("Proximo");
        jBtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximo();
            }


        });

        jBtnRemover.setText("Remover");
        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                clientes.remove(index);
                mt.GravaClientes(clientes);
                limparTela();
                jTFNome.requestFocus();

            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTFNome, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                                        .addComponent(jSIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTFFone)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBtnNovo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnGravar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnAnterior)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnProximo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnRemover)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtnFechar)))
                                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTFFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jSIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBtnNovo)
                                        .addComponent(jBtnGravar)
                                        .addComponent(jBtnEditar)
                                        .addComponent(jBtnAnterior)
                                        .addComponent(jBtnRemover)
                                        .addComponent(jBtnProximo)
                                        .addComponent(jBtnFechar))
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 600) / 2, (screenSize.height - 245) / 2, 600, 245);
    }

    private void anterior() {
        try {
            System.out.println("Index == " + index);
            cliente = clientes.get(--index);
            System.out.println("Index == " + index);
            atualizarTela();
        } catch (Exception e) {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nâo encontramos nenhum cliente cadastrado");
                index = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Esse é o primeiro registro, não existe anterior");
                ++index;
            }
        }
    }

    private void proximo() {
        try {
            System.out.println("Index == " + index);
            cliente = clientes.get(++index);
            System.out.println("Index == " + index);
            atualizarTela();
        } catch (Exception e) {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nâo encontramos nenhum cliente cadastrado");
                index = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Esse é o primeiro registro, não existe anterior");
                --index;
            }
        }
    }

    public void limparTela() {
        jTFNome.setText("");
        jTFFone.setText("");
        jSIdade.setValue((Integer) 18);
    }

    public void atualizarTela() {
        if (cliente != null && cliente.getNome() != null) {
            jTFNome.setText(cliente.getNome());
            jTFFone.setText(cliente.getFone());
            jSIdade.setValue((Integer) cliente.getIdade());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JanelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnGravar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JButton jBtnAnterior;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnProximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSIdade;
    private javax.swing.JTextField jTFFone;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
