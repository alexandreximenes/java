/**
 * @autor Alexandre Ximenes
 * Testando a performance das estruturas de dados herdadas de Set e List
 * Set � mais rapido para pesquisa e remo��o de dados, n�o garante a ordena��o dos dados
 * List � mais rapido para adicionar dados e pode ordenar os dados
 */
import java.util.ArrayList;
import java.util.Collection;

public class TestaPerformance {

    public static void main(String[] args) {

        Collection<Integer> numeros = new ArrayList<Integer>();
        /**
         * teste com 50_000 
         * Inser��o arraylist : 9.0
         * Inser��o com HashSet: 17.0
         * 
         * BUSCA
         * com ArrayList : 16217
         * com HashSet   : 26
         * 
         * ArrayList e LinkedList para add � mais rapido.
         * HashSet para pesquisa 460 vz mais rapido
         */
        
        double inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50_000; i++) {
            numeros.add(i);
        }

        double fim = System.currentTimeMillis();

        double tempoDeExecucao = (fim - inicio);

        System.out.println("Tempo gasto: " + tempoDeExecucao);

        inicio = System.currentTimeMillis();

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }
        
        numeros.forEach(a -> System.out.println(a));

        fim = System.currentTimeMillis();

        tempoDeExecucao = (fim - inicio);

        System.out.println("Tempo gasto: " + tempoDeExecucao);
        System.out.println(35 / tempoDeExecucao);
        System.out.println(tempoDeExecucao / 35);

    }

}