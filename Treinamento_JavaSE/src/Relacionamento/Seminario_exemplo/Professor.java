package Relacionamento.Seminario_exemplo;

import java.util.List;

public class Professor {
    private String nome;
    private Especialidade especialidade;
    private List<Seminario> semanarios;

    public Professor(String nome, Especialidade especialidade, List<Seminario> semanarios) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.semanarios = semanarios;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", especialidade=" + especialidade +
                ", semanarios=" + semanarios +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Seminario> getSemanarios() {
        return semanarios;
    }

    public void setSemanarios(List<Seminario> semanarios) {
        this.semanarios = semanarios;
    }
}
