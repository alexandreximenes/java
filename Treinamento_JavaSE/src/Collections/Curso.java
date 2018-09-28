package Collections;

import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<>();
    private Set<Alunos> alunos = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void adiciona(Aula aula){
        this.aulas.add(aula);
    }

    public Set<Alunos> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public void matricula(Alunos aluno) {
        if(aluno != null) alunos.add(aluno);
    }
}
