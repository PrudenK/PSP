package SegundaEvaluacion.Tema4.UDP.Ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static FunAux.Pausa.pausa;

public class Servidor1 {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        System.out.println("Servidor esperando datagrama...");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

        DatagramSocket socketUDP = new DatagramSocket(12345);
        socketUDP.receive(recibo);
        String mensaje = new String(recibo.getData(), 0, recibo.getLength());

        pausa();

        System.out.println("Servidor recibe: "+mensaje);

        pausa();

        int count = (int) mensaje.chars().filter(c -> c == 'a').count();

        System.out.println("Enviando número de apariciones de la letra 'a': "+count);

        InetAddress direccionCliente = recibo.getAddress();
        int puertoCliente = recibo.getPort();

        byte[] bufferRespuesta = String.valueOf(count).getBytes();
        DatagramPacket envio = new DatagramPacket(bufferRespuesta, bufferRespuesta.length, direccionCliente, puertoCliente);
        socketUDP.send(envio);

        pausa();

        System.out.println("Cerrando conexión...");
        socketUDP.close();
    }
}
