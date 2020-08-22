
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class JanelaCliente{
	
	/*INSTANCE VARIABLES*/
	//
	private JFrame mainWindow;
	int width = 800;
	int height = 600;
	
	//
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem abrirCadastro;
	private JMenuItem novoCadastro;
	private JMenuItem sair;
	//
	private JPanel leftPanel;
	private JButton jBtnAnterior;
	private JButton jBtnProximo;
	private JButton jBtnnovoCliente;
	private JButton jBtngravarCliente;
	private JButton jBtneditarCliente;
	private JButton jBtnApagarCliente;
	//
	private JPanel rightPanel;
	private JLabel info;
	
	//
	private JPanel bottontPanel;
	private JLabel statusLabel;

    //
    private JTextField jTFNome;
    private JTextField jTFFone;
    private JSpinner jSIdade;
	
    //
    private ManipulaTexto mt;	
	
	
	/*CONSTRUCTOR*/
	public JanelaCliente() {
		
		//
		mt = new ManipulaTexto(this);
		
		//
		initComponents();
		
		//
		addListeners();
		
	}

	//
	private void initComponents() {
		
		//frame
		mainWindow = new JFrame("Cadastro Clientes");
		mainWindow.setSize(width, height);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		//menu bar
		menuBar = new JMenuBar();
		mainWindow.add(menuBar, BorderLayout.NORTH);
		
		menuFile = new JMenu("Arquivo");
		menuBar.add(menuFile);
		
		abrirCadastro = new JMenuItem ("Abrir Cadastro");
		novoCadastro = new JMenuItem ("Novo Cadastro");
		sair = new JMenuItem ("Sair");
		menuFile.add(abrirCadastro);
		menuFile.add(novoCadastro);
		menuFile.add(new JSeparator());
		menuFile.add(sair);
				
		//left panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(12,1));
		Border padding =  BorderFactory.createEmptyBorder(5, 5, 5, 5);
		leftPanel.setBorder(padding);
		mainWindow.add(leftPanel, BorderLayout.WEST);
		
		jBtnAnterior = new JButton ("<<< Anterior");
		jBtnProximo = new JButton("Proximo >>>");
		jBtnnovoCliente = new JButton("Novo Cliente");
		jBtngravarCliente = new JButton("Gravar Cliente");
		jBtneditarCliente = new JButton("Editar Cliente");
		jBtnApagarCliente = new JButton("Apagar Cliente");
		
		leftPanel.add(new JLabel("Navegação"));
		leftPanel.add(jBtnAnterior);
		leftPanel.add(jBtnProximo);
		leftPanel.add(new JLabel("Edição"));
		leftPanel.add(jBtnnovoCliente);
		leftPanel.add(jBtneditarCliente);
		leftPanel.add(jBtnApagarCliente);
		leftPanel.add(new JLabel(""));		
		leftPanel.add(jBtngravarCliente);

		jBtnAnterior.setEnabled(false);
		jBtnProximo.setEnabled(false);
		jBtnnovoCliente.setEnabled(false);
		jBtngravarCliente.setEnabled(false);
		jBtneditarCliente.setEnabled(false);
		jBtnApagarCliente.setEnabled(false);
		
		//right panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(12,1));
		rightPanel.setBackground(Color.GRAY);
		mainWindow.add(rightPanel, BorderLayout.CENTER);
		
		//botton panel
		bottontPanel = new JPanel();
		mainWindow.add(bottontPanel, BorderLayout.SOUTH);
		statusLabel = new JLabel ("Clique em arquivo para abrir ou criar cadastro");
		bottontPanel.add(statusLabel);
	
		//form
		JPanel clienteLine = new JPanel();
		clienteLine.setBackground(Color.GRAY);
		clienteLine.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel clienteLabel = new JLabel ("Cliente");
		jTFNome = new JTextField(50);
		clienteLine.add(clienteLabel);
		clienteLine.add(jTFNome);
		rightPanel.add(clienteLine);
		
		JPanel foneLine = new JPanel();
		foneLine.setBackground(Color.GRAY);
		foneLine.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel foneLabel = new JLabel ("Fone");
		jTFFone = new JTextField(15);
		foneLine.add(foneLabel);
		foneLine.add(jTFFone);
		rightPanel.add(foneLine);

		JPanel idadeLine = new JPanel();
		idadeLine.setBackground(Color.GRAY);
		idadeLine.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel idadeLabel = new JLabel ("Idade");
		jSIdade = new JSpinner();
		idadeLine.add(idadeLabel);
		idadeLine.add(jSIdade);
		rightPanel.add(idadeLine);
		//jSIdade.setSize(width, height);

		info = new JLabel(mt.getCadastroInfo());
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		infoPanel.setBackground(Color.GRAY);
		infoPanel.add(info);
		rightPanel.add(infoPanel);
		
		setEditableForm(false);
	}
	
	//
	private void addListeners() {

		//Cliente Anterior		
		jBtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtnAnterior");
               jBtnAnteriorActionPerformed(evt);
            }
        });
		
		//Cliente Proximo		
		jBtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtnProximo");
               jBtnProximoActionPerformed(evt);
            }
        });
		
		//Novo Cliente
		jBtnnovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtnnovoCliente");
               jBtnNovoActionPerformed(evt);
            }
        });
		
		//Gravar Cliente		
		jBtngravarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtngravarCliente");
               jBtnGravarActionPerformed(evt);
            }
        });
		
		//Editar Cliente
		jBtneditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtneditarCliente");
               jBtnEditarActionPerformed(evt);
            }
        });

		//Apagar Cliente
		jBtnApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("jBtnApagarCliente");
               jBtnApagarActionPerformed(evt);
            }
        });
		
		//Abrir Arquivo
		abrirCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("abrirArquivo");
				jBtnAbrirArquivoActionPerformed(evt);
			}
		 });
		
		//Salvar Arquivo
		novoCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("salvarArquivo");
				jBtnSalvarArquivoActionPerformed(evt);
			}
		 });
		
		//Sair
		sair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("sair");
				jBtnSairActionPerformed(evt);
			}
		 });
	}
	
	//
	protected void jBtnSairActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	//
	protected void jBtnSalvarArquivoActionPerformed(ActionEvent evt) {
		if (mt.createFile()) {
			jBtnnovoCliente.setEnabled(true);
			jBtngravarCliente.setEnabled(true);
			
			updateData();
		};
	}

	//
	protected void jBtnAbrirArquivoActionPerformed(ActionEvent evt) {
		if (mt.abrirArquivo()) {
			updateData();
			jBtnAnterior.setEnabled(true);
			jBtnProximo.setEnabled(true);
			jBtnnovoCliente.setEnabled(true);
			jBtngravarCliente.setEnabled(false);
			jBtneditarCliente.setEnabled(true);
			jBtnApagarCliente.setEnabled(true);
		}
	}

	//
	protected void jBtnApagarActionPerformed(ActionEvent evt) {
		mt.apagarCliente(mt.getCurrentCliente());
		mt.saveFile();
		updateData();
	}

	//
	protected void jBtnEditarActionPerformed(ActionEvent evt) {
		jTFNome.requestFocus();
		setEditableForm(true);
		jBtngravarCliente.setEnabled(true);
	}
	
	//
	public void setGravarOff() {
		jBtngravarCliente.setEnabled(false);
	}

	//
	protected void jBtnGravarActionPerformed(ActionEvent evt) {
		Cliente c = new Cliente (jTFNome.getText(),jTFFone.getText(), (int)jSIdade.getValue());
		mt.gravarCadastro(c);
		setEditableForm(false);
	}

	//
	protected void jBtnNovoActionPerformed(ActionEvent evt) {
		//
		mt.novoCliente();
		setEditableForm(true);
		jBtngravarCliente.setEnabled(true);
		jTFNome.setText("");
		jTFNome.requestFocus();
		jTFFone.setText("");
		jSIdade.setValue(0);
	}

	//
	protected void jBtnProximoActionPerformed(ActionEvent evt) {
		if (mt.getNextCliente()) {
			updateData();
		}
	}

	//
	protected void jBtnAnteriorActionPerformed(ActionEvent evt) {
		if (mt.getPrevCliente()) {
			updateData();
		}
	}
	
	//update screen data
	public void updateData() {
		if (mt.getCurrentCliente() != null) {
			Cliente c = mt.getCurrentCliente();
			jTFNome.setText(c.getNome());
			jTFFone.setText(c.getFone());
			jSIdade.setValue(c.getIdade());
			info.setText(mt.getCadastroInfo());
			statusLabel.setText(mt.getFileName());			
		}else {
			jTFNome.setText("");
			jTFFone.setText("");
			jSIdade.setValue(0);
			info.setText(mt.getCadastroInfo());
			statusLabel.setText(mt.getFileName());		
		}		
		
		if (mt.getSize() >= 0) {
			jBtnAnterior.setEnabled(true);
			jBtnProximo.setEnabled(true);
			jBtneditarCliente.setEnabled(true);
			jBtnApagarCliente.setEnabled(true);
		}
	}
	
	//
	private void setEditableForm(boolean editable) {
		jTFNome.setEditable(editable);
		jTFFone.setEditable(editable);
		jSIdade.setEnabled(editable);
	}
	
	//MAIN METHOD
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JanelaCliente();
			}
		});
	}
}