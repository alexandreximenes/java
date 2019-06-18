package B_Arrays;

import java.util.Arrays;

public class AArraysPrimitivos {
    public static void main(String[] args) {
        /**
         * Iniciado com valor padrão.
         * Neste caso int, o valor padrão é 0
         */

        /**
         * byte, short, int long float double [valor padrão é 0]
         */

        int [] idade = new int[3];
        System.out.println(idade[2]);
        System.out.println(Arrays.toString(idade));

        /*
         * char '\u0000' ''
        */
        char [] letra = new char[4];
        System.out.println(letra);
        letra[2] = 'A';
        System.out.println(Arrays.toString(letra));
        /*
         * boolean false
         * */

        boolean [] tabelaV = new boolean[3];
        System.out.println(tabelaV);
        tabelaV[0] = true;
        System.out.println(Arrays.toString(tabelaV));


        /*
         * reference null
         */

        String[] nomes = new String[3];
        System.out.println(nomes);
        nomes[0] = "Alexandre";
        System.out.println(Arrays.toString(nomes));


        /***
         * Resultado
         * 0
         * [0, 0, 0]
         */

        /**
         * Fill
         */
        idade[0] = 10;
        idade[1] = 20;
        idade[2] = 30;

        System.out.println(idade[2]);
        System.out.println(Arrays.toString(idade));
        /**
         * Resultado
         * 30
         * [10, 20, 30]
         */
    }
}
