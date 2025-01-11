package PrimeraEvaluacion.Ejs_4_Hilos.Sincronizar4_2;

public class MainContador {
    public static void main(String[] args) {
        Contador c = new Contador(100);
        HiloSuma suma = new HiloSuma(c);
        HiloResta resta = new HiloResta(c);

        suma.setName("Hilo Suma");
        resta.setName("Hilo Resta");

        suma.start();
        resta.start();


    }
}
