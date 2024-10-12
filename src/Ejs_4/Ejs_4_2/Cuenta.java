package Ejs_4.Ejs_4_2;

public class Cuenta {
    private int saldo;

    public Cuenta(int saldo){
        this.saldo = saldo;
    }

    public void restar(int cantidad){
        saldo -= cantidad;
    }

    public synchronized void retirarDinero(int cantidad, String nombre){
        if (saldo >= cantidad){
            System.out.println(nombre+ ": SE VA A RETIRAR SALDO (ACTUAL ES: "+saldo+")");
            restar(cantidad);
            System.out.println("Saldo después de haber sacado el dinero : "+saldo);
        }else {
            System.out.println("No puede retirar dinero, NO HAY SALDO ( "+saldo+")");
        }
    }


    public int getSaldo(){
        return saldo;
    }
}
