package PrimeraEvaluacion.Ejs_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidarMail {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));


        String email = lector.readLine();

        if (!email.contains("@")){
            throw new RuntimeException("ERROR: El email no contiene una @!");
        }

        if (email.endsWith("@")){
            throw new RuntimeException("ERROR: No existe segundo identificador!");
        }

        if (!email.matches(".{3,}@.*")){
            throw new RuntimeException("ERROR: El primer identificador ha de tener una longitud mínima de 3 caracteres!");
        }

        if (!(email.endsWith(".com") || email.endsWith(".es") || email.endsWith(".org"))){
            throw new RuntimeException("ERROR: El dominio no es ni com/es/org!");
        }

        System.out.println("¡Enhorabuena el email es correcto!");
    }

}
