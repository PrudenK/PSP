package Ejs_4_Hilos.Carreras;

import java.util.ArrayList;

public class Carrera {
    public static void main(String[] args) throws InterruptedException {
        String[] corredores = { "Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernard Lagat","Rashid Ramzi", "Ryan Gregson", "Fermín Cacho", "Teddy Flack" };



        ArrayList<Corredor> listaCorredores = new ArrayList<>();

        for (String corredor : corredores) {
            Corredor c = new Corredor();
            c.setName(corredor);
            listaCorredores.add(c);
        }

        for (int i = 0; i < listaCorredores.size(); i++) {
            listaCorredores.get(i).start();
        }



    }
}
