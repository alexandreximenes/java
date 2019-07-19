package G_MetodosEstaticos;

public class DImprimeParcelamento {

    public static void main(String[] args) {

        //EXECUTA DEPOIS
        //Imprime e executa o bloco de inicialização padrão
        CParcelamentoCarro parcelamentoCarro = new CParcelamentoCarro();
        CParcelamentoCarro parcelamentoCarro2 = new CParcelamentoCarro();
        parcelamentoCarro.imprime();

        //EXECUTA PRIMEIRO
        //Imprime e executa o bloco de inicialização statico
        CParcelamentoCarro.imprime();
    }
}
