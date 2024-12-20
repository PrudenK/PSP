package Ejs_4_Hilos.El_Jefe;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Empleado> lista = new ArrayList<>();
        Saludo saludo = new Saludo();


        Empleado e1 = new Empleado("Jose", false, saludo);
        Empleado e2 = new Empleado("Raul", false, saludo);
        Empleado e3 = new Empleado("Manuel", false, saludo);

        Empleado e5 = new Empleado("Luis", false, saludo);

        Empleado e4 = new Empleado("JEFE", true, saludo);

        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        lista.add(e4);
        lista.add(e5);


        lista.forEach(Thread::start);

    }
}
