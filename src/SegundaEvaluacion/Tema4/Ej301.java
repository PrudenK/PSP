package SegundaEvaluacion.Tema4;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ej301 {
    public static void main(String[] args) throws UnknownHostException {
        Inet4Address ipLocal = (Inet4Address) Inet4Address.getByName("localhost");

        System.out.println("SALIDA PARA LOCALHOST:");
        System.out.printf("%7sMétodo getByName(): %s", "", Inet4Address.getByName("localhost"));
        System.out.printf("\n%7sMétodo getLocalHost(): %s", "", Inet4Address.getLocalHost());
        System.out.printf("\n%7sMétodo getHostName(): %s", "", ipLocal.getHostName());
        System.out.printf("\n%7sMétodo getHostAddress(): %s", "", ipLocal.getHostAddress());
        System.out.printf("\n%7sMétodo getCanonicalHostName(): %s", "", ipLocal.getCanonicalHostName());

        System.out.println("\n======================================================");

        String url = "www.google.es";

        Inet4Address ipGoogle = (Inet4Address) Inet4Address.getByName(url);

        System.out.println("SALIDA PARA UNA URL:");
        System.out.printf("%7sMétodo getByName(): %s", "", Inet4Address.getByName(url));
        System.out.printf("\n%7sMétodo getLocalHost(): %s", "", ipGoogle.getLocalHost());
        System.out.printf("\n%7sMétodo getHostName(): %s", "", ipGoogle.getHostName());
        System.out.printf("\n%7sMétodo getHostAddress(): %s", "", ipGoogle.getHostAddress());
        System.out.printf("\n%7sMétodo getCanonicalHostName(): %s", "", ipGoogle.getCanonicalHostName());

        InetAddress[] google = Inet4Address.getAllByName(url);

        System.out.printf("\n%7sDIRECCIONES IP PARA: %s", "", url);
        for (InetAddress ip : google) {
            System.out.printf("\n%14s%s","", ip.getHostName()+"/"+ip.getHostAddress());
        }

    }
}
