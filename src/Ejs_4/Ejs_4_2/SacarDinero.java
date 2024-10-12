package Ejs_4.Ejs_4_2;

public class SacarDinero extends Thread{
    private Cuenta c;
    public SacarDinero(Cuenta c){
        this.c = c;
    }
    public void run(){
        for (int i = 0; i < 1000; i++) {
            c.retirarDinero(1,getName());
        }
    }
}
