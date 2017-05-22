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
public class UsoDeString {

    public static void main(String[] args) {
        String str;
        int i, h = 0, m = 0, total;
        Scanner Leer = new Scanner(System.in);
        System.out.println("Cuantas personas son?: ");
        total = Leer.nextInt();
        for (i = 1; i <= total; i++) {
            System.out.println("Proporciona sexo: ");
            str = Leer.next();
            if((str.equals("h")) || (str.equals("H")));
                h++;
            if((str.equals("m")) || (str.equals("M")));
                m++;
        }
        System.out.println("Hay: ");
        System.out.println("Hombres: "+h);
        System.out.println("Mujeres: "+m);
    }
}
