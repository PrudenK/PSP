package SegundaEvaluacion.Tema4.ProgramacionFuncional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Profesional> listaProfesionales = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        do{
            menu();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1" ->{
                    System.out.println("Introduce el nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce la edad");
                    int edad = sc.nextInt();
                    System.out.println("Introduce el género");
                    char genero = sc.next().charAt(0);
                    System.out.println("Introduce el tipo de profesional");
                    int profesional = sc.nextInt();

                    listaProfesionales.add(new Profesional(nombre, edad, genero, profesional));
                }
                case "2" ->{
                    String opcionSuMenu;
                    do {
                        subMenuConsultas();
                        opcionSuMenu = sc.nextLine();

                        switch (opcionSuMenu){
                            case "1" -> listaProfesionales.stream().sorted(Comparator.comparing(Profesional::getGenero).reversed()).forEach(System.out::println);
                            case "2" -> listaProfesionales.stream().sorted(Comparator.comparing(Profesional::getTipoDeProfesional)).forEach(System.out::println);
                            case "3" ->{
                                System.out.println("Introduce el mínimo");
                                int minimo = sc.nextInt();
                                System.out.println("Introduce el mayor");
                                int maximo = sc.nextInt();

                                if(minimo<= maximo){
                                    listaProfesionales.stream().filter(p -> p.getEdad() >= minimo && p.getEdad() <= maximo).forEach(System.out::println);
                                }else {
                                    System.out.println("La edad mínima no puede ser mayor que la máxima");
                                }
                            }
                        }
                    }while(!opcionSuMenu.equals("4"));

                }
                case "3" ->
                    System.out.println(listaProfesionales.stream().map(Profesional::getNombre).collect(Collectors.joining(", ", "Profesional ", ".")));

                case "4"-> System.out.println("Programa finalizado");

                default -> System.out.println("Opcion no valida");
            }


        }while(!opcion.equals("salit"));
    }

    private static void menu(){
        System.out.println("SOFTWARE DE GESTIÓN DEL IBIS SPORT CLUB");
        System.out.println("======================================");
        System.out.println("1. Introducir datos de un profesional");
        System.out.println("2. Consulta con filtro");
        System.out.println("3. Listado de nombres");
        System.out.println("4. Salir");
    }

    private static void subMenuConsultas(){
        System.out.println("Submenú de Consultas");
        System.out.println("--------------------");
        System.out.println("1. Profesionales por género");
        System.out.println("2. Profesionales por tipo");
        System.out.println("3. Profesionales por edad");
        System.out.println("4. Volver");
    }
}