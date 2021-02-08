package A_Basic;

public class IOperadorTernario {

    private static final int IDADE_NO_SISTEMA = 19;

    public static void main(String[] args) {

        int idade = 18;

        String frasePositiva = "cadastro desatualizado, atualizar sistema, idade maior";
        String fraseDeIgualdade = "idade da identidade bate com idade do sistema";
        String fraseNegativa = "cadastro desatualizado, atualizar sistema, idade menor";
        String frase;

        if (idade > IDADE_NO_SISTEMA)
            frase = frasePositiva;
        else if (idade == IDADE_NO_SISTEMA)
            frase = fraseDeIgualdade;
        else
            frase = fraseNegativa;

        System.out.println(frase);

        /**
         * A mesma coisa com Operador Ternario
         *
         */

        frase = idade > IDADE_NO_SISTEMA ? frasePositiva : fraseNegativa;
        System.out.println(frase);

        boolean ok;
        String status = (ok = false)  ? "adulto" : "juvenil" ;
        System.out.println(status);

        String status = idade >= 18  ? "adulto" : "juvenil" ;
        System.out.println(status);
    }
}
