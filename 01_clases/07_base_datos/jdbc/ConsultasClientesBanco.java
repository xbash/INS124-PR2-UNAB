/**
 * ConsultasClientesBanco.java 
 * Este ejemplo supone que exite una Base de Datos "Banco" ya registrada
 * con mySql, que contiene la tabla "Clientes" con los campos "rut" (entero),
 * "nunCuenta" (entero), "nombre" (string), "fechaActivacion" (fecha) y 
 * "saldo" (entero), para una serie de clientes.
 * El programa se conectará con esta BD y realizará una serie de consultas  
 * a ésta mediante un menu de opciones.
 */

import java.sql.*;
import java.util.*;
class ConsultasClientesBanco {
    static public void main( String[] args ) {
        Connection conexion = null;
        Statement sentencia;
        ResultSet resultado;
        int op = 0, rutbuscado = 0;
        String consulta;
        Scanner s = new Scanner(System.in);
		
        System.out.println( "Conectandose con la Base de datos Banco..." );

        try {  // Se carga el driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
        } catch( Exception e ) {
            System.out.println( "No se pudo cargar el Drive." );
            return;
        }

        try {
            conexion = DriverManager.getConnection( "jdbc:mysql://localhost/Banco","root","");
            System.out.println( "Conexion establecida" );
            sentencia = conexion.createStatement();
		   
            do {
                System.out.println("1) Mostrar todos los datos"); 
                System.out.println("2) Mostrar nombre de los clientes con saldo mayor a $100.000");
                System.out.println("3) Obtener el saldo promedio de todos los clientes");
                System.out.println("4) Mostrar datos de un determinado cliente");
                System.out.println("5) Fin");
                System.out.print("Ingrese opcion: ");
                op = s.nextInt();  
                switch(op) {
                    case 1: resultado = sentencia.executeQuery("Select * from Clientes");
                        while (resultado.next()){
                            System.out.println("Rut = " + resultado.getInt("rut"));
                            System.out.println("Numero de cuenta = " + resultado.getInt("numCuenta"));
                            System.out.println("Nombre cliente = " + resultado.getString("nombre"));
                            System.out.println("Fecha activacion = " + resultado.getDate("fechaActivacion"));
                            System.out.println("Saldo = " + resultado.getInt("saldo"));
                            System.out.println();
                        }
                        break;
                    case 2: consulta = "Select nombre from Clientes where saldo > 100000";
                        resultado = sentencia.executeQuery(consulta); 
                        while (resultado.next())
                            System.out.println("Nombre cliente = " + resultado.getString("nombre"));	
                        break;
                    case 3: consulta = "Select avg(saldo) from Clientes";
                        resultado = sentencia.executeQuery(consulta); 
                        while (resultado.next())
                            System.out.println("Saldo promedio = " + resultado.getInt(1));	
                        break;
                    case 4: System.out.print("Ingrese rut cliente: ");
                        rutbuscado = s.nextInt(); 
                        consulta = "Select * from Clientes where rut = " + rutbuscado;
                        resultado = sentencia.executeQuery(consulta); 
                        while (resultado.next()){
                            System.out.println("Rut = " + resultado.getInt("rut"));
                            System.out.println("Numero de cuenta = " + resultado.getInt("numCuenta"));
                            System.out.println("Nombre cliente = " + resultado.getString("nombre"));
                            System.out.println("Fecha activacion = " + resultado.getDate("fechaActivacion"));
                            System.out.println("Saldo = " + resultado.getInt("saldo"));
                        }
                        break;
                }
            } while (op != 5);
            sentencia.close();
            conexion.close();
        } catch( SQLException e ) {System.out.println("Error en la operacion" + e.getMessage());	} 
    } 
}

