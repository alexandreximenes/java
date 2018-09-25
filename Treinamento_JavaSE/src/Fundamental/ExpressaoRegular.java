package Fundamental;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {
    public static void main(String[] args) {

        boolean m = //"81.900-400".replace(".", "").replace("-", "").matches("\\d{8}");
        m = "80.080-008".matches("\\d{2}\\.\\d{3}-\\d{3}");

        m = "25/09/2018".matches("\\d{2}/\\d{2}/\\d{4}");

        //Inicia com Letras e termina com 0 ou mais caracteres
        m = "Alexandre2018".matches("^\\w.*");

        //Inicia com letra, ignorando letras maisuculas e minusculas
        // pode conter 0 ou mais caracteres no meio
        // e termina com 2 com limite de 4 numeros
        m = "Alexandr       e2018".matches("^(?i)\\w.*\\d{2,4}$");

        // Inicia com Letras M ou m, pode conter 0 ou mais caracteres e termina com numeros
        m = "Blexandr Tiago Ximenes 2018".matches("^(?i)\\w.*\\d$");

        //Validando CPF
        String s = "001.002.003-04".replaceAll("(\\.|-)", "");
        System.out.println(":"+s);

        String [] token = "001.002.003-04".split("(\\.|-)");
        System.out.println(Arrays.toString(token));

        m = "Blexandr Tiago Ximenes 2018".matches("^(?i)(\\w.*)(\\d)$");

        System.out.println(m);

        s = "Qual é o dOce mais dOCE que o dOCe? É o DocE de batata dOcE.";
//        Pattern compile = Pattern.compile(s);
        Matcher matcher = Pattern.compile("(?i)doce").matcher(s);
        while(matcher.find())
            System.out.println(matcher.group());

    }
}
