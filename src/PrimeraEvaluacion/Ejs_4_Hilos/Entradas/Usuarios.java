package PrimeraEvaluacion.Ejs_4_Hilos.Entradas;

import java.util.Random;

public class Usuarios extends Thread{
    private static int entradasDisponibles = 100;
    private Random r = new Random();
    private static int idHilo = 1;


    public Usuarios(){
        setName(String.valueOf(idHilo));
        idHilo++;
    }

    public void run() {
        reservaEntrada();
    }
    private void reservaEntrada(){
        int reservadas = r.nextInt(10) + 1;
        entradasDisponibles -= reservadas;
        System.out.println(reservadas + " reservadas para Cliente " + getName());
    }

    public static void totalEntradasVendidas(){
        System.out.println("Total de entradas vendidas: "+Math.abs(entradasDisponibles-100));
    }
}
