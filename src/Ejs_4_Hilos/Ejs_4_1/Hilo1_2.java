package Ejs_4_Hilos.Ejs_4_1;

public class Hilo1_2 extends Thread{
    private static int numeroComun;

    public Hilo1_2(String nom){
        super(nom);
    }
    public void run(){
       contadorComun();
    }

    public void contadorComun(){
        for (int i = 0; i < 1000; i++) {
            numeroComun++;
        }
    }

    public static int getNumeroComun(){
        return numeroComun;
    }
}
