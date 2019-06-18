package A_Basic;

public class KControleDeFluxoWhileDoWhileFor {

    public static void main(String ... args){
        int contador = 1;
        /**
         * While
         * resposta: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
         */
        while(contador <=10){
            System.out.print(contador + ", ");
            contador++;
        }

        /**
         * Do while
         * vai executar apenas 1 vez
         * Resposta = 20
         */
        contador = 20;
        do{
            System.out.print(contador + ", ");
            contador++;
        }while(contador < 20);


        for (int contadorFor = 30 ; contadorFor <= 40; contadorFor++){
            System.out.print(contadorFor + ", ");
        }
    }
}
