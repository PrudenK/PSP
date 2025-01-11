package PrimeraEvaluacion.Ejs_4_Hilos.Sincronizar4_2;

public class Contador {
    int valor;
    public Contador(int valor){
        this.valor = valor;
    }
    public void incrementar(){
        valor++;
    }
    public void decrementar(){
        valor--;
    }
    public int getValor() {
        return valor;
    }
}
