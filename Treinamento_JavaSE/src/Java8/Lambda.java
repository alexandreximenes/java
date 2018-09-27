package Java8;

public class Lambda {

    public static void main(String[] args) {

        Runnable minha_lambda = () -> System.out.println("minha lambda");

        minha_lambda.run();
    }
}
