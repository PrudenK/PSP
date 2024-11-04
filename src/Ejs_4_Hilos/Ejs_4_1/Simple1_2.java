package Ejs_4_Hilos.Ejs_4_1;

import static Ejs_4_Hilos.Ejs_4_1.Hilo1_2.getNumeroComun;

public class Simple1_2 {
    public static void main(String[] args) {
        Hilo1_2 hilo1 = new Hilo1_2("Hilo 1");
        Hilo1_2 hilo2 = new Hilo1_2("Hilo 2");
        Hilo1_2 hilo3 = new Hilo1_2("Hilo 3");
        Hilo1_2 hilo4 = new Hilo1_2("Hilo 4");
        Hilo1_2 hilo5 = new Hilo1_2("Hilo 5");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();


        System.out.println(getNumeroComun());

        /*
        Cada vez que ejecutamos el programa sale un número distinto,
        ya que todos los hilos están accediendo y modificando a la vez la misma la variable
         */
    }
}
