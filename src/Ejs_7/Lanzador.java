package Ejs_7;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce el primer número entero : ");
        int num1 = sc.nextInt();
        System.out.println("Introduce el segundo número entero : ");
        int num2 = sc.nextInt();

        ProcessBuilder pb = new ProcessBuilder( "java", "Ejs_7.Sumador",String.valueOf(num1),String.valueOf(num2));
        File directorio = new File(dir + "/out/production/Ejs_java_PS");

        pb.directory(directorio);
        try{
            Process p = pb.start();
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
