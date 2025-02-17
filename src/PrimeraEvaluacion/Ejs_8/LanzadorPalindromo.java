package PrimeraEvaluacion.Ejs_8;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LanzadorPalindromo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce una cadena para ver si es palíndroma : ");
        String cadena = sc.nextLine();


        ProcessBuilder pb = new ProcessBuilder( "java", "PrimeraEvaluacion.Ejs_8.Palindromo");
        File directorio = new File(dir + "/out/production/Ejs_java_PS");


        pb.directory(directorio);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
        os.flush();
        os.close();

        try{
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
