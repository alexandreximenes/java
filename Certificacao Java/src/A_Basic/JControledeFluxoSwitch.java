package A_Basic;

public class JControledeFluxoSwitch {


    public static void main(String[] args) {

        int diaDaSemana = 1;

        switch (diaDaSemana) {
            case 1:
                System.out.println("domingo");
                break;
            case 2:
                System.out.println("segunda");
                break;
            case 3:
                System.out.println("terça");
                break;
            case 4:
                System.out.println("quarta");
                break;
            case 5:
                System.out.println("quinta");
                break;
            case 6:
                System.out.println("sexta");
            case 7:
                System.out.println("sabado");
                break;
            default:
                System.out.println("dia invalido");
        }

        /**
         * Exercicio
         * dia util ou final de semana
         */
        switch (diaDaSemana) {
            case 1:
            case 7:
                System.out.println("final de semana");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("dia util");
                break;
            default:
                System.out.println("dia invalido");
        }
    }
}
