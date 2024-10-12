package Ejs_10;

import java.io.*;

public class LeerFichero {
    public static void main(String[] args) throws IOException {
        File fichero = new File("fichero.txt");


        BufferedWriter escritorFichero = new BufferedWriter(new FileWriter(fichero, true));
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));


        String linea = lector.readLine();
        escritorFichero.write(linea+"\n");


        escritorFichero.flush();
        escritorFichero.close();
        lector.close();
    }
}
