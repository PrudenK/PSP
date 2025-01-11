package PrimeraEvaluacion.Ejs_4_Hilos.Sincronizar4_2;

public class HiloResta extends Thread{
    private Contador c;
    public HiloResta(Contador c){
        this.c = c;
    }

    public void run() {
        synchronized (c) {
            for (int i = 0; i < 10; i++) {
                c.decrementar();
                System.out.println(getName() + " decrementa 1, valor actual = " + c.getValor());
            }
        }

    }
}
