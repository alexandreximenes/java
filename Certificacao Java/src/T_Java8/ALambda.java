package T_Java8;

import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class ALambda {
    public static void main(String[] args) {
        /**
         * 1
         */
        Consumer<String> stringConsumer = (String msg) -> System.out.println(msg);
        stringConsumer.accept("Minha primeira mensagem com Lambda");

        /**
         * 2
         */
        stringConsumer = (msg) -> System.out.println(msg);
        stringConsumer.accept("Minha segunda mensagem com Lambda");

        /**
         * 3
         */
        stringConsumer = msg -> System.out.println(msg);
        stringConsumer.accept("Minha terceira mensagem com Lambda");

        /**
         * 4
         */
        IntBinaryOperator intBinaryOperator = (int x, int y) -> x + y;
        int res = intBinaryOperator.applyAsInt(10, 10);
        System.out.println(res);
    }
}
