package Ejs_2_Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ej_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista_palabras = new ArrayList<>();
        ArrayList<String> lista_predefinida = new ArrayList<>(Arrays.asList("php", "java", "c", "c++", "c#", "javascript", "python", "pascal", "SQL", "Ruby"));
        int lista_size = 10;

        boolean salir = false;
        System.out.println("Puedes escribr una 's' para usar una lista predefinida");
        while (lista_palabras.size() < lista_size && !salir){
            System.out.println("Añade una palabra (llevas "+lista_palabras.size()+"/"+lista_size+")");
            String palabra = sc.next();
            if (palabra.equals("s")) salir = true;
            lista_palabras.add(palabra);
        }

        System.out.println("Lista original : ");
        if(salir){
            ordenarListas(lista_predefinida);
        }else ordenarListas(lista_palabras);



    }
    public static void ordenarListas(ArrayList<String> lista){
        StringBuilder cadena_orginal = new StringBuilder("[");

        lista.forEach(str -> cadena_orginal.append(str).append(","));
        cadena_orginal.deleteCharAt(cadena_orginal.length()-1); // elimno la última coma para luego añadir el último corchete
        System.out.println(cadena_orginal+"]");

        System.out.println("\nLista ordenada alfabéticamente : ");

        StringBuilder cadena_ordenada = new StringBuilder("[");

        lista.stream().sorted().forEach(str -> cadena_ordenada.append(str).append(","));
        cadena_ordenada.deleteCharAt(cadena_ordenada.length()-1);
        System.out.println(cadena_ordenada+"]");
    }
}
