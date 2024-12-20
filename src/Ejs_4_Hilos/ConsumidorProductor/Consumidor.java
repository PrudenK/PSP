package Ejs_4_Hilos.ConsumidorProductor;
public class Consumidor extends Thread{

    private DatoCompartido d;

    public Consumidor(DatoCompartido d) {
        this.d = d;
    }

    public void run() {
        while (true){
            synchronized (d){
                if(!d.datoDisponible){
                    try {
                        d.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Obtener("+d.obtener()+")");
                d.notify();
                d.datoDisponible = false;
            }
        }
    }
}
