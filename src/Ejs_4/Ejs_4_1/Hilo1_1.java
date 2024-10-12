package Ejs_4.Ejs_4_1;

public class Hilo1_1 extends Thread{
    public Hilo1_1(String nom){
        super(nom);
    }
    public void run(){
        contador();
    }
    public void contador(){
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() +" ->  "+i);
        }
    }
}
