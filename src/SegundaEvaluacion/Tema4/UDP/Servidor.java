package SegundaEvaluacion.Tema4.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        System.out.println("Iniciado el servidor UDP");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.
                length);
        DatagramSocket socketUDP = new DatagramSocket(12345);
        socketUDP.receive(recibo);
        String mensaje = new String(recibo.getData());

        int puertoCliente = recibo.getPort();
        InetAddress direccion = recibo.getAddress();
        System.out.println("Num. bytes recibidos: "+recibo.getLength());
        System.out.println("Mensaje: "+mensaje);
        System.out.println("Puerto Origen: "+recibo.getPort());
        System.out.println("IP Origen: "+recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino: "+socketUDP.getLocalPort());
        socketUDP.close();
    }

}
