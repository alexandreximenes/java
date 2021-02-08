import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    public static void main(String[] args) {

        try{

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Validadora stub = (Validadora) registry.lookup("validador");

            boolean validou = stub.validar("12345678910");
            if(validou)
                System.out.println("CPF validado");
            else
                System.out.printf("CPF invalido");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
