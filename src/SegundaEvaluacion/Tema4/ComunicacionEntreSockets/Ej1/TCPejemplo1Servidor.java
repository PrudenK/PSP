package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    static final int Puerto = 2025;

    public static void main(String[] args) {
        System.out.println("PROGRAMA SERVIDOR INICIADO");
        try{
            ServerSocket skServidor = new ServerSocket(Puerto);
            Socket sCliente = skServidor.accept();
            System.out.println(sCliente.getInetAddress().getHostAddress());

            InputStream entrada = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(entrada);
            String mensaje = dis.readUTF();
            dis.close();

            System.out.println("Mensaje recibido: " + mensaje);

            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(salida);
            dos.writeUTF("Desde el servidor hemos recibido el mensaje : "+mensaje);
            dos.flush();
            dos.close();

            skServidor.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


    }
}
