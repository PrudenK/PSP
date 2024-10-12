package Ejs_10;

import java.io.*;

public class LanzadorFichero {
    public static void main(String[] args) throws IOException {

        String opcion = "";
        BufferedReader opcionIntro = new BufferedReader(new InputStreamReader(System.in));

        while (!opcion.equals("3")){
            menu();

            opcion = opcionIntro.readLine();
            if(opcion.equals("1")){
                agregarDatos();
            } else if (opcion.equals("2")) {
                leerFichero();
            }else if (opcion.equals("3")){
                System.out.println("Programa terminado");
            }else {
                System.out.println("Opción incorrecta, prueba de nuevo");
            }

        }
    }

    public static void menu(){
        System.out.println("\n1 - Introduce datos");
        System.out.println("2 - Leer fichero");
        System.out.println("3 - Salir del programa\n");
    }

    public static void agregarDatos() throws IOException {
        String dir = System.getProperty("user.dir");
        ProcessBuilder pb = new ProcessBuilder( "java", "Ejs_10.LeerFichero");
        File directorio = new File(dir + "/out/production/Ejs_java_PS");
        pb.directory(directorio);



        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el nuevo dato : ");
        String linea = lector.readLine();



        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.write(linea.getBytes());
        os.flush();
        os.close();
    }

    public static void leerFichero() throws IOException {
        String dir = System.getProperty("user.dir");
        File fichero = new File(dir+"/out/production/Ejs_java_PS/fichero.txt");

        BufferedReader lectorFichero = new BufferedReader(new FileReader(fichero));

        String linea;
        while ((linea = lectorFichero.readLine())!= null){
            System.out.println(linea);
        }

        lectorFichero.close();
    }
}
