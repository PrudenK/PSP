package PrimeraEvaluacion.Ejs_4_Hilos.ConsumidorProductor;

public class Productor extends Thread{
    private static int item = 0;

    private DatoCompartido d;

    public Productor(DatoCompartido d) {
        this.d = d;
    }


    public void run() {
        while (true){
            synchronized (d){
                if (d.datoDisponible){
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

                d.poner(item);
                System.out.println("Poner("+d.obtener()+")");
                d.notify();

                item++;
                d.datoDisponible = true;
            }
        }


    }
}
