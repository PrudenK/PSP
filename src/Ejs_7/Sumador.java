package Ejs_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumador {
    public static int sumaIntervalosDeDosNumero(int  num1, int num2){
        int sumatorio = 0;
        while (num1 <= num2){
            sumatorio += num1;
            num1++;
        }
        return sumatorio;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numeros = br.readLine().split("@");


        int num1 = Integer.parseInt(numeros[0]);
        int num2 = Integer.parseInt(numeros[1]);
        int resultado = sumaIntervalosDeDosNumero(num1,num2);


        System.out.println("Resultado -> "+resultado);

    }

}
