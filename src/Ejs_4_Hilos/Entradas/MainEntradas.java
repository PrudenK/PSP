package Ejs_4_Hilos.Entradas;

import java.util.ArrayList;

import static Ejs_4_Hilos.Entradas.Usuarios.totalEntradasVendidas;

public class MainEntradas {
    public static void main(String[] args){
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaUsuarios.add(new Usuarios());
        }

        listaUsuarios.forEach(u -> {u.start();
            try {
                u.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        });

        totalEntradasVendidas();
    }
}
