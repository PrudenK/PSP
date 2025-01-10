package SegundaEvaluacion.Tema4.ComunicacionEntreSockets.Ej3;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServidorPro {
    static final int Puerto = 2025;
    public static void main( String[] arg ) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            Socket sCliente = skServidor.accept();
            System.out.println(sCliente.getInetAddress().getHostAddress());

            while (true) {
                InputStream entrada = sCliente.getInputStream();

                DataInputStream dis = new DataInputStream(entrada);

                String mensaje = dis.readUTF();
                if(mensaje.equals("salir")){
                    System.out.println("Servidor cerrado ");
                    break;
                }else{
                    FileWriter fw = new FileWriter(obtenerFechaHoy(), true);
                    fw.write(sCliente.getInetAddress()+"("+obtenerFechaHoyConHorasMinutosYSegundos()+"): "+ mensaje+"\n");
                    fw.close();
                    System.out.println(mensaje);
                }

            }
            skServidor.close();

        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }

    public static String obtenerFechaHoy() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        return formato.format(new Date());
    }
    public static String obtenerFechaHoyConHorasMinutosYSegundos() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        return formato.format(new Date());
    }
}

