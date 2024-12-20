package Ejs_4_Hilos.Ejs_4_1;

public class HiloEjemplo1_1 {
    public static void main(String[] args) throws InterruptedException {
        Hilo1_1 hilo1 = new Hilo1_1("Hilo 1");
        Hilo1_1 hilo2 = new Hilo1_1("Hilo 2");
        Hilo1_1 hilo3 = new Hilo1_1("Hilo 3");


        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("Hilos finalizados");
    }
}
