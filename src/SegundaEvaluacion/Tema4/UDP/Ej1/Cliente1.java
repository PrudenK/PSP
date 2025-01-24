package SegundaEvaluacion.Tema4.UDP.Ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import static FunAux.Pausa.pausa;

public class Cliente1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int puerto = 12345;

        InetAddress destino = InetAddress.getByName("192.168.74.216");

        System.out.println("Introduce mensaje:");
        String mensaje = sc.nextLine();

        byte[] buffer = mensaje.getBytes();
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
        DatagramSocket socketUDP = new DatagramSocket(34567);
        socketUDP.send(envio);

        System.out.println("Esperando datagrama");

        pausa();

        byte[] bufferRespuesta = new byte[1024];
        DatagramPacket respuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
        socketUDP.receive(respuesta);

        pausa();

        String mensajeRespuesta = new String(respuesta.getData(), 0, respuesta.getLength());
        System.out.println("Recibo número de caracteres 'a' que son: " + mensajeRespuesta);

        socketUDP.close();
    }
}
