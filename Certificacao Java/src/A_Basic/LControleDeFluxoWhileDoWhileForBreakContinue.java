package A_Basic;

import java.util.Arrays;

public class LControleDeFluxoWhileDoWhileForBreakContinue {

    public static void main(String... args) {
        int contador = 1;
        /**
         * While
         * resposta: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
         */
        //Label
        paraNoCinco:
        while (contador <= 10) {
            System.out.print(contador + ", ");
            if (contador == 5)
                break paraNoCinco;
            contador++;
        }

        /**
         * Do while
         * vai executar apenas 1 vez
         * Resposta = 20
         */
        contador = 20;
        do {
            System.out.print(contador + ", ");
            contador++;
            if (contador == 25)
                break;
        } while (contador < 20);


        /**
         * Continue funciona diferente do break
         * Break para a executação
         * o Continue pula a execução corrente.
         */
        System.out.println("\nContinue: ");
        for (int x = 50; x >= 35; x--) {
            if (x == 40)
                continue;
            System.out.print(x + ", ");
        }
        System.out.println("\nContinue [finish]");

        for (int contadorFor = 30; contadorFor <= 40; contadorFor++) {
            System.out.print(contadorFor + ", ");
            if (contadorFor == 35)
                break;
        }

        //resultado de tudoa até aqui 1, 2, 3, 4, 5, 20, 30, 31, 32, 33, 34, 35,

        /**
         * Imprimir os numero pares de 0 a 100
         * numeros pares: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
         */
        System.out.print("numeros pares: ");
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.print(i + ", ");
            else {
                System.out.print(i + ", ");
            }
        }

        /**
         * Numeros pares e impares
         */

        int[] pares = new int[100];
        int[] impares = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) //PAR
                pares[i] = i;
            else //IMPAR
                impares[i] = i;
        }

        System.out.print("\nPARES: " +Arrays.toString(pares));
        System.out.println("\nIMPARES: "+ Arrays.toString(impares));

        /**
         * Sò para exemplificar, essa não é solução para preencher os arrays.
         * PARES: [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16, 0, 18, 0, 20, 0, 22, 0, 24, 0, 26, 0, 28, 0, 30, 0, 32, 0, 34, 0, 36, 0, 38, 0, 40, 0, 42, 0, 44, 0, 46, 0, 48, 0, 50, 0, 52, 0, 54, 0, 56, 0, 58, 0, 60, 0, 62, 0, 64, 0, 66, 0, 68, 0, 70, 0, 72, 0, 74, 0, 76, 0, 78, 0, 80, 0, 82, 0, 84, 0, 86, 0, 88, 0, 90, 0, 92, 0, 94, 0, 96, 0, 98, 0]
         * IMPARES: [0, 1, 0, 3, 0, 5, 0, 7, 0, 9, 0, 11, 0, 13, 0, 15, 0, 17, 0, 19, 0, 21, 0, 23, 0, 25, 0, 27, 0, 29, 0, 31, 0, 33, 0, 35, 0, 37, 0, 39, 0, 41, 0, 43, 0, 45, 0, 47, 0, 49, 0, 51, 0, 53, 0, 55, 0, 57, 0, 59, 0, 61, 0, 63, 0, 65, 0, 67, 0, 69, 0, 71, 0, 73, 0, 75, 0, 77, 0, 79, 0, 81, 0, 83, 0, 85, 0, 87, 0, 89, 0, 91, 0, 93, 0, 95, 0, 97, 0, 99]
         */
    }

}
