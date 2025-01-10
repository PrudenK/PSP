package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej3;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientePro {
    static final String Host = "localhost";
    static final int Puerto = 2025;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {
        try {
            Socket sCliente = new Socket(Host, Puerto);
            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salida);

            while (true) {
                System.out.print("Envía un mensaje al servidor: ");
                String mensaje = sc.nextLine();

                if(!mensaje.equals("salir")) {
                    System.out.println("Producto añadido "+mensaje);
                }else break;

                dos.writeUTF(mensaje);
                dos.flush();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
