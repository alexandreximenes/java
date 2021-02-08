import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Alexandre Tiago Ximenes
 */

public class BDVeiculos {

    private static List<Passeio> veiculosDePasseio = new LinkedList<>();
    private static List<Carga> veiculosDeCarga = new LinkedList<>();

    public static List<Passeio> getVeiculosDePasseio() {
        return veiculosDePasseio;
    }

    public static void setVeiculosDePasseio(List<Passeio> veiculosDePasseio) {
        BDVeiculos.veiculosDePasseio = veiculosDePasseio;
    }

    public void save(Passeio passeio) throws VeicExistException {

        if (veiculosDePasseio.contains(passeio))
            throw new VeicExistException("Veiculo de passeio já foi cadastrado");
        veiculosDePasseio.add(passeio);
    }

    public void save(Carga carga) throws VeicExistException {
        if (veiculosDeCarga.contains(carga))
            throw new VeicExistException("Veiculo de carga já foi cadastrado");
        veiculosDeCarga.add(carga);
    }

    public static List<Carga> getVeiculosDeCarga() {
        return veiculosDeCarga;
    }

    public static void setVeiculosDeCarga(List<Carga> veiculosDeCarga) {
        BDVeiculos.veiculosDeCarga = veiculosDeCarga;
    }


    public void imprimeVeiculosDePasseio() {
        if (veiculosDePasseio.size() > 0){
            System.out.println("# Imprimindo todos os veiculos de passeio");
            veiculosDePasseio.stream().forEach(System.out::println);
        }else{
            System.out.println("# Não existe veiculo de passeio cadastrado");
        }
    }

    public void imprimeVeiculosDeCarga() {
        if (veiculosDeCarga.size() > 0) {
            System.out.println("# Imprimindo todos os veiculos de carga");
            veiculosDeCarga.stream().forEach(System.out::println);
        } else {
            System.out.println("# Não existe veiculo de carga cadastrado");
        }
    }

    public Passeio buscaVeiculoPasseioPelaPlaca(Passeio passeio) {
        if(veiculosDePasseio.size() > 0 && nonNull(passeio) && nonNull(passeio.getPlaca())){
            for (int i = 0 ; i < veiculosDePasseio.size(); i++){
                if(veiculosDePasseio.get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())){
                    passeio = veiculosDePasseio.get(i);
                    return passeio;
                }
            }
        }
        return null;
    }


    public Carga buscaVeiculoCargaPelaPlaca(Carga carga) {
        if(veiculosDeCarga.size() > 0 && nonNull(carga) && nonNull(carga.getPlaca())){
            for (int i = 0 ; i < veiculosDeCarga.size(); i++){
                if(veiculosDeCarga.get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())){
                    carga = veiculosDeCarga.get(i);
                    return carga;
                }
            }
        }
        return null;
    }

    public boolean existeVeiculoPasseioComA(Passeio passeio) throws VeicExistException {
        if(veiculosDePasseio.size() > 0 && nonNull(passeio) && (nonNull(passeio.getPlaca()))){
            for (int i = 0 ; i < veiculosDePasseio.size(); i++){
                if(veiculosDePasseio.get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())){
                    throw new VeicExistException("Veiculo com a Placa ("+passeio.getPlaca()+") já foi cadastrado");
                }
            }
        }
        return false;
    }

    public boolean existeVeiculoCargaComA(Carga carga) throws VeicExistException {
        if(veiculosDeCarga.size() > 0 && nonNull(carga) && nonNull(carga.getPlaca())){
            for (int i = 0 ; i < veiculosDeCarga.size(); i++){
                if(veiculosDeCarga.get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())){
                    throw new VeicExistException("Veiculo com a Placa ("+carga.getPlaca()+") já foi cadastrado");
                }
            }
        }
        return false;
    }

    public void save(int indexVeiculoCarga, Carga carga) {
        veiculosDeCarga.remove(indexVeiculoCarga);
        veiculosDeCarga.add(indexVeiculoCarga, carga);
    }
    public void save(int indexVeiculoPasseio, Passeio passeio) {
        veiculosDePasseio.remove(indexVeiculoPasseio);
        veiculosDePasseio.add(indexVeiculoPasseio, passeio);
    }

    public int buscaIndexVeiculoPasseioPelaPlaca(Passeio passeioRecuperado) {;
        return veiculosDePasseio.indexOf(passeioRecuperado);
    }
    public int buscaIndexVeiculoCargaPelaPlaca(Carga cargaRecuperado) {;
        return veiculosDeCarga.indexOf(cargaRecuperado);
    }
}
