package A_Basic;

import java.text.NumberFormat;
import java.util.Locale;

public class COperadoresMatematicosBasico {

    public static void main(String[] args) {

        /**
         * Não é usual, mas variaveis podem começar com $_
         */
        int numero1 = 10;
        int $numero2 = 15; //whats, Is this PHP?
        int _soma = numero1 + $numero2;

        /**
         * Se tiver uma String no println ele vai interpretar o + como concatenação.
         */
        System.out.println("A soma é "+numero1+$numero2); //Pegadinha resultado 1015

        System.out.println("A soma é " + _soma); // resultado 25

        System.out.println("A soma é " + (numero1+$numero2)); // resultado 25
        System.out.println("A multiplicação é " + (numero1*$numero2)); // resultado 150
        System.out.println("A subtracao é " + (numero1-$numero2)); // resultado -5
        System.out.println("A divisao é " + (numero1/$numero2)); // resultado 0

        String somaFormatada = NumberFormat.getCurrencyInstance().format((numero1 + $numero2) + (numero1 + $numero2));
        System.out.printf(new Locale("pt", "BR", ""), "A soma é %s", somaFormatada); // resultado 25
        // R$ 50,00

        somaFormatada = NumberFormat.getCurrencyInstance(Locale.CHINA).format((numero1 + $numero2) + (numero1 + $numero2));
        System.out.printf("\nA soma é %s", somaFormatada); // resultado 25
        //￥50.00
    }


}
