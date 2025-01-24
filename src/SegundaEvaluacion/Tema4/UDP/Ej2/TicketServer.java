package SegundaEvaluacion.Tema4.UDP.Ej2;

import FunAux.Pausa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static FunAux.Pausa.pausa;

public class TicketServer {
    public static void main(String[] args) throws IOException {
        ArrayList<String> cola = new ArrayList<>();
        ArrayList<String> butacas = new ArrayList<>(Arrays.asList("LIBRE", "LIBRE", "LIBRE", "LIBRE"));

        System.out.println("Servidro arrancando...");

        DatagramSocket socketUDP = new DatagramSocket(12345);



        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(recibo);
            String reciboDelCliente = new String(recibo.getData(), 0, recibo.getLength());

            String[] reciboCliente = reciboDelCliente.split("@");

            String opcion = reciboCliente[0];

            switch (opcion) {
               case "1" ->{
                   String listarButacas = "";
                   listarButacas += IntStream.range(0, butacas.size()).mapToObj(i -> (i+1)+":"+butacas.get(i)).collect(Collectors.joining("\n"));

                   if(!cola.isEmpty()){
                       listarButacas += "\nCola de espera\n";
                       listarButacas += IntStream.range(0, cola.size()).mapToObj(i -> (i+1)+":"+cola.get(i)).collect(Collectors.joining("\n"));
                   }
                   System.out.println(listarButacas);
               }
               case "2" ->{
                   if(reciboCliente.length == 2){
                       String nombre = reciboCliente[1];
                       if(!butacas.contains("LIBRE")){
                           cola.add(nombre);
                           System.out.println("Añadido a la cola de espera: " + nombre);
                       }else{
                           int indicePrimeraLibre = butacas.indexOf("LIBRE");
                           butacas.set(indicePrimeraLibre, nombre);
                           System.out.println("Reserva efectuada: " + nombre);
                       }
                   }else{
                       System.out.println("Formato incorrecto: 2@Nombre");
                   }
               }
               case "3" ->{
                   if(reciboCliente.length == 2){
                       String nombre = reciboCliente[1];

                       if(butacas.contains(nombre)){
                           int indiceButacaLiberada = butacas.indexOf(nombre);

                           if(cola.isEmpty()){
                               butacas.set(indiceButacaLiberada, "LIBRE");
                           }else{
                               butacas.set(indiceButacaLiberada, cola.removeFirst());
                           }
                           System.out.println("Eliminada la reserva de: " + nombre);
                       }else{
                           System.out.println("Ese nombre no tiene butaca");
                       }

                   }else{
                       System.out.println("Formato incorrecto: 3@Nombre");
                   }
               }

               case "123" ->System.out.println("Root ha cerrado el servidor");
               default -> System.out.println("Opción incorrecta");
            }
            System.out.println("------------------------------");

            if(opcion.equals("123")) break;

        }
        socketUDP.close();
    }
}
