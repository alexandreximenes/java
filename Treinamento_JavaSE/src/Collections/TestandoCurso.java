package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class TestandoCurso {
    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.adiciona(new Aula("Aula 1", 25));
        curso.adiciona(new Aula("Aula 2", 20));
        curso.adiciona(new Aula("Aula 3 ", 10));

        Collection<Aula> aulas = new ArrayList<>(curso.getAulas());

        System.out.println(aulas);

        aulas.stream().sorted(Comparator.comparing(Aula::getTempo)).map(a -> a.getTempo()).forEach(System.out::println);




    }
}
