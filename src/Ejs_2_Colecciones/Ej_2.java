package Ejs_2_Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ej_2 {
    private final static ArrayList<Integer> lista_nums = new ArrayList<>();

    public static void main(String[] args) {
        Random generador = new Random();

        int tamano_lista = generador.nextInt(11)+10; // entre 10 y 20 ambos inclusive

        System.out.println("\nTamaño de la lista -> "+ tamano_lista);

        while (tamano_lista > 0){
            lista_nums.add(generador.nextInt(101)); // entre 0 y 100 ambos inclusive
            tamano_lista--;
        }


        System.out.println("\nLista de los números generados :");
        lista_nums.forEach(num -> System.out.printf("%-5d", num));

        // código para la suma
        int suma_de_todos_los_num = lista_nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nSuma de todos los números de la lista -> "+suma_de_todos_los_num);

        media();
        max();
        min();

    }
    public static void media(){
        if(lista_nums.stream().mapToInt(Integer::intValue).average().isPresent()){
            double media = lista_nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
            System.out.println("\nLa media de todos los números de la lista -> "+String.format("%.2f", media));
        }else {
            System.out.println("No hay números en la lsita");
        }
    }
    public static void max(){
        if(lista_nums.stream().mapToInt(Integer::intValue).max().isPresent()){
            int max =  lista_nums.stream().mapToInt(Integer::intValue).max().getAsInt();
            System.out.println("\nEl número más alto de la lista es -> "+max);
        }else {
            System.out.println("No hay números en la lsita");
        }
    }
    public static void min(){
        if(lista_nums.stream().mapToInt(Integer::intValue).min().isPresent()){
            int min =  lista_nums.stream().mapToInt(Integer::intValue).min().getAsInt();
            System.out.println("\nEl número más bajo de la lista es -> "+min);
        }else {
            System.out.println("No hay números en la lsita");
        }
    }
}
