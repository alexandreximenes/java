package G_MetodosEstaticos;

public class CParcelamentoCarro {

    private static int[] parcelas;

    {
        System.out.println("dentro do bloco de inicilização padrão");
        //Erro NullpointerException porque a a variavel parcelas é statica e o bloco não.
//        parcelas = new int[100];
//        for(int i=1;i<=100;i++){
//            parcelas[i-1] = i;
//        }
    }

    static {
        System.out.println("dentro do bloco de inicilização static");
        parcelas = new int[100];
        for(int i=1;i<=100;i++){
            parcelas[i-1] = i;
        }
    }

    public static void imprime(){
        for(int i=0;i<parcelas.length;i++){
            System.out.print(parcelas[i]+", ");
        }
        System.out.println();
    }
}
