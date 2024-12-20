package Ejs_4_Hilos.EjsMenu;

import java.io.*;

public class MenuHilo extends Thread{
    private int numLectura;

    public MenuHilo(int numLectura) {
        this.numLectura = numLectura;
        setName("hilo "+numLectura);
    }

    public void run() {
        lectura();
    }

    private void lectura(){

        try {
            File fichero = new File("menu.txt");
            BufferedReader br = new BufferedReader(new FileReader(fichero));

            PrintWriter pr1 = new PrintWriter("primeros.txt");
            PrintWriter pr2 = new PrintWriter("segundos.txt");
            PrintWriter pr3 = new PrintWriter("postres.txt");

            String linea;
            while ((linea = br.readLine())!= null){
                if (linea.startsWith("1") && !linea.equals("1-PRIMEROS") && getName().equals("hilo 1")){
                    escribir(pr1, linea);
                } else if (linea.startsWith("2") && !linea.equals("2-SEGUNDOS") && getName().equals("hilo 2")) {
                    escribir(pr2, linea);
                }else if (linea.startsWith("3") && !linea.equals("3-POSTRES") && getName().equals("hilo 3")) {
                    escribir(pr3, linea);
                }
            }

            pr1.close();
            pr2.close();
            pr3.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void escribir(PrintWriter pr, String linea){
        pr.write(linea.substring(2)+"\n");
        System.out.println("El "+getName()+" escribe..."+linea);
    }
}
