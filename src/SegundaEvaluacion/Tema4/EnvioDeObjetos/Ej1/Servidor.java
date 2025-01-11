package SegundaEvaluacion.Tema4.EnvioDeObjetos.Ej1;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int Puerto = 2025;

    public static void main(String[] args) {
        System.out.println("Esperando conexión del cliente...");
        try{
            ServerSocket skServidor = new ServerSocket(Puerto);
            Socket sCliente = skServidor.accept();
            System.out.println("¡Cliente encontrado!");

            ObjectInputStream entrada = new ObjectInputStream(sCliente.getInputStream());
            System.out.println("Objeto recibido del cliente: "+entrada.readObject().toString());

            DataOutputStream enviarMensaje = new DataOutputStream(sCliente.getOutputStream());
            enviarMensaje.writeUTF("Mensaje recibido correctamente en el servidor");
            enviarMensaje.flush();

            entrada.close();
            enviarMensaje.close();
            sCliente.close();
            skServidor.close();

            System.out.println("Conexión cerrada.");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
