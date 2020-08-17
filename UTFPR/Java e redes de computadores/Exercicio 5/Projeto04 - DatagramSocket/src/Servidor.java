import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


public class Servidor {

    private static final List<String> piadas = readPiadas();

    private static List<String> readPiadas() {

        List<String> piadasList = new ArrayList<>();
        try {
            File file = new File("piadas.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                piadasList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return piadasList;
    }

    public static void main(String[] args) {

        try {

            System.out.println("Servidor escutando na porta 60000");
            DatagramSocket dgSocket = dgSocket = new DatagramSocket(60000);

            String solicitacao = null;

            for (String piada : piadas) {

                sendMessage(dgSocket, piada);
            }

            sendMessage(dgSocket, "Sem mais piadas para enviar");

        } catch (Exception e) {

        }
    }

    private static void sendMessage(DatagramSocket dgSocket, String piada) {
        String solicitacao;
        try {

            byte[] msg = new byte[128];

            DatagramPacket dgPacket = new DatagramPacket(msg, msg.length);

            System.out.println("Aguardando ...(Mande uma piada)");
            dgSocket.receive(dgPacket);

            solicitacao = new String(dgPacket.getData());

            if (solicitacao.contains("Mande uma piada")) {

                InetAddress endereco = dgPacket.getAddress();
                int porta = dgPacket.getPort();

                msg = new byte[128];

                msg = piada.getBytes();

                dgPacket = new DatagramPacket(msg, msg.length, endereco, porta);

                System.out.println("Enviando mensagem ("+ piada +") para o cliente");
                dgSocket.send(dgPacket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
