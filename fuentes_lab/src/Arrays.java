/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes_practicas;
import java.io.*;
/**
 *
 * @author jsepulveda
 */
public class Arrays {
    public static void main(String[] args){
        int num[] = rellenarArraysDesde(5);
        imprimirArrays(num);
    }
    public static void imprimirArrays(int lista[]){
        int i;
        for(i=0; i<lista.length; i++){
            //asas
            System.out.println(lista[i]);
        }
    }
    public static int[] rellenarArraysDesde(int a){
        int num[] = new int [10]; //arreglo de largo 10
        int i;
        for(i=0; i<num.length; i++){ //imprime desde 5 en adelante hasta el 14
            num[i] = a;
            a++;
        }
        return num;
    }
}
