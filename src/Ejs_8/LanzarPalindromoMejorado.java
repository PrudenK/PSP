package Ejs_8;

import java.io.*;

public class LanzarPalindromoMejorado {
    public static void main(String[] args) throws IOException {
        String opcion = "";
        BufferedReader opcionIntro = new BufferedReader(new InputStreamReader(System.in));


        while (!opcion.equals("5")){
            menu();

            opcion = opcionIntro.readLine();
            if(opcion.equals("1")){
                agregarPalabra();
            } else if (opcion.equals("2")) {
                imprimirFichero("palindromas.txt");
            }else if (opcion.equals("3")){
                imprimirFichero("nopalindromas.txt");
            }else if (opcion.equals("4")){
                imprimirFichero("todas.txt");
            }else if (opcion.equals("5")){
                System.out.println("Programa terminado");
            } else {
                System.out.println("Opción incorrecta, prueba de nuevo");
            }
        }
    }


    public static void menu(){
        System.out.println("\n1 - Introduce datos");
        System.out.println("2 - Leer palindromas");
        System.out.println("3 - Leer noPalindromas");
        System.out.println("4 - Leer todas");
        System.out.println("5 - Salir del programa\n");
    }

    public static void agregarPalabra() throws IOException {
        BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
        String dir = System.getProperty("user.dir");
        System.out.println("Introduce una cadena para ver si es palíndroma");
        String opcion = op.readLine();


        ProcessBuilder pb = new ProcessBuilder( "java", "Ejs_8.PalindromoMejorado");
        File directorio = new File(dir + "/out/production/Ejs_java_PS");


        pb.directory(directorio);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write(opcion.getBytes());
        os.flush();
        os.close();

        try{
            int c;
            InputStream is = p.getInputStream();
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirFichero(String ruta) throws IOException {
        String dir = System.getProperty("user.dir");
        File fichero = new File(dir+"/out/production/Ejs_java_PS/"+ruta);

        BufferedReader lectorFichero = new BufferedReader(new FileReader(fichero));

        String linea;
        while ((linea = lectorFichero.readLine())!= null){
            System.out.println(linea);
        }

        lectorFichero.close();
    }

}
