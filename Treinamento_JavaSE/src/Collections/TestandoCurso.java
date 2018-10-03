package Collections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TestandoCurso {
    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.adiciona(new Aula("Aula 1", 25));
        curso.adiciona(new Aula("Aula 2", 20));
        curso.adiciona(new Aula("Aula 3 ", 10));

        Collection<Aula> aulas = new ArrayList<>(curso.getAulas());

        Alunos alexandre = new Alunos("Alexandre", "123");
        curso.matricula(alexandre);
        System.out.println(aulas);

        aulas.stream().sorted(Comparator.comparing(Aula::getTempo)).map(a -> a.getTempo()).forEach(System.out::println);


        Set<Alunos> alunos = new LinkedHashSet<>(curso.getAlunos());

//        alunos.stream().forEach();
        boolean first = alunos.contains(alexandre);
        System.out.println(first);

        Set<Alunos> alunos1 = Collections.synchronizedSet(curso.getAlunos());
                                                                   // ou numero ex: 10
//        ArrayBlockingQueue<Alunos> alunos2 = new ArrayBlockingQueue<Alunos>( 10 );
        ArrayBlockingQueue<Alunos> alunos2 = new ArrayBlockingQueue<Alunos>( curso.getAlunos().size() );

//        Lock lock =(Lock) TimeUnit.SECONDS;
//        try {
//
//            System.out.println(alunos1.toString());
//            lock.tryLock(10, TimeUnit.SECONDS);
//            System.out.println(alunos2.poll());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
