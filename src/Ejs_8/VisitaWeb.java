package Ejs_8;

import java.io.File;
import java.io.IOException;

public class VisitaWeb {
    public static void main(String[] args) throws IOException {
        String[] webs = args[0].split("@");
        ProcessBuilder pb;

        if (webs.length > 3){
            throw new RuntimeException("Demasidas páginas web, como mucho puedes poner 3");
        }else {
            for (String web : webs) {
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", web);
                } else {
                    pb = new ProcessBuilder("firefox", web);
                }
                pb.start();
            }
            System.out.println("Programa terminado");
        }
    }
}
