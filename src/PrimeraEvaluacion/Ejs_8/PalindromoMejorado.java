package PrimeraEvaluacion.Ejs_8;

import java.io.*;

public class PalindromoMejorado {
    public static void main(String[] args) throws IOException {
        File palindromas = new File("palindromas.txt");
        BufferedWriter escritorPalindroma = new BufferedWriter(new FileWriter(palindromas, true));

        File noPalindromas = new File("nopalindromas.txt");
        BufferedWriter escritorNoPalindroma = new BufferedWriter(new FileWriter(noPalindromas, true));

        File todas = new File("todas.txt");
        BufferedWriter escritorTodas = new BufferedWriter(new FileWriter(todas, true));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String palabra = br.readLine();

        escritorTodas.write(palabra+"\n");
        if (comprobarSiEsPalindromo(palabra)){
            escritorPalindroma.write(palabra+"\n");
        }else escritorNoPalindroma.write(palabra+"\n");

        escritorTodas.close();
        escritorPalindroma.close();
        escritorNoPalindroma.close();

    }

    public static boolean comprobarSiEsPalindromo(String cadena){
        StringBuilder cadenaSB = new StringBuilder(cadena);

        return cadenaSB.toString().contentEquals(cadenaSB.reverse());
    }

}
