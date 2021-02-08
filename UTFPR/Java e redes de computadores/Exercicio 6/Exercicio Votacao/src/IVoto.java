import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVoto extends Remote {

    public void votar(Voto voto) throws RemoteException;
    public void listar() throws RemoteException;
    public void contar() throws RemoteException;
}
