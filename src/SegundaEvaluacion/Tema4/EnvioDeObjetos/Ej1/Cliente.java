package SegundaEvaluacion.Tema4.EnvioDeObjetos.Ej1;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    static final String Host = "localhost";
    static final int Puerto = 2025;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan Pérez");
        clientes.add("María López");
        clientes.add("Carlos García");
        clientes.add("Ana Martínez");

        System.out.println("Iniciando conexión con el servidor...");

        try{
            Socket sCliente = new Socket(Host, Puerto);

            ObjectOutputStream os = new ObjectOutputStream(sCliente.getOutputStream());
            os.writeObject(clientes);
            os.flush();

            System.out.println("Objeto enviado al servidor: Lista de clientes");

            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            System.out.println("Objeto recibido del servidor: " + dis.readUTF());

            os.close();
            dis.close();
            sCliente.close();

            System.out.println("Conexión cerrada.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
