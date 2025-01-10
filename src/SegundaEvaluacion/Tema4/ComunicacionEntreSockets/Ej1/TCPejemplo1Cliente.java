package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPejemplo1Cliente {
    static final String Host = "localhost";
    static final int Puerto = 2025;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("PROGRAMA CLIENTE INICIADO");
        try {
            Socket sCliente = new Socket(Host, Puerto);
            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salida);

            System.out.println("    -Escribe algo para el servidor:");
            String mensaje = sc.nextLine();
            dos.writeUTF(mensaje);
            dos.flush();
            dos.close();

            InputStream entrada = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(entrada);
            String mensajeDelServidor = dis.readUTF();
            System.out.println(mensajeDelServidor);

            dis.close();
            sCliente.close();
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
