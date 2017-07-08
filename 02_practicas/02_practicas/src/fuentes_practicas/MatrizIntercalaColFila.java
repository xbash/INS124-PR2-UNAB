/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes_practicas;
import java.util.Scanner;
/**
 * dada una matriz, intercalar los elementos de la 1era columna con la ultima columna
 * @author jsepulveda
 */
public class MatrizIntercalaColFila {
    public static void llenarMatriz(int matriz[][], int fil, int col){
        /*int i, j;
        fil--;
        col--; */
        Scanner entrada = new Scanner(System.in);
        
        for(int i=0; i<fil; i++){
            for(int j=0; j<col; j++){
                System.out.print("Inserte pos["+ i +"]["+ j +"]: ");
                //System.out.println("Inserte pos["+ i +"]["+ j +"]:");
                matriz[i][j] = entrada.nextInt();
            }
        }
    }
    public static void mostrarMatriz(int matriz[][], int fil, int col){
        /*int i, j;
        fil--;
        col--; */
        for(int i=0; i<fil; i++){
            System.out.println("");
            for(int j=0; j<col; j++){
                System.out.print("["+matriz[i][j]+"]");
            }
        }
    }
    public static void intercalarMatriz(int matriz[][], int fil, int col){
        //int i, aux;
        col--;
        for(int i=0; i<fil; i++){
            int aux = matriz[i][0];
            matriz[i][0] = matriz[i][col];
            matriz[i][col] = aux;
        }
    }
    public static void main(String[] args){
        //int fil, col, int matriz[][];
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese cantidad de filas de la matriz: ");
        //System.out.print("Ingrese cantidad de filas de la matriz: ");
        int fil = entrada.nextInt();
        System.out.print("Ingrese cantidad de columnas de la matriz: ");
        //System.out.println("Ingrese cantidad de columnas de la matriz: ");
        int col = entrada.nextInt();
        
        //declaracion de matriz
        int matriz[][] = new int[fil][col];
        System.out.println("\n>>Llenar matriz<<");
        llenarMatriz(matriz, fil, col);
        System.out.println("\n>>Matriz original<<");
        mostrarMatriz(matriz, fil, col);
        System.out.println("\n>>Matriz intercalada<<");
        intercalarMatriz(matriz, fil, col);
        mostrarMatriz(matriz, fil, col);
        System.out.println("");
    }
}
