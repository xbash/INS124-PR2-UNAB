/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes_practicas;

import javax.swing.JOptionPane;
 
public class CompararString {
 
   public static void main( String args[] )
   {
      String s1 = new String( "hola" );  // s1 es una copia de "hola"
      String s2 = "adiós";
      String s3 = "Feliz Cumpleaños";
      String s4 = "feliz cumpleaños";
      String nombre1="juan";
      String nombre2="juan";
      String nombre3="Juan";
      
      
 
      String salida = "s1 = " + s1 + "\ns2 = " + s2 + "\ns3 = " + s3 +
         "\ns4 = " + s4 + "\n\n";
 
      // probar igualdad
      if ( s1.equals( "hola" ) )  // true
         salida += "s1 es igual a \"hola\"\n";
      else
         salida += "s1 es distinta de \"hola\"\n";
 
      // probar igualdad con ==
      if ( s1 == "hola" )  // false; no son el mismo objeto
         salida += "s1 es igual a \"hola\"\n";
      else
         salida += "s1 es distinta de \"hola\"\n";
 
      // probar igualdad (ignorar mayúsculas)
      if ( s3.equalsIgnoreCase( s4 ) )  // true
         salida += "s3 es igual a s4\n";
      else
         salida += "s3 es distinta de s4\n";
 
      // probar compareTo
      salida += "\ns1.compareTo( s2 ) es " + s1.compareTo( s2 ) +
         "\ns2.compareTo( s1 ) es " + s2.compareTo( s1 ) +
         "\ns1.compareTo( s1 ) es " + s1.compareTo( s1 ) +
         "\ns3.compareTo( s4 ) es " + s3.compareTo( s4 ) +
         "\ns4.compareTo( s3 ) es " + s4.compareTo( s3 ) + "\n\n" +
         "nombre1.compareTo( nombre2) es " + nombre1.compareTo( nombre2 ) + "\n"+
         "\n nombre1 = juan es > nombre3 = Juan ... El resultado es > 0 "+ "\n" +     
         "nombre1.compareTo( nombre3) es " + nombre1.compareTo( nombre3 ) + "\n"; 
      
       
      JOptionPane.showMessageDialog( null, salida,
         "Comparaciones entre cadenas", JOptionPane.INFORMATION_MESSAGE );
 
      System.exit( 0 );
   }
 } // fin de la clase CompararString
