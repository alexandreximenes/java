package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

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


        /**
         * Trabalhando com Optional
         */

        //Optional<Curso> first =
        cursos.stream()
                .filter(c -> c.getAlunos() > 2000)
//                findFirst()
                .findAny()
//                .orElse(null)
//                .orElseThrow(() -> new RuntimeException("Ocorreu um erro"));
                .ifPresent(c -> System.out.println(c.getNome()));

        out.println("Cursos - "+cursos);


        /***
         * Trabalhando com Map
         */

//        Map<String, Integer> mapCursos =
                cursos.stream()
                .filter(c -> c.getNome().startsWith("J"))
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
                )).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));


        cursos.parallelStream()
                .filter(c -> c.getNome().startsWith("N"))
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
                )).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

    }
}
