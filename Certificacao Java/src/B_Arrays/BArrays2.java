package B_Arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class BArrays2 {
    public static void main(String[] args) {

        /**
         * Primeira forma de iniciar um array primitivo
         */
        int[] numero = new int[5];

        /**
         * Segunda forma de iniciar um array primitivo
         */
        int[] numero2 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numero)); //[0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(numero2)); //[1, 2, 3, 4, 5]

        /**
         * For to java > 5
         * Result: 2, 4, 6, 8, 10,
         */
        for (int i: numero2) {
            System.out.printf("%d, ", i*2);
        }

        /**
         *
         */
        var i = "A";
        System.out.println(i);

    }
}
