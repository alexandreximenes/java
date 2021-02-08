import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Servidor implements IVoto {

    List<Voto> votos = new ArrayList<>();

    public static void main(String[] args) {

        Servidor s = new Servidor();

        try {
            IVoto voto = (IVoto) UnicastRemoteObject.exportObject(s, 0);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            registry.bind("votar", voto);

            System.out.println("Servidor rodando na porta 1099...");

            while (true){
                s.contar();
                Thread.sleep(5000);
            }
        } catch (RemoteException | AlreadyBoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void votar(Voto v) throws RemoteException {

        if (votos.contains(v)) {
            int indexOf = this.votos.indexOf(v);
            Voto voto = votos.get(indexOf);

            this.votos.remove(voto);
            voto.setVotos(voto.getVotos() + v.getVotos());
            this.votos.add(voto);
            System.out.println("Voto atualizado: " + voto);
        }else{
            votos.add(v);
            System.out.println("Voto adicionado: " + v);
        }
    }

    @Override
    public void listar() throws RemoteException {
        votos.stream().forEach(System.out::println);
    }

    @Override
    public void contar() throws RemoteException {
        System.out.println("========================= Verificando se tem votos =========================");
        System.out.println("Data: " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        if (!votos.isEmpty()) {
            votos.stream().forEach(System.out::println);
        }else{
            System.out.println("0 votos para contabilizar");
        }
    }

}
