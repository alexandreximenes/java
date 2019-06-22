package B_Arrays;

public class DArraysMultidimencionais2 {
    public static void main(String[] args) {

        /**
         * Inicializando arrays
         * 12 meses
         * cada mes tem a sua propria quantidade de dias;
         */
        int[][] diasDoAno = new int[12][];

        //Janeiro
        diasDoAno[0] = new int[31];
        //fevereiro
        diasDoAno[1] = new int[28];
        //março
        diasDoAno[0] = new int[31];
        //... etc
        //dezembro
        diasDoAno[11] = new int[31];

        /**
         * Formas de inicializar arrays;
         */

        int[][] dias = new int [4][];
        //ou
        int[][] dias2 = {
                {1}, {1}, //1 posição do array
                {1,2}, {1,2}, //2 posição do array
                {1,2,3}, {1,2,3}, //3 posição do array
                {1,2,3,4}, {1,2,3,4}, //4 posição do array
        };
        //ou
        int[][] dias3 = new int [4][];
        dias3[0] = new int[]{1, 2, 3, 4, 5};
        dias3[1] = new int[10];
        dias3[2] = new int[]{1,2};
        dias3[3] = new int[31];



    }
}
