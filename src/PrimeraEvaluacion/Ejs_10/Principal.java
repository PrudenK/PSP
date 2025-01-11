package PrimeraEvaluacion.Ejs_10;

import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        ProcessBuilder pb = new ProcessBuilder( "java", "PrimeraEvaluacion.Ejs_10.ValidarMail");
        File directorio = new File(dir + "/out/production/Ejs_java_PS");
        pb.directory(directorio);



        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce un email : ");
        String email = lector.readLine();


        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.write(email.getBytes());


        os.flush();
        os.close();


        try{
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }

            InputStream error = p.getErrorStream();
            while ((c = error.read()) != -1)
                System.out.print((char) c);


            error.close();
            is.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
