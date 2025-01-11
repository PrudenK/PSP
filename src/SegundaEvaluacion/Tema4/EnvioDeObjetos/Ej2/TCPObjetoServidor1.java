package SegundaEvaluacion.Tema4.EnvioDeObjetos.Ej2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {
    static final int Puerto = 2025;
    public static void main(String[] args) {
        System.out.println("Servidro abierto, esperando al cliente...");
        try {
            ServerSocket servidor = new ServerSocket(Puerto);
            Socket cliente = servidor.accept();
            System.out.println("Cliente: " +cliente.getInetAddress().getHostAddress());
            pausa();

            Persona persona = new Persona("Manolo", 72);

            System.out.println("Enviando persona al cliente: "+ persona);
            pausa();

            ObjectOutputStream escribir = new ObjectOutputStream(cliente.getOutputStream());
            escribir.writeObject(persona);
            escribir.flush();

            pausa();
            ObjectInputStream entradaPersona = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Persona modificada por el cliente recibida : " +entradaPersona.readObject());
            pausa();

            escribir.close();
            entradaPersona.close();
            cliente.close();
            servidor.close();
            System.out.println("Servidor cerrado.");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void pausa(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
