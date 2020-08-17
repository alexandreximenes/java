
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            
            DatagramSocket dgSocket = new DatagramSocket();
            byte[] msg = new byte[128];

            String piada = null;
            System.out.println("PEDINDO PIADA A CADA 5 SEGUNDOS");
            do{

                String solicitacao = "Mande uma piada";
                msg = solicitacao.getBytes();

                InetAddress endereco = InetAddress.getByName("localhost");

                DatagramPacket dgPacket = new DatagramPacket(msg, msg.length, endereco, 60000);

                dgSocket.send(dgPacket);

                msg = new byte[128];

                dgPacket = new DatagramPacket(msg, msg.length);

                dgSocket.receive(dgPacket);

                piada = new String(dgPacket.getData());
                System.out.println(piada);
                Thread.sleep(5000);

            }while(piada != null);
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
