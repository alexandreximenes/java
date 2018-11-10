package Relacionamento.Seminario_exemplo;

public class Aluno {
    private String nome;
    private int idade;
    private Seminario Seminario;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Relacionamento.Seminario_exemplo.Seminario getSeminario() {
        return Seminario;
    }

    public void setSeminario(Relacionamento.Seminario_exemplo.Seminario seminario) {
        Seminario = seminario;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", Seminario=" + Seminario +
                '}';
    }
}
