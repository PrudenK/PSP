package SegundaEvaluacion.Tema4.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.net.NetworkInterface.getByName;

public class Cliente{
    public static void main(String[] args) throws IOException {
            final int puerto = 12345;
            byte[] buffer = new byte[1024];
            InetAddress destino = InetAddress.getByName("192.168.74.216");
           // getByName(args[0]);
            String mensaje = "hola";
            buffer = mensaje.getBytes();
            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
            DatagramSocket socketUDP = new DatagramSocket(34567);
            System.out.println("Envio el datagrama");
            socketUDP.send(envio);
            socketUDP.close();
        }

}
