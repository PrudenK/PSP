package SegundaEvaluacion.Tema4.ProgramacionFuncional;


public class Profesional {
    private String nombre;
    private int edad;
    private char genero;
    private int tipoDeProfesional;

    // Constructor
    public Profesional(String nombre, int edad, char genero, int tipoDeProfesional) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipoDeProfesional = tipoDeProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getTipoDeProfesional() {
        return tipoDeProfesional;
    }

    public void setTipoDeProfesional(int tipoDeProfesional) {
        this.tipoDeProfesional = tipoDeProfesional;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", tipoDeProfesional=" + tipoDeProfesional +
                '}';
    }
}