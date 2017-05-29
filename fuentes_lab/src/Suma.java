/*
programa que recibe dos numeros y muestra la suma
 */
package fuentes_practicas;
import java.util.Scanner;

/**
 *
 * @author jsepulveda
 */
public class Suma {
    public static void main(String[] args){
        //crea un objeto Scanner para obtener la entrada de la ventana de comandos
        Scanner entrada = new Scanner(System.in);
        
        int numero1;
        int numero2;
        int suma;
        
        System.out.print("Escriba el primer numero entero: ");
        numero1 = entrada.nextInt(); //utiliza el metodo nextInt() del objeto entrada de la clase Scanner
        System.out.print("Escriba el segundo numero entero: ");
        numero2 = entrada.nextInt();
        
        suma = numero1 + numero2;
        
        System.out.printf("La suma es %d%n", suma);
        
    }
}
