package Ejs_4_Hilos.Lavavajillas;

public class Plato {
    private static int platos = 0;
    private int numPlato;

    public Plato() {
        platos++;
        numPlato = platos;
    }

    public int getNumPlato() {
        return numPlato;
    }
}
