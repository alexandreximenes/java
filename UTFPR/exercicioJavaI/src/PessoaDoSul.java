abstract class  Pessoa{
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }

    public String viajar(){
        return this.nome + " gosta de viajar ";
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

   // abstract void imprimir();
}

class PessoaDoSul extends Pessoa{
    public String viajar(){
        return this.getNome() + " gosta de viajar para o NORTE do Brasil, desfrutar de um clima diferente do seu";
    }
};


class PessoaDoNorte extends Pessoa{
    public String viajar(){
        return this.getNome() + " gosta de viajar para o SUL do Brasil, desfrutar de um clima diferente do seu";
    }
};

interface Agencia {
    void executaViagem(Pessoa p);
}


class AgenciadorDeViagem implements Agencia{
    @Override
    public void executaViagem(Pessoa p) {
        System.out.println(p.viajar());
    }
}


class Principal{
    public static void main(String[] args) {

        PessoaDoSul alexandre = new PessoaDoSul();
        alexandre.setNome("alexandre");

        PessoaDoNorte outraPessoa = new PessoaDoNorte();
        outraPessoa.setNome("outraPessoa");

        AgenciadorDeViagem agenciadorDeViagem = new AgenciadorDeViagem();
        agenciadorDeViagem.executaViagem(alexandre);
        agenciadorDeViagem.executaViagem(outraPessoa);


    }
}
