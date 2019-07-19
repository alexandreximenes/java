package G_MetodosEstaticos;


public class ABlocoDeInicializacao {

    public double quantidadeCarros;

    public static void main(String[] args) {

        //quantidadeCarros = 1; //no-compile

        BCarro mercedes = new BCarro("Mercedes Benz", 280);
        BCarro bmw = new BCarro("BMW", 250);
        BCarro audi = new BCarro("Audi", 300);

        mercedes.imprime();
        bmw.imprime();
        audi.imprime();

        BCarro.setVelocidadeLimite(200);

        mercedes.imprime();
        bmw.imprime();
        audi.imprime();

    }


}
