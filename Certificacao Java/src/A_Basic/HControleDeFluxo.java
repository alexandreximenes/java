package A_Basic;

public class HControleDeFluxo {


    private static final int IDADE = 17;

    public static void main(String[] args) {

       int idade = 18;
       float salario = 4000.00f;
       boolean decisaoIgualA = false;

        /**
         * case 1
         */
        if(idade > IDADE)
            System.out.println("cadastro desatualizado, atualizar sistema, idade maior");
        else if (idade == IDADE)
            System.out.println("idade da identidade bate com idade do sistema");
        else
            System.out.println("cadastro desatualizado, atualizar sistema, idade menor");

        /**
         * case 2
         * decisaoIgualA (pegadinha) não esta fazendo comparação, esta sendo atrubuido true a decisaoIgualA;
         * 4==4 true
         * salario>4000f false
         */
       if(decisaoIgualA = true && 4==4 && salario>=4000f)
           System.out.println("CASE 1, decisão foi positiva");
       else
           System.out.println("CASE 1, devisão negativa");

        System.out.println("CASE 1, sempre vai executar");

        /**
         * case 3
         */
        if(decisaoIgualA = true && 4==4 && salario>4000f)
            System.out.println("CASE 2, decisão foi positiva");
        else
            System.out.println("CASE 2, devisão negativa");

        System.out.println("CASE 2, sempre vai executar");

    }
}
