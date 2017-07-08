/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;
import java.util.Scanner;

/**
 *
 * @author jsepulveda
 */
public class Alumno {
    /**
     * @param args the command line arguments
     */
    //private Scanner teclado;
    private String rut;
    private String nombre;
    private int edad;
        
    public Alumno() {
        String nomb;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIngrese Rut : ");
        rut = teclado.next();
        System.out.println("Ingrese nombre : ");
        nomb = teclado.nextLine();
        nombre = teclado.nextLine();
        System.out.println("Ingrese edad : ");
        edad = teclado.nextInt();
    }
    public void imprimir() {
        System.out.println("\n\nRut :"+rut);
        System.out.println("Nombre :"+nombre);
        System.out.println("Edad :"+edad);
    }
    public void esMayorEdad() {
        if (edad >= 18) {
        System.out.println(nombre+" es mayor de edad.");
        } else {
        System.out.println(nombre+" no es mayor de edad.");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ingrese los datos de 2 alumnos");
        Alumno alumno1 = new Alumno();
        alumno1.imprimir();
        alumno1.esMayorEdad();
        Alumno alumno2 = new Alumno();
        alumno2.imprimir();
        alumno2.esMayorEdad();
    }    
}