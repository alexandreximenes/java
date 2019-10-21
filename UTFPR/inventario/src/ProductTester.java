/////////////public class ProductTester {

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.setNome("Greatest Hits");
        produto1.setNumeroItem(1);
        produto1.setQuatidadeEstoque(25);
        produto1.setPreco(9.99);

        Produto produto2 = new Produto();
        produto2.setNome("Play 1");
        produto2.setNumeroItem(2);
        produto2.setQuatidadeEstoque(50);
        produto2.setPreco(19.99);

        Produto produto3 = new Produto("Play 2", 29.99, 3, 75);
        Produto produto4 = new Produto("Play 3", 539.99, 4, 100);
        Produto produto5 = new Produto("Play 4", 1299.99, 5, 125);
        Produto produto6 = new Produto("Play 5", 1599.99, 6, 150);

        System.out.println(produto1);
        System.out.println(produto2);
        System.out.println(produto3);
        System.out.println(produto4);
        System.out.println(produto5);
        System.out.println(produto6);
        System.out.println(produto6.getNome().substring(0, 3));
        int x = 22, y = 10;
        double d = Math.sqrt((y + x) / 2);
        System.out.println(d);

        int[][] table = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j <= i) {
                    System.out.print(table[i][j] = 1);
                } else {
                    System.out.print(table[i][j] = 0);
                }
            }
            System.out.println();
        }
        System.out.println(table);

        int[] z = new int[5];

        System.out.println("--------");

        table = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    System.out.print(table[i][j] = 1);
                } else {
                    System.out.print(table[i][j] = 0);
               }
            }
            System.out.println();
        }

        System.out.println("--------");

        int[] arr = {5, 4, 2, 1, 0};
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i - 1] += arr[i]);
        }


        System.out.println("--------");

        int[][] array = {{3, 2, 1}, {1, 2, 3}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(2*array[i][j]);
            }
        }
    System.out.println("7/8*5: "+ 7/8*5);

        ----------++++


                -------

        int num = 7;
        while(num >= 0)
        {
            num -= 3;
        }
        System.out.println(num);
    }

}
-*