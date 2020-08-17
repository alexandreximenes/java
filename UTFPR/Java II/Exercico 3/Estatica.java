/*
 * Estatica.java
 * @author fabricio@utfpr.edu.br
 */
package estatico;

public class Estatica {

    public static int num = 0;
    public static double[] aleatorios = new double[10];
    
    static{
        for (int i = 0; i< aleatorios.length; i++){
            aleatorios[i] = Math.random();
        }
    }

    static {
        System.out.println("Inicializador Estatico 1 !");
        System.out.println(num++);
    }

    public Estatica() {
        System.out.println("Metodo Construtor!");
        System.out.println(num++);
    }

    static {
        System.out.println("Inicializador Estatico 2 !");
        System.out.println(++num);
    }

    public static void Inicializa() {
        System.out.println("metodo estatico Inicializa sendo executado");
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = i + 1;
        }
    }

    public static void Imprime() {
        System.out.println("metodo estatico Imprime sendo executado");
        for (int i = 0; i < aleatorios.length; i++) {
            System.out.println(aleatorios[i]);
        }
    }

    static {
        System.out.println("Inicializador Estatico 3 !");
    }

    public static void main(String[] args) {
        System.out.println("Execução do método main!");
        Estatica e1 = new Estatica();
        //Estatica e2 = new Estatica();
        //Estatica.Inicializa();
        //Estatica.Imprime();
        Estatica.num = 0;
        System.out.println(e1.num);
        
        e1.num = 3;
        System.out.println(Estatica.num);
        //e1.num = 1;
        //Estatica.aleatorios[0] = 25;
        //Estatica.Imprime();
    }
}