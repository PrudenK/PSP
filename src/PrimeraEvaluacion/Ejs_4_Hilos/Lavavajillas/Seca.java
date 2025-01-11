package PrimeraEvaluacion.Ejs_4_Hilos.Lavavajillas;

public class Seca extends Thread{
    private int num;
    private PilaPLatos pilaPLatos;

    public Seca(int num, PilaPLatos pilaPLatos){
        this.num = num;
        this.pilaPLatos = pilaPLatos;
    }


    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (pilaPLatos){
                if (pilaPLatos.estaVacio()){
                    esperarPlatos();
                }

                for (int j = 0; j < num; j++) {
                    pilaPLatos.secar();
                    esperarLavado();
                }

                pilaPLatos.notify();

            }
        }
    }

    private void esperarPlatos(){
        try {
            pilaPLatos.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperarLavado(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
