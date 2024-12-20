package SegundaEvaluacion.Tema4;

import java.net.MalformedURLException;
import java.net.URL;

public class Ej302 {
    public static void main(String[] args) throws MalformedURLException {

        URL url1 = new URL("http://docs.oracle.com/");
        URL url2 = new URL("http", "docs.oracle.com", "/javase/23");
        URL url3 = new URL("http", "docs.oracle.com", 123, "/javase/23");

        imprmirInfoURL(url1);
        imprmirInfoURL(url2);
        imprmirInfoURL(url3);
    }

    private static void imprmirInfoURL(URL url) {
        System.out.println("URL completa: "+url.toString());
        System.out.println("getProtocol: " + url.getProtocol());
        System.out.println("getHost: " + url.getHost());
        System.out.println("getPort: " + url.getPort());
        System.out.println("getFile: " + url.getFile());
        System.out.println("getUserInfo: " + url.getUserInfo());
        System.out.println("getPath: " + url.getPath());
        System.out.println("getAuthority: " + url.getAuthority());
        System.out.println("getQuery: " + url.getQuery());
        System.out.println("getDefaultPort: " + url.getDefaultPort());
        System.out.println("--------------------------------------------------------");
    }
}
