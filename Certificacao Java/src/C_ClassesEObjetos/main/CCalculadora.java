package C_ClassesEObjetos.main;

import java.util.Arrays;

public class CCalculadora {

    public void somaDoisNumeros(){
        System.out.printf("\nsoma de numeros 1+1 é : %d", 1+1);
    }

    public void somaDoisNumeros(int ... numeros){
        int[] clone = numeros.clone();
        int total = 0;
        for (int i : clone){
            total += i;
        }
        System.out.printf("\nTotal dos numeros %s é : %d", Arrays.toString(clone), total);
    }

    public void subtraiDoisNumeros(){
        System.out.printf("\nsubtração de numeros 10-1 é : %d", (10-1));
    }

    public void multiplicaDoisNumeros(int num1, int num2) {
        System.out.printf("\nMultiplicação de %d e %d é : %d", num1, num2, (num1*num2));
    }
}
