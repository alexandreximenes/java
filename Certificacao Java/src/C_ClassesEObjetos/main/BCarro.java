package C_ClassesEObjetos.main;

public class BCarro {
    public String modelo;
    public String placa;
    public float velocidadeMaxima;

    @Override
    public String toString() {
        System.out.println(super.toString());
        return modelo + " - " + placa + " - " + velocidadeMaxima;
    }
}
