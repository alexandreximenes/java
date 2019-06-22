package B_Arrays;

public class CArraysMultidimencionais {
    public static void main(String[] args) {

       int [][] dias = new int[2][2];

       dias [0][0] = 1;
       dias [0][1] = 2;
       dias [1][0] = 3;
       dias [1][1] = 4;

       for(int i = 0; i<dias.length; i++){
           for(int j = 0; j<dias[i].length; j++){
               System.out.println(dias[i][j]);
           }
       }

        System.out.println("----------------------------------");
       for(int[] ref : dias){
           for(int dia : ref){
               System.out.println(dia);
           }
       }

    }
}
