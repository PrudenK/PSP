package Ejs_4_Hilos.El_Jefe;


public class Saludo{
    private boolean elJefeHaEntrado = false;

    public void saludar(Empleado e){
        if (e.isEsJefe()){
            saludoJefe();
        }else saludoEmpleado(e);
    }

    private synchronized void saludoEmpleado(Empleado e){
        if(!elJefeHaEntrado){
            try {
                wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Buenos días "+e.getNombre());
        }else{
            System.out.println("Perdón por el retraso "+e.getNombre());
        }
    }


    private synchronized void saludoJefe(){
        System.out.println("El jefe entra ");
        elJefeHaEntrado = true;
        notifyAll();
    }
}
