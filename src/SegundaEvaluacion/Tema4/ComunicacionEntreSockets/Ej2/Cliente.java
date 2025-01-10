package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto = 2025;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {
        try {
            Socket sCliente = new Socket(Host, Puerto);
            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salida);


            System.out.println("PROGRAMA CLIENTE INICIADO...");
            System.out.println("Introduzca producto para insertarlo en la lista de la compra: ");
            String mensaje = sc.nextLine();
            System.out.println("Se ha volcado el producto "+mensaje+" a la lista de la compra.");

            dos.writeUTF(mensaje);
            dos.flush();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
