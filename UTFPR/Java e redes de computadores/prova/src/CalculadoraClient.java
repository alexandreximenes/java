
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculadoraClient {
    
    public static void main(String[] args) {
        
        try {
            
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            Calculadora stub = (Calculadora) registro.lookup("calculadora");

            long dez = 10;
            long cinco = 5;

            System.out.println("O calculo de " + dez + " + " + cinco + " = " + stub.add(dez, cinco));
            System.out.println("O calculo de " + dez + " - " + cinco + " = " + stub.sub(dez, cinco));
            System.out.println("O calculo de " + dez + " / " + cinco + " = " + stub.div(dez, cinco));
            System.out.println("O calculo de " + dez + " * " + cinco + " = " + stub.mul(dez, cinco));

        } catch(Exception e) {

        }
        
    }
    
}
