package A_Basic;

public class NContinue {

    public static void main(String... args) {

        /**
         * Parcelamento de um carro
         * Dado um valor do carro, descubra em quantas vezes ele pode ser parcelado
         * O valor da parcela não pode ser menor que R$ 1.000,00
         */

        double valorCarro = 30_000d;
        parcelamento:
        for (int parcela = (int) valorCarro; parcela >= 1; parcela--) {
            double valorParcela = valorCarro / parcela;
            if (valorParcela <= 1000)
                continue parcelamento;
            System.out.printf("\nO Valor da parcela %d é %f = [%f]", parcela, valorParcela, ( parcela * valorParcela) )  ;
        }


    }

}
