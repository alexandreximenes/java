package A_Basic;

public class FOperadoresLogicos {


    public static void main(String[] args) {

        boolean resultado = 10>10 && true; //false
        System.out.println(resultado);

        resultado = 10>10 & true; //false
        System.out.println(resultado);

        resultado = 10>10 || true; //true
        System.out.println(resultado);


        resultado = 10>10 | true; //true
        System.out.println(resultado);

    }
}
