public class Produto {

    //nome produto
    private String nome;

    //preço produto
    private double preco;

    //numero do produto
    private int numeroItem;

    //numero identificador do produto
    private int quatidadeEstoque;

    public Produto() {
    }

    public Produto(String nome, double preco, int numeroItem, int quatidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.numeroItem = numeroItem;
        this.quatidadeEstoque = quatidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public int getQuatidadeEstoque() {
        return quatidadeEstoque;
    }

    public void setQuatidadeEstoque(int quatidadeEstoque) {
        this.quatidadeEstoque = quatidadeEstoque;
    }

    @Override
    public String toString() {
        return String.format("%nNumero do Item %10s: %d%n" +
                "Nome %20s: %s%n" +
                "Quantidade em estoque %3s: %d%n" +
                "Preço %19s: %.2f",  " ", this.numeroItem, " ", this.nome, " ", this.quatidadeEstoque, " ", this.preco);
    }
}
