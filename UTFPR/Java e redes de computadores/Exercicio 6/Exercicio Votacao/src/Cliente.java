import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IVoto stub = (IVoto) registry.lookup("votar");

            String sair = "n";
            Scanner scanner = new Scanner(System.in);
            do{
                System.out.println("Para quem deseja votar");
                String nome = scanner.nextLine();

                Voto voto = new Voto(nome, 1);
                stub.votar(voto);

                System.out.println("Deseja continuar ?");
                sair = scanner.nextLine();

            }while (sair.equals("s"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
