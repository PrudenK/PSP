package Ejs_4_Hilos.Lavavajillas;

public class Principal {
    public static void main(String[] args) {
        PilaPLatos pilaPLatos = new PilaPLatos();

        Friega fregar = new Friega(1,pilaPLatos);
        Seca secar = new Seca(1,pilaPLatos);

        secar.start();
        fregar.start();

    }
}
