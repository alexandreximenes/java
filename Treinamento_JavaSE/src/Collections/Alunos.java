package Collections;

import java.util.Set;

public class Alunos{

    private String nome;
    private String matricula;

    public Alunos() {
    }

    public Alunos(String nome, String matricula) {
        if(nome == null) throw new NullPointerException("Nome nao pode ser nulo!");
        this.nome = nome;
        this.matricula = matricula;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Alunos)) return false;
        Alunos o = (Alunos) obj;
        if(this.nome.equals(o.nome))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
//        return this.nome.charAt(0);
        return this.nome.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
