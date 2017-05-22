/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes_practicas;
import java.util.Scanner;
/**
 *
 * @author jsepulveda
 */
public class AdivinarNumero {
    public static void main(String[] args){
        int num, n, cant_vidas, vidas, i, swc=0;
        Scanner Leer = new Scanner(System.in);
        num = (int)(Math.random()*25+1);
        System.out.println("Numero "+num);
        System.out.println("Juego adivina numero ");
        System.out.println("Ingrese cantidad de vidas: ");
        cant_vidas = Leer.nextByte();
        for(i=1; i<=cant_vidas; i++){
            System.out.println("Ingrese numero: ");
            n = Leer.nextInt();
            if(n < num)
                System.out.println("El numero es mayor");
            if(n > num)
                System.out.println("El numero es menor");
            if(n == num){
                System.out.println("Adivino!!");
                i = cant_vidas;
                swc = 1;
            }
        }
        if(swc == 0)
            System.out.println("Perdio, no quedan vidas!!");
    }
}
