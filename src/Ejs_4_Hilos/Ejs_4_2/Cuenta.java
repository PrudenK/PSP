package Ejs_4_Hilos.Ejs_4_2;

import java.util.concurrent.locks.Lock;

public class Cuenta {
    private int saldo;

    public Cuenta(int saldo){
        this.saldo = saldo;
    }

    public void restar(int cantidad){
        saldo -= cantidad;
    }


    public void retirarDinero(int cantidad, String nombre){
        if (saldo >= cantidad){
            System.out.println(nombre+ ": SE VA A RETIRAR SALDO (ACTUAL ES: "+saldo+")");

            restar(cantidad);

            System.out.println("Saldo después de haber sacado el dinero : "+saldo);
        }else {
            System.out.println("No puede retirar dinero, NO HAY SALDO ( "+saldo+")");
        }
    }

    public void ingresarDinero(int cantidad, String nombre){
        System.out.println(nombre+ ": SE VA A SUMAR AL SALDO (ACTUAL ES: "+saldo+")");

        saldo += cantidad;

        System.out.println("Saldo después de haber sumado el dinero : "+saldo);

    }


    public int getSaldo(){
        return saldo;
    }
}
