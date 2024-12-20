package Ejs_6;

import java.io.IOException;

public class Enrique {
    public static void main(String[] args) throws IOException {
        while (true){
            ProcessBuilder pb = new ProcessBuilder("konsole","-e","ping 192.168.74.209");
            pb.start();
        }
    }
}
