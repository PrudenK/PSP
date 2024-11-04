package Ejs_4_Hilos.ConsumidorProductor;


public class Principal {
    public static void main(String[] args) {
        DatoCompartido dc = new DatoCompartido();

        Productor p1 = new Productor(dc);
        Consumidor c1 = new Consumidor(dc);

        p1.start();
        c1.start();
    }
}
