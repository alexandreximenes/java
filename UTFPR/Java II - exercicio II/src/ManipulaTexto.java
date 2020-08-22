
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ManipulaTexto {
	
	/*INSTANCE VARIABLES*/
	private File file;
	private JanelaCliente userInterface;
	
	//
	private ArrayList<Cliente> cadastro;
	private Cliente current;
	

	/*CONSTRUCTORS*/
	public ManipulaTexto(JanelaCliente userInterface) {
		file = null;
		cadastro=null;
		current=null;
		this.userInterface = userInterface;
	}
	
	//
	@SuppressWarnings("unchecked")
	public boolean abrirArquivo() {
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
		
		//usando o this a janela é centrada na janela da aplicação. O FileChooser é modal
		if (result == JFileChooser.CANCEL_OPTION) {
			return false;//finaliza a execuçao do metodo
		}
		
		file = fileChooser.getSelectedFile();
		System.out.println(fileChooser.getName());
		
		//file name is valid?
		if (file == null || file.getName() == "") {
			//no: warning!	
			JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", 
					"Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
			return false;
			
		}else {
			//yes: procede load data from file / update interface
			try { 	
				cadastro = (ArrayList<Cliente>) readObject(file);
				current = cadastro.get(0);
				userInterface.updateData();
				return true;
			
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false; 
	}
	
	//write array of objects to a file
	public static void writeObject(Object o, File file) throws IOException {
		
		ObjectOutputStream objectOutput = null;
		FileOutputStream fileOutput = null;
		
		try {
			//file exist and is readable?
			if(file.exists() && file.canWrite()) {
				//yes:
				System.out.println("write at:"+file.getAbsolutePath());

				//create chain of streams
				fileOutput = new FileOutputStream(file);
				objectOutput = new ObjectOutputStream(fileOutput);
				
				//operation
				objectOutput.writeObject(o);
				
				//close streams
				objectOutput.close();
				fileOutput.close();
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Write Done!");
	}	
	
	//read array of objects to a file
	private static Object readObject(File file) throws IOException {
		
		ObjectInputStream objectInput = null;
		FileInputStream fileInput = null;
		Object obj=null;
		
		try {
			//file exist and is readable?
			if (file.exists() && file.canRead()) {
				//yes:
				System.out.println("read at:"+file.getAbsolutePath());
				
				//create stream chain
				fileInput = new FileInputStream(file);
				objectInput = new ObjectInputStream(fileInput);
				
				//read operation
				obj = objectInput.readObject();
				
				//close streams
				fileInput.close();
				objectInput.close();
			}else {
				//no: 
				System.out.println("Arquivo inexistente ou impossível de ler");
			}
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Read Done!");
		return obj;
	}	

	//only create a file
	public boolean createFile() {

    	JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
        //usando o this a janela é centrada na janela da aplicação. O FileChooser é modal
        
        if (result == JFileChooser.CANCEL_OPTION) {
            return false;
        }
        
        file = fileChooser.getSelectedFile();
        System.out.println(fileChooser.getName());
    
        //file name is null or empty?
        if (file == null || file.getName().equals("")) {
        	//yes:
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
            return false;
 			
        } else {
        	//no: check if the file exists...
            try {
            	//file exists?
            	if (file.exists()) {
            		//yes: do nothing.
            		System.out.println("Arquivo existe: "+file.getAbsolutePath());
            	}else {
            		//no: create file.
            		System.out.println("Arquivo não existe: "+file.getAbsolutePath());
            		file.createNewFile();
            	}
            	
            	//procede load data from file / update interface
            	cadastro =  new ArrayList<Cliente>();
            	current = null;
            	userInterface.updateData();
            	return true;
            	
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
	}
	
	//
	public void printCadastro() {
		for (Cliente c : cadastro) {
			System.out.println(c);
		}
	}
	
	//
	public Cliente getCurrentCliente() {
		return current;
	}
	
	//
	public boolean getNextCliente() {
		
		int index = cadastro.indexOf(current);//5
		
		if(index >= cadastro.size()-1) {//6
			System.out.println("ultimo");
			return false;
		}else {
			current = cadastro.get(index+1);
			System.out.println("next");
			return true;
		}
	}
	
	//
	public boolean getPrevCliente() {
		
		int index = cadastro.indexOf(current);//5
		
		if(index <=0) {//6
			System.out.println("primeiro");
			return false;
		}else {
			current = cadastro.get(index-1);
			System.out.println("prev");
			return true;
		}
	}
	
	//
	public String getFileName() {
		if (file != null) {
			return file.getAbsolutePath();					
		}else {
			return "Nenhum Arquivo";
		}
	}
	
	//
	public void saveFile() {
		
		try {
			writeObject(cadastro, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//
	public void novoCliente() {
		Cliente novo = new Cliente();
		cadastro.add(novo);
		current = novo;
		userInterface.updateData();
	}

	//
	public void apagarCliente(Cliente c) {

		int index = cadastro.indexOf(c);
		
		//there is only 1 register
		if (index == 0 && cadastro.size() ==1) {
			cadastro.remove(c);
			current=null;
			
		}else if (index == 0 && cadastro.size() > 1) {
			cadastro.remove(c);
			current = cadastro.get(0);
		
		}else if (index == cadastro.size()-1 && cadastro.size() > 1) {
			cadastro.remove(c);
			current = cadastro.get(cadastro.size()-1);
						
		}
		userInterface.updateData();
	}

	//
	public void gravarCadastro(Cliente c) {
		
		if(file != null) {
			current.setNome(c.getNome());
			current.setFone(c.getFone());
			current.setIdade(c.getIdade());
			saveFile();
			userInterface.updateData();			
		}else {
			createFile();
		}
		userInterface.setGravarOff();
	}
	
	//
	public void editarCliente()	{
		gravarCadastro(current);
		saveFile();
		userInterface.updateData();	
	}

    //
    public String getCadastroInfo(){
    	String info;
    	if (cadastro != null) {
    		info = "  Quantidade de Cadastros:"+cadastro.size()+
    				" [Atual:"+(cadastro.indexOf(current)+1)+"]"; 
    	}else {
    		info = "Nenhum Cadastro";
    	}
    	return info;
    }

	//
    public int getSize() {
		return cadastro.size();
	}
}