public abstract class Pessoa {

    private String nome;
    private int idade;

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

    abstract void imprimirInformacoes();
}

class Funcionario extends Pessoa{

    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    void imprimirInformacoes() {
        System.out.println("Informações de Funcionario: Nome: "+this.getNome() + " idade: " + this.getIdade() + " salario: " + this.getSalario());
    }
}

class Aluno extends Pessoa{

    @Override
    void imprimirInformacoes() {
        System.out.println("Informações de Funcionario: Nome: "+this.getNome() + " idade: " + this.getIdade());
    }
}

class Principal{

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        Funcionario funcionario = new Funcionario();

        aluno.setNome("Alexandre");
        aluno.setIdade(30);

        funcionario.setNome("Dayane");
        funcionario.setIdade(30);
        funcionario.setSalario(50_000);

        aluno.imprimirInformacoes();
        funcionario.imprimirInformacoes();
    }
}