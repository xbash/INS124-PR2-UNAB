/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerclasesmetodos;

/**
 *
 * @author jsepulveda
 */
public class TallerClasesMetodos {
    public static void main(String[] args){
        System.out.print("");
        //creacion del objeto Alumno
        Alumno Alum = new Alumno();
        //llamado a los metodos
        Alum.Ingreso_notas_parciales();
        Alum.Ingreso_examen();
        Alum.Mostrar();        
    }
}
