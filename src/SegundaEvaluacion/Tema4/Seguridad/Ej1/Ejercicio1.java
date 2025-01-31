package SegundaEvaluacion.Tema4.Seguridad.Ej1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        FileOutputStream fileout = new FileOutputStream("Datos.dat");
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String datos = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        byte dataBytes[] = datos.getBytes();

        md.update(dataBytes);
        byte[] resumen = md.digest();

        dataOS.writeObject(datos);
        dataOS.writeObject(resumen);

        dataOS.writeObject(md.digest());

        dataOS.close();
        fileout.close();
    }

}

