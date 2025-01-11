package PrimeraEvaluacion.Ejs_4_Hilos.EjsMenu;

public class MainMenu {
    public static void main(String[] args) throws InterruptedException {
        MenuHilo menuPrimeros = new MenuHilo(1);
        MenuHilo menuSegundos = new MenuHilo(2);
        MenuHilo menuPostres = new MenuHilo(3);

        menuPrimeros.start();
        menuSegundos.start();
        menuPostres.start();






    }
}
