package Ejs_4_Hilos.Ejs_4_2;

public class Principal {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(100);
        IngresarDinero juan = new IngresarDinero(c);
        juan.setName("Juan");
        SacarDinero ana = new SacarDinero(c);
        ana.setName("Ana");


        juan.start();
        ana.start();
    }
}
