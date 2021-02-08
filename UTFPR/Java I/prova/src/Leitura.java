import java.util.Scanner;

/**
 * Alexandre Tiago Ximenes
 */

public class Leitura {

    public String entraDados() {
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        try {
            escolha = scanner.next();
        } catch (Exception e) {
            System.out.println("Erro ao ler dado do teclado");
        }
        return escolha;
    }
}
