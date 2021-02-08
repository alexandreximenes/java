import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validadora extends Remote {

    boolean validar(String cpf) throws RemoteException;
}
