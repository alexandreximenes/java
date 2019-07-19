package G_MetodosEstaticos;

public class BCarro {

    private String nome;
    private double velocidadeMaxima;
    private static double velocidadeLimite = 240;

    {
        velocidadeLimite = 210;
    }

    public BCarro() {
    }

    public BCarro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public static double getVelocidadeLimite() {
        return velocidadeLimite;
    }

    public static void setVelocidadeLimite(double velocidadeLimite) {
        BCarro.velocidadeLimite = velocidadeLimite;
    }

    public void imprime(){
        System.out.printf("%s com velocidade maxima de %f com velocidade limite de %f\n", this.nome, this.velocidadeMaxima, velocidadeLimite);
    }

}