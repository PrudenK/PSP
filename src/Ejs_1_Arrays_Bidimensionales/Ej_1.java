package Ejs_1_Arrays_Bidimensionales;

import java.util.*;

public class Ej_1 {
    public static void main(String[] args) { //Nota lo esta aplicación función desde el punto de vista de las casiilas negras en un partida real.
        ArrayList<String> casillasPosibles = new ArrayList<>();
        String letras = "ABCDEFGH";
        String[][] tablero = new String[8][8];
        iniciarTablero(tablero,letras);
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la casilla donde quieres poner el álfil : ");
        String casillaAlfil = sc.next();

        int casillaMatrizLetra = letras.indexOf(casillaAlfil.charAt(0));
        int casillaMatrizNumero = Integer.parseInt(String.valueOf(casillaAlfil.charAt(1)))-1;

        for (int i = 0; i < 8; i++) {
            comprobarCasillas(casillasPosibles, casillaMatrizNumero + i, casillaMatrizLetra + i, tablero);
            comprobarCasillas(casillasPosibles, casillaMatrizNumero - i, casillaMatrizLetra - i, tablero); // los dos primeros diagonal principal
            comprobarCasillas(casillasPosibles, casillaMatrizLetra + i, casillaMatrizNumero - i, tablero); // los dos siguientes diagonal inversa
            comprobarCasillas(casillasPosibles, casillaMatrizLetra - i, casillaMatrizNumero + i, tablero);
        }

        Set<String> lista_casillas_set = new HashSet<>(casillasPosibles); // para eliminar repetidas
        lista_casillas_set.remove(casillaAlfil);

        for(String casilla : lista_casillas_set){
            System.out.print(casilla +"  "); // imprimir casillas
        }
    }

    public static void iniciarTablero(String[][] tablero, String letras){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = String.valueOf(letras.charAt(j))+(i+1);
            }
        }
    }

    public static void comprobarCasillas(ArrayList<String> lista, int x, int y, String[][] tablero){
        try {
            lista.add(tablero[x][y]);
        } catch (Exception ignored) {}
    }
}