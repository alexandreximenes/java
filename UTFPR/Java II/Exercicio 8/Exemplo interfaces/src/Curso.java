import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


interface Matricula{

    public void matricular(Curso curso, Aluno aluno);

}

public class Curso {

    private String nome;

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class SistemaAcademico implements Matricula{

    private Aluno aluno;
    private Curso curso;
    private Map<Curso, Aluno> cursoAlunoMap = new HashMap<>();

    @Override
    public void matricular(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
        //validações
        //....
        //salva
        cursoAlunoMap.put(curso, aluno);
    }
}


class Principal {

    public static void main(String[] args) {

        Aluno a = new Aluno("Alexandre");
        Curso c = new Curso("Especialização Java");

        SistemaAcademico sa = new SistemaAcademico();
        sa.matricular(c, a);

    }

}



