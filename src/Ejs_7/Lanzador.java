package Ejs_7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce el primer número entero : ");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo número entero : ");
        int num2 = sc.nextInt();

        ProcessBuilder pb = new ProcessBuilder( "java", "Ejs_7.Sumador");
        File directorio = new File(dir + "/out/production/Ejs_java_PS");

        String numeros = num1 +"@"+num2;


        pb.directory(directorio);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write(numeros.getBytes());
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
