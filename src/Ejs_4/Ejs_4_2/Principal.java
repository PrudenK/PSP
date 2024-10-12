package Ejs_4.Ejs_4_2;

public class Principal {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(10000);
        SacarDinero juan = new SacarDinero(c);
        juan.setName("Juan");
        SacarDinero ana = new SacarDinero(c);
        ana.setName("Ana");


        juan.start();
        ana.start();

    }
}
