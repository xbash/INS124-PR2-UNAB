/*
compara enteros utilizando instrucciones if, operadores relacionales
y de igualdad
 */
package fuentes_practicas;
import java.util.Scanner;
/**
 *
 * @author jsepulveda
 */

public class Comparacion {
    // el metodo main empiza la ejecucion de la aplicacion java
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el 1er numero: "); //ingreso
        int num1 = entrada.nextInt(); //lee el 1er numero
        System.out.print("Ingrese el 2do numero: ");
        int num2 = entrada.nextInt(); //lee el 2do numero
        
        if(num1 == num2)
            System.out.printf("%d ==  %d\n", num1, num2);
        if(num1 != num2)
            System.out.printf("%d != %d\n", num1, num2);
        if(num1 < num2)
            System.out.printf("%d < %d\n", num1, num2);
        if(num1 > num2)
            System.out.printf("%d > %d\n", num1, num2);
        if(num1 <= num2)
            System.out.printf("%d <= %d\n", num1, num2);
        if(num1 >= num2)
            System.out.printf("%d >= %d\n", num1, num2);
    } //fin metodo main
} //fin de clase comparacion
