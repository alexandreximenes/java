package A_Basic;

public class MBreak {

    public static void main(String... args) {

        /**
         * Parcelamento de um carro
         * Dado um valor do carro, descubra em quantas vezes ele pode ser parcelado
         * O valor da parcela não pode ser menor que R$ 1.000,00
         */

        double valorCarro = 30000;
        for (int parcela = 1; parcela <= valorCarro; parcela++) {
            double valorParcela = valorCarro / parcela;
            if (valorParcela <= 1000) break;
            System.out.printf("\nO Valor da parcela %d é %f", parcela, valorParcela);
        }
    }

}
