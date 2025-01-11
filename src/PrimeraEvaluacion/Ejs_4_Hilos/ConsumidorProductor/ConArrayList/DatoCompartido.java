package PrimeraEvaluacion.Ejs_4_Hilos.ConsumidorProductor.ConArrayList;

import java.util.ArrayList;
import java.util.Random;

public class DatoCompartido {
    private Random random = new Random();
    private ArrayList<Integer> listaNumeros = new ArrayList<>();
    private int tama;

    public DatoCompartido(int tama){
        this.tama = tama;
    }


    public boolean listaLlena(){
        return listaNumeros.size() == tama;
    }

    public boolean listaVacia(){
        return listaNumeros.isEmpty();
    }

    public ArrayList<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public int getTama() {
        return tama;
    }

    public void producirNumero(){
        int num = random.nextInt(10)+1;
        System.out.println("Número producido -> "+ num);
        listaNumeros.add(num);
    }

    public void consumirNumero(){
        System.out.println("Número consumido -> "+listaNumeros.removeLast());
    }
}
