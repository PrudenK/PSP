package Ejs_4_Hilos.Lambdas;

public class MainLambdas {
    public static void main(String[] args) throws InterruptedException {
        Thread hiloPares = new Thread(()->{
            System.out.print("Pares -> ");
            for (int i = 0; i < 100; i+=2) {
                System.out.print(i+" ");
            }
            System.out.println();
        });
        hiloPares.start();
        hiloPares.join();


        Thread hilosImpares = new Thread(()->{
            System.out.print("Impares -> ");
            for (int i = 1; i < 100; i+=2) {
                System.out.print(i+" ");
            }
            System.out.println();
        });
        hilosImpares.start();


        hilosImpares.join();

    }
}
