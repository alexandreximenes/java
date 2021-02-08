import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

    public static final boolean escreveNoArquivo(File file, String str) throws IOException {
        if(file == null){
            file = new File("arquivo.txt");
        }
        BufferedWriter saida = new BufferedWriter(new FileWriter(file, true));
        saida.write(str);
        saida.close();
        return true;
    }

    public static void main(String[] args) throws IOException {

        Principal.escreveNoArquivo(new File("arquivo.txt"), "ola mundo2");

        Calculadora c = new Calculadora() {
            @Override
            public double soma(int a, int b) {
                return a + b;
            }
        };

        double soma = c.soma(10, 10);
        System.out.println(soma);
    }


}
interface Calc{
    double soma(int a, int b);
    abstract double sub(int a, int b);
}
abstract class Calculadora implements Calc{

}

interface Calc2 extends Calc {}

class T extends Thread{}
class calcular extends Calculadora{

    @Override
    public double soma(int a, int b) {
        return a + b;
    }

    @Override
    public double sub(int a, int b) {
        return a - b;
    }
}

