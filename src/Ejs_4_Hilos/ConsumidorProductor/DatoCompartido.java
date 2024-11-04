package Ejs_4_Hilos.ConsumidorProductor;

public class DatoCompartido {
    int dato;

    boolean datoDisponible = false;

    public int obtener() {
        return dato;
    }

    public void poner(int dato) {
        this.dato = dato;
    }
}

