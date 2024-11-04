package Ejs_4_Hilos.Carreras;

import java.util.Random;

public class Corredor extends Thread{
    private int distancia;
    private static int posicion = 0;

    public void run() {
        Random r = new Random();
        long starTime = System.currentTimeMillis();
        for (int i = 0; i < 1500; i++) {
            try {
                Thread.sleep(r.nextInt(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distancia++;
        }
        posicion++;
        System.out.println(getName()+" ha terminado la carrera, posición -> "+posicion+ " ha tardado "+(System.currentTimeMillis()-starTime)+" milisegundos");
    }
}
