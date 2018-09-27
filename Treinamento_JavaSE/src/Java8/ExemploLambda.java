package Java8;

public class ExemploLambda {

    public static void main(String[] args) {

        /**
         * 1º solução
         */
        InterfaceLambda in = () -> System.out.println("my first lambda using function");
        in.print();


        /**
         * 2º solução
         */
        InterfaceLambda lambda = new InterfaceLambda() {
            @Override
            public void print() {
                System.out.println("inner class lamba");
            }
        };

        lambda.print();
    }
}
