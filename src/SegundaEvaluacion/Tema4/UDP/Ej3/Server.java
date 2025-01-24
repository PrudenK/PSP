package SegundaEvaluacion.Tema4.UDP.Ej3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

public class Server {
    static HashMap<String, String> dictionary = new HashMap<>();
    static int puerto = 6000;

    public static void main(String[] args) throws IOException {
        cargarPalabrasDic();

        System.out.println("Servidro arrancando...");
        DatagramSocket socketUDP = new DatagramSocket(puerto);


        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(recibo);

            String palabraRecibida = new String(recibo.getData(), 0, recibo.getLength());
            System.out.println("Palabra enviada por el cliente: "+ palabraRecibida);

            String translation = dictionary.getOrDefault(palabraRecibida, "");

            if(!translation.isEmpty()){
                InetAddress direccionCliente = recibo.getAddress();
                byte[] bufferEnvio = translation.getBytes();
                DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionCliente, recibo.getPort());
                socketUDP.send(envio);
            }




        }
    }

    private static void cargarPalabrasDic(){
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("dog", "perro");
        dictionary.put("cat", "gato");
        dictionary.put("food", "comida");
    }
}
