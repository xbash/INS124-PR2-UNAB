/**
 * Pacientes.java 
 * Este ejemplo supone que exite una Base de Datos "Hospital" ya registrada
 * con mySql, que contiene la tabla "Pacientes" con los campos rut (entero), nombre (string),
 * deuda (entero), isapre (string), y habitación (entero), para una serie de pacientes.
 * El programa se conectará con esta BD y realizará una serie de consultas  
 * a ésta mediante un menu de opciones.
 */

import java.io.*;
import java.util.*;
import java.sql.*;

public class Pacientes{
    public static void main(String[]args) {
        int menu;
        Scanner s=new Scanner(System.in);
        System.out.println( "Cargando drivers..." );
        Connection conn=null;
        Statement senten=null;
        ResultSet res=null;
		
        try{
		
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }	
		
        try {
		
            System.out.println( "Driver cargado" );
            System.out.println( "Iniciando Conexion a base de datos <Hospital>..." );
            conn = DriverManager.getConnection( "jdbc:mysql://localhost/Hospital","root","" );
            senten = conn.createStatement();
            System.out.println( "Conexion iniciada\n\n" );		                   
            do{
                System.out.println(" MENU");
                System.out.println("	(1)Consultar Tabla Completa");
                System.out.println("	(2)Eliminar Datos");
                System.out.println("	(3)Salir");
                System.out.println("");
                System.out.print( "Elija una Opcion: " );
                menu = s.nextInt();
                switch(menu){
                    case 1: res = senten.executeQuery("select * from Pacientes");
                        while(res.next()){
                            System.out.println("Rut: " + res.getInt("rut"));
                            System.out.println("Nombre: " + res.getString("nombre"));
                            System.out.println("Deuda: " + res.getInt("deuda"));
                            System.out.println("Isapre: " + res.getString("isapre"));
                            System.out.println("Tipo habitacion: " + res.getInt(5));
                        }
                        break;
                    case 2: int rutelim=0;
                        System.out.println("ingrese rut a eliminar");
                        rutelim = s.nextInt();
                        int sal = senten.executeUpdate("Delete from  Pacientes where rut = " + rutelim);
                        if (sal == 1)
                            System.out.println("Paciente eliminado");
                        else System.out.println("Paciente no encontrado");
                        break;
                }
            } while(menu != 3);
          conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}


