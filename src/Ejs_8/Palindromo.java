package Ejs_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comprobarSiEsPalindromo(br.readLine());
    }

    public static void comprobarSiEsPalindromo(String cadena){
        String original = cadena.replace(" ","").toLowerCase();
        String reversed = new StringBuilder(original).reverse().toString();

        if(original.equals(reversed)){
            System.out.println("La cadena es palindroma");
        }else System.out.println("La cadena no es palindroma");
    }

}
