package PrimeraEvaluacion.Ejs_9;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class LeerWeb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce las webs que quieres visitar separadas por @ (máximo 3) : ");
        String webs = sc.next();

        ProcessBuilder pb = new ProcessBuilder( "java", "PrimeraEvaluacion.Ejs_9.VisitaWeb", webs);
        File directorio = new File(dir + "/out/production/Ejs_java_PS");

        pb.directory(directorio);

        try{
            Process p = pb.start();
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // www.uv.es@www.uji.es@www.ua.es
    }
}
