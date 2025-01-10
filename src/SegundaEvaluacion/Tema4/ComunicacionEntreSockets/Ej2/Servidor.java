package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej2;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Servidor {
    static final int Puerto = 2025;
    public static void main( String[] arg ) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            Socket sCliente = skServidor.accept();
            System.out.println("Cliente encontrado "+ sCliente.getInetAddress().getHostName());

            InputStream entrada = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(entrada);
            String mensaje = dis.readUTF();

            FileWriter fw = new FileWriter(obtenerFechaHoy(), true);
            fw.write(mensaje+"\n");
            fw.close();
            System.out.println("Se ha recibido el producto : " +mensaje);

            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }

    public static String obtenerFechaHoy() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        return formato.format(new Date());
    }
}
