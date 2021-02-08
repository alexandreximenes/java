
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class CalculadoraServerImpl implements Calculadora {
    
    public CalculadoraServerImpl() {
    }

    public static void main(String[] args) {
        try {
            
            CalculadoraServerImpl s = new CalculadoraServerImpl();
            
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(s, 0);

            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            registro.bind("calculadora", stub);
            
            System.out.println("Servidor RMI está pronto!");
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public long add(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long sub(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long mul(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long div(long a, long b) throws RemoteException {
        return a / b;
    }
}
