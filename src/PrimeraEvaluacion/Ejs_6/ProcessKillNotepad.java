package PrimeraEvaluacion.Ejs_6;

import java.io.IOException;

public class ProcessKillNotepad {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            pb = new ProcessBuilder("notepad");
        } else {
            pb = new ProcessBuilder("gedit");
        }

        Process p = pb.start();
        try {
            Thread.sleep(10000);
            p.destroy();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
