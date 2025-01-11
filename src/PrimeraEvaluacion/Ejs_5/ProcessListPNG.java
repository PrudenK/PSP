package PrimeraEvaluacion.Ejs_5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ProcessListPNG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta para listar las archivos png : ");
        String ruta = sc.next();
        // C:\Users\PRUDEN\Downloads

        ProcessBuilder pb;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            pb = new ProcessBuilder("cmd.exe", "/c", "dir *.png");
        } else {
            pb = new ProcessBuilder("bash", "-c", "ls *.png");
        }

        pb.directory(new File(ruta));
        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
        }catch (Exception ignored){}
    }
}
