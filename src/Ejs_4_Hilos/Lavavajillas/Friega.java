package Ejs_4_Hilos.Lavavajillas;

public class Friega extends Thread{
    private int num;
    private PilaPLatos pilaPLatos;


    public Friega(int num, PilaPLatos pilaPLatos){
        this.num = num;
        this.pilaPLatos = pilaPLatos;
    }


    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (pilaPLatos){
                if (pilaPLatos.estaLleno()){
                    esperarPlatos();
                }

                for (int j = 0; j < num; j++) {
                    pilaPLatos.lavar(new Plato());
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
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
