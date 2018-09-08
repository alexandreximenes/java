package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

public class TestandoCurso {

    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Java", 150));
        cursos.add(new Curso("JavaScript", 180));
        cursos.add(new Curso("Node JS", 20));
        cursos.add(new Curso("HTML e CSS", 1500));

//        cursos.sort(comparing(Curso::getAlunos));
        out.println(cursos);

        String list = cursos.stream()
//                .sorted(comparing(Curso::hashCode))
//                .sorted(comparing(Curso::getNome))
                .filter(c -> c.getAlunos() > 160)
                .map(c -> c.getNome() + " - " + c.getAlunos())
//                .sorted(comparing(Curso::getAlunos).reversed())
//                .forEach(out::println);
//                .collect(Collectors.toList());
                .collect(Collectors.joining("| "));

        System.out.println(list);
    }
}
