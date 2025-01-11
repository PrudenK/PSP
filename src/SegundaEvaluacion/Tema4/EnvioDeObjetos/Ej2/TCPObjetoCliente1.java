package SegundaEvaluacion.Tema4.EnvioDeObjetos.Ej2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static SegundaEvaluacion.Tema4.EnvioDeObjetos.Ej2.TCPObjetoServidor1.pausa;

public class TCPObjetoCliente1 {
    static final String Host = "localhost";
    static final int Puerto = 2025;
    public static void main(String[] args) {
        try {
            Socket sCliente = new Socket(Host, Puerto);

            ObjectInputStream entrada = new ObjectInputStream(sCliente.getInputStream());
            Persona persona = (Persona) entrada.readObject();
            System.out.println("Objeto persona recibido del servidor: " + persona);
            pausa();
            System.out.println("Modificando el objeto persona...");
            pausa();

            persona.setNombre("Miguel");
            persona.setEdad(23);

            System.out.println("Enviando objeto persona...("+persona+")");
            pausa();
            ObjectOutputStream enviarPersona = new ObjectOutputStream(sCliente.getOutputStream());
            enviarPersona.writeObject(persona);
            enviarPersona.flush();

            entrada.close();
            enviarPersona.close();
            sCliente.close();
            pausa();
            System.out.println("Cliente cerrado.");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
