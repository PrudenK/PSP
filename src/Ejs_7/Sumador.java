package Ejs_7;

public class Sumador {
    public static int sumaIntervalosDeDosNumero(int  num1, int num2){
        int sumatorio = 0;
        while (num1 <= num2){
            sumatorio += num1;
            num1++;
        }

        return sumatorio;
    }


    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int resultado = sumaIntervalosDeDosNumero(num1,num2);
        System.out.println("Resultado -> "+resultado);

    }

}
