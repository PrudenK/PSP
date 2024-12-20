package Ejs_4_Hilos.ConsumidorProductor.ConArrayList;

public class Productor extends  Thread{
    private DatoCompartido lista;

    public Productor(DatoCompartido dc){
        lista = dc;
    }


    public void run() {
        while (true){
            synchronized (lista){
                if(lista.listaLlena()){
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

                lista.producirNumero();
                lista.notify();
            }
        }
    }
}
