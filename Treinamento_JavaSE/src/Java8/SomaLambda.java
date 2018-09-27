package Java8;

import java.util.List;

public class SomaLambda {

    public static void main(String[] args) {

        soma s = (double x, double y) -> x + y ;
        System.out.println(s.result(20, 90));


    }

}

interface soma{
    double result(double n1, double n2);
}
