package PrimeraEvaluacion.Ejs_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasarMayus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String linea;
        while ((linea = br.readLine()) != null){
            System.out.println(linea.toUpperCase());
        }

        br.close();
    }
}
