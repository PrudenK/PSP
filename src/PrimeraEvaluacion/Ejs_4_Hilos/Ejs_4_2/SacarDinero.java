package PrimeraEvaluacion.Ejs_4_Hilos.Ejs_4_2;

public class SacarDinero extends Thread{
    private Cuenta c;
    public SacarDinero(Cuenta c){
        this.c = c;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            synchronized (c) {
                c.retirarDinero(2, getName());
            }
        }
    }
}
