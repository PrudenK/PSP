package SegundaEvaluacion.Tema4.UDP.Ej3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int puerto = 6000;

        DatagramSocket socketUDP = new DatagramSocket();
        InetAddress destino = InetAddress.getByName("localhost");

        socketUDP.setSoTimeout(5000);


        while(true){
            try{
                System.out.println("Mándale una palabra al servidor: ");
                String opcion = sc.nextLine();

                byte[] buffer = opcion.getBytes();
                DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
                socketUDP.send(envio);


                byte[] bufferRespuesta = new byte[1024];
                DatagramPacket respuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
                socketUDP.receive(respuesta);

                String traduccion = new String(respuesta.getData(), 0, respuesta.getLength());
                System.out.println("Traducción: "+ traduccion);
            }catch (SocketTimeoutException e){
                System.err.println("No se encontró traducción");
            }
        }






    }
}
