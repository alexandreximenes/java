package Relacionamento.Seminario_exemplo;

import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.asList;

public class TesteSeminario {
    public static void main(String[] args) {
        Seminario seminario = new Seminario();
        Seminario seminario2 = new Seminario();

        seminario.setTitulo("Seminario sobre JavaScript ES6");
        seminario2.setTitulo("Seminario sobre Java 11");

        Set<Aluno> alunos = new HashSet<>();

        Aluno alexandre = new Aluno("Alexandre", 18);
        alexandre.setSeminario(seminario);

        Aluno vanessa = new Aluno("Vanessa", 16);
        vanessa.setSeminario(seminario);

        Aluno amanda = new Aluno("Amanda", 16);
        amanda.setSeminario(seminario);

        Aluno ximenes = new Aluno("Ximenes", 22);
        ximenes.setSeminario(seminario);

        alunos.add(alexandre);
        alunos.add(amanda);
        alunos.add(vanessa);
        alunos.add(ximenes);

        seminario.setAlunos(alunos);

        seminario.setLocal(new Local("Rua x", "Centro"));

        Professor professor = new Professor("Professor bento", new Especialidade("Matematica"), asList(seminario));

        seminario.setProfessor(professor);

        System.out.println(seminario.getTitulo());
        System.out.println(seminario2.getTitulo());
        System.out.println(seminario.getLocal());
        System.out.println(seminario2.getLocal());
        System.out.println(seminario.getProfessor().getNome());
        System.out.println(seminario.getProfessor().getEspecialidade());
        seminario.getAlunos().forEach(System.out::println);
        Set<Aluno> seminario2Alunos = seminario2.getAlunos();
        if(seminario2Alunos!=null) {
            seminario2.getAlunos().forEach(System.out::println);
        }else{
            System.out.println("Seminario 2 não tem alunos inscritos");
        }
        seminario.getProfessor().getSemanarios().forEach(System.out::println);


    }
}
