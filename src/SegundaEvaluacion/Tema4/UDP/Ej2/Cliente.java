package SegundaEvaluacion.Tema4.UDP.Ej2;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static FunAux.Pausa.pausa;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int puerto = 12345;

        InetAddress destino = InetAddress.getByName("172.30.77.5");
        DatagramSocket socketUDP = new DatagramSocket(34567);

        while(true){
            menu();
            String opcion = sc.nextLine();

            byte[] buffer = opcion.getBytes();
            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
            socketUDP.send(envio);


        }
    }

    public static void menu(){
        System.out.println("==TICKETSERVER==");
        System.out.println("Introduzca opción:");
        System.out.println("1-Listar butacas");
        System.out.println("2-Reservar butacas");
        System.out.println("3-Anular butacas");
        System.out.println("4-Salir");
    }
}
