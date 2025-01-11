package PrimeraEvaluacion.Ejs_1_Arrays_Bidimensionales;

public class Ej_2 {

    public static void main(String[] args) {
        int[][] num = {
                {0,30,2,0,0,5},
                {75,0,0,0,0,0},
                {0,0,-2,9,0,11},
        };
        System.out.printf("%14s","");
        for (int i = 0; i < num[0].length; i++) {
            System.out.printf("Column %-5d",i);
        }
        System.out.println();
        for (int i = 0; i < num.length; i++) {
            System.out.print("Fila "+i);
            for (int j = 0; j < num[0].length; j++) {
                System.out.printf("%12d",num[i][j]);
            }
            System.out.println();
        }
    }
}
