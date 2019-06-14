package A_Basic;

public class DTiposPrimitivos {

    public static void main(String[] args) {

        int numeroInteiro = 10;
        float $numeroDecimal = 15000f; //whats, Is this PHP?
        long numeroLongo = 1_000_000_000L; // > Java 7
        double numeroDecimal = 1_000_000_000_000_000_000_000_000_000_000_000_000_000d;

        //converte para o numero inteiro  // 2147483647
        numeroInteiro = (int) numeroDecimal;

        //Erro
        //numeroInteiro =  numeroDecimal;

        System.out.println(numeroInteiro);

    }


}
