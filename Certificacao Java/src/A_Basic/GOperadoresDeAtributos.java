package A_Basic;

import java.math.BigDecimal;

public class GOperadoresDeAtributos {


    public static void main(String[] args) {

        /**
         * =, atribui o valor da direta para a esquerda
         * +=, soma o proprio valor + o valor da direita => var0 =+ 2
         *     é a mesma coisa que var0 = var0 + 2
         * -=, idem
         * /=, idem
         * *=, idem
         * %=  idem
         */
        int resultado = 10+10;
        resultado += 10; //30
        System.out.println(resultado);
        resultado -= 10; //20
        System.out.println(resultado);
        resultado /= 10; //2
        System.out.println(resultado);
        resultado *= 10; //20
        System.out.println(resultado);
        resultado %= 10; //0
        System.out.println(resultado);

        resultado = 1600;
        resultado *= 0; //0
        System.out.println("multiplicação por 0 "+ resultado);


        float OutroCalculoResultado = 10 + (float)10/2 + (4 - (float)2/6); //18,666666..
        System.out.println("OutroCalculoResultado "+OutroCalculoResultado);
        double OutroCalculoResultado2 = 10 + (10/2) + 4 - (2/6); //18,666666.. mas calcula 19.0
        System.out.println(OutroCalculoResultado2);
        int OutroCalculoResultadoInteiro = 10 + 10/2 + 4 - 2/6; //19
        System.out.println(OutroCalculoResultadoInteiro);

        BigDecimal bigDecimal = new BigDecimal(10 + 10/2 + 4 - 2/6);//19
        System.out.println(bigDecimal);


        //divisão por 0 causa erro ArithmeticException e para a execução
        resultado /= 0; //0
        System.out.println("divisao por 0 "+ resultado);
        System.out.println("divisao por 0/0 "+ 0/0);
        /*
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at A_Basic.GOperadoresDeAtributos.main(GOperadoresDeAtributos.java:37)
         * */


    }
}
