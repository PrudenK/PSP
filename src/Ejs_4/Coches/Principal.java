package Ejs_4.Coches;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String marca = "";
        ArrayList<Coche> listaCoches = new ArrayList<>();


        while (!marca.equals("salir")){
            System.out.println("\n'salir' para salir");
            System.out.println("Introduce la marca del coche "+(listaCoches.size()+1) +":");
            marca = sc.next();
            if (!marca.equals("salir")){
                Coche c = new Coche(marca);
                listaCoches.add(c);
            }
        }

        System.out.println("¡Qué empiece la carrera");

        for (Coche c : listaCoches){
            c.start();
        }
    }
}
