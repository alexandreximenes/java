import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Validadora {



    public static void main(String[] args) {

        Servidor servidor = new Servidor();

        try {
            Validadora stub = (Validadora) UnicastRemoteObject.exportObject(servidor, 0);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            registry.bind("validador", stub);

            System.out.println("Servidor RMI esta pronto!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean validar(String cpf) throws RemoteException {
        return true;
    }
}
