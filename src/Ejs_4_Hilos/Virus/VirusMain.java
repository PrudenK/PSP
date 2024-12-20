package Ejs_4_Hilos.Virus;

import java.util.Random;
import java.util.Scanner;

public class VirusMain {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de virus a cargar ...");
        int numVirus = sc.nextInt();

        for (int i = 0; i < numVirus; i++) {
            int tempI = i+1;
            Thread hilo = new Thread(()->{
                int contadorNumVirus = 0;

                Thread.currentThread().setName("Virus "+ tempI+":");

                System.out.print(Thread.currentThread().getName());
                while (contadorNumVirus < 100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if(r.nextBoolean()){
                        contadorNumVirus += 5;
                        System.out.print("X");
                    }else {
                        contadorNumVirus += 10;
                        if(contadorNumVirus == 105){
                            System.out.print("X");
                        }else System.out.print("XX");
                    }
                }
                System.out.print(" 100%");
                System.out.println();
            });
            hilo.start();
            hilo.join();
        }
        if(numVirus> 0) {
            System.out.println("¡Has sido infectado!");
        }else System.out.println("Si no introduces virus no podremos infectar nada");
    }
}
