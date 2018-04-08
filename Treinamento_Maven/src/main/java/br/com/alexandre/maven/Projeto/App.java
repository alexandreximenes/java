package br.com.alexandre.maven.Projeto;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Collection<Integer> numeros = new ArrayList<Integer>();
        /**
         * teste com 50_000 
         * Inserção arraylist : 9.0
         * Inserção com HashSet: 17.0
         * 
         * BUSCA
         * com ArrayList : 16217
         * com HashSet   : 26
         * 
         * ArrayList e LinkedList para add é mais rapido.
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
