package PrimeraEvaluacion.Ejs_4_Hilos.ConsumidorProductor.ConArrayList;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el tamaño de la lista : ");
        int tama = sc.nextInt();

        DatoCompartido dc = new DatoCompartido(tama);

        Productor productor = new Productor(dc);
        Productor productor1 = new Productor(dc);
        Productor productor2 = new Productor(dc);

        Consumidor consumidor = new Consumidor(dc);

        productor.start();
        productor1.start();
        productor2.start();

        consumidor.start();

    }
}
