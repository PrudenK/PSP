package Ejs_4_Hilos.Sincronizar4_2;

public class HiloSuma extends Thread{
    private Contador c;
    public HiloSuma(Contador c){
        this.c = c;
    }

    public void run() {
        synchronized (c) {
            for (int i = 0; i < 10; i++) {
                c.incrementar();
                System.out.println(getName() + " incrementa 1, valor actual = " + c.getValor());
            }

        }
    }
}
