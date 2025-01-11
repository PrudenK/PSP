package PrimeraEvaluacion.Ejs_4_Hilos.ConsumidorProductor.ConArrayList;

public class Consumidor extends Thread{
    private DatoCompartido lista;

    public Consumidor(DatoCompartido dc){
        lista = dc;
    }


    public void run() {
        while (true){
            synchronized (lista){
                if(lista.listaVacia()){
                    try {
                        lista.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                lista.consumirNumero();
                lista.notify();
            }
        }
    }

}
