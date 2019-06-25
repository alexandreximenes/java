package C_ClassesEObjetos.test;


import C_ClassesEObjetos.main.BCarro;

public class BCarroTest {


    public static void main(String[] args) {
        /*
        * C_ClassesEObjetos.main.BCarro@12edcd21 (endereço de memoria)
        * null - null - 0.0 (metodo toString da Classe BCarro)
        * */
        BCarro carro = new BCarro();
        System.out.println(carro);

        /**
         * Criando um carro com dados
         */

        carro.modelo = "gol";
        carro.velocidadeMaxima = 160;
        carro.placa = "AAA-1234";
        System.out.println(carro); //gol - AAA-1234 - 160.0
    }



}
