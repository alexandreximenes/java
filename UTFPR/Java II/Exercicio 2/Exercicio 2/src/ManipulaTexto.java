package src;

import java.io.*;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author fabricio@utfpr.edu.br
 */
public class ManipulaTexto {

    private File arquivo;
    private BufferedReader entrada;
    private BufferedWriter saida;

    public void ManipulaTexto() {
        arquivo = null;
        entrada = null;
        saida = null;
    }

    public File criarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
        //usando o this a janela é centrada na janela da aplicação. O FileChooser é modal
        if (result == JFileChooser.CANCEL_OPTION) {
            return null;//finaliza a execuçao do metodo
        }
        arquivo = fileChooser.getSelectedFile();
        if (arquivo.isDirectory()) {
            System.out.println("Arquivo selecionado "+arquivo.getAbsolutePath());
            File currentDirectory = fileChooser.getSelectedFile();
            arquivo = new File(currentDirectory + "/src/arquivo.txt");
            JOptionPane.showMessageDialog(null, "Criamos um arquivo para você chamado (" + arquivo.getName() + ")");
            System.out.println("Arquivo selecionado "+arquivo.getAbsoluteFile());
        }else{
            System.out.println("Arquivo selecionado "+arquivo.getAbsoluteFile());
        }

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (arquivo.exists()) {
                    saida = new BufferedWriter(new FileWriter(arquivo, true));//true(append).
                    System.out.println("existe");
                } else {
                    saida = new BufferedWriter(new FileWriter(arquivo, false));//false(rewrite).
                    System.out.println("NAO existe");
                }
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return arquivo;
    }

    public void fecharArquivo() {
        try {
            if (saida != null) {
                saida.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error ao Fechar Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void GravaClientes(List<Cliente> clientes) {
        if (saida == null && criarArquivo() == null) {
            return;
        }


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clientes);

        } catch (Exception exception) {
            fecharArquivo();
        }

    }

    public void GravaCliente(Cliente cliente) {
        if (saida == null || criarArquivo() == null) {
            return;
        }

        try {
            saida.write(cliente.getNome() + "\n");
            saida.write(cliente.getIdade() + "\n");
            saida.write(cliente.getFone() + "\n");
            saida.write("xxx\n");
            saida.flush();
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            fecharArquivo();
        }
    }

    public File abrirArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return null;
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(arquivo);

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                entrada = new BufferedReader(new FileReader(arquivo));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return arquivo;
    }

    public List<Cliente> lerRegistros() {
        File arquivo = abrirArquivo();
        if (entrada == null && abrirArquivo() == null) {
            JOptionPane.showMessageDialog(null, "Não conseguimos abrir arquivo!");
            return null;
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(arquivo);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Cliente> clientes = (List<Cliente>) objectInputStream.readObject();

            if (clientes.isEmpty()) {
                return null;
            }
            return clientes;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Cliente lerRegistro() {
        Cliente cliente = null;
        if (entrada == null && abrirArquivo() == null) {
            JOptionPane.showMessageDialog(null, "Não conseguimos abrir arquivo!");
            return null;
        }
        try {
            cliente = new Cliente();
            cliente.setNome(entrada.readLine());
            cliente.setFone(entrada.readLine());
            cliente.setIdade(Integer.parseInt(entrada.readLine()));
            String fim = entrada.readLine();
            if (!fim.equals("xxx")) {
                JOptionPane.showMessageDialog(null, "Erro na leitura do Registro.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
            }
        } catch (EOFException endOfFileException) {
            JOptionPane.showMessageDialog(null, "Nao existem mais registros no arquivo.", "Fim do Arquivo", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Erro durante a leitura do arquivo", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } finally {
            return cliente;
        }
    }
}
