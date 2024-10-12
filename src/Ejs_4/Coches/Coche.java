package Ejs_4.Coches;

import java.util.Random;

public class Coche extends Thread{
    private String marca;
    private static int numCoche = 1;
    private final Random r = new Random();
    private int distancia = 0;

    private static int pos = 0;
    public Coche(String marca){
        this.marca = marca;
        setName(marca+"("+numCoche+")");
        numCoche++;
    }
    public void run() {
        do{
            distancia += r.nextInt(101);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (distancia < 500) {
                System.out.println(getName() + " lleva recorrido " + distancia + " km!");
            }
        }while (distancia < 500);
        pos++;
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(getName()+ " ha finalizado al recorrer "+distancia+" km!, posición -> "+pos);
    }
}
