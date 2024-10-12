package Ejs_4.Carreras;

import java.util.Random;

public class Corredor extends Thread{
    private int distancia;
    private static int posicion = 0;

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 1500; i++) {
            try {
                Thread.sleep(r.nextInt(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distancia++;
        }
        posicion++;
        System.out.println(getName()+" ha terminado la carrera, posición -> "+posicion);
    }
}
