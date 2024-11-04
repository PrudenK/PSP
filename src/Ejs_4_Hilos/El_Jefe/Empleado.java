package Ejs_4_Hilos.El_Jefe;

public class Empleado extends Thread{
    private String nombre;
    private boolean esJefe;
    private Saludo saludo;

    public Empleado(String nombre, boolean esJefe, Saludo saludo) {
        this.nombre = nombre;
        this.esJefe = esJefe;
        this.saludo = saludo;
    }

    public void run() {
        System.out.println("entra "+nombre );
        saludo.saludar(this);
    }

    public boolean isEsJefe() {
        return esJefe;
    }

    public String getNombre() {
        return nombre;
    }
}
