package PrimeraEvaluacion.Ejs_4_Hilos.Lavavajillas;

import java.util.Stack;

public class PilaPLatos {
    private Stack<Plato> listaPlatos = new Stack<>();
    private int maximo = 5;


    public void lavar(Plato plato){
        if(hayEspacioDisponible()){
            listaPlatos.push(plato);
            System.out.println("-----Plato lavado #"+plato.getNumPlato()+", total en pila: "+listaPlatos.size());
        }

    }

    public void secar(){
        if(!listaPlatos.isEmpty()){
            System.out.println("Plato secado #"+listaPlatos.pop().getNumPlato()+", total en pila: "+listaPlatos.size());
        }
    }


    public boolean estaVacio(){
        return listaPlatos.isEmpty();
    }

    public boolean estaLleno(){
        return listaPlatos.size() >= maximo;
    }

    private boolean hayEspacioDisponible(){
        return listaPlatos.size() < maximo;
    }
}
