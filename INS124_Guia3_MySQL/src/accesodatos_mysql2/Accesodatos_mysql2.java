/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos_mysql2;

/**
 *
 * @author jsepulveda
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Accesodatos_mysql2{
    static Statement stmt; 
    static Connection con;
    static String url=("jdbc:mysql://127.0.0.1:3306/baseempleado?user=root&password=newPsrotax21"); 
    
    public static void main(String args[]) throws SQLException{
        JOptionPane.showMessageDialog(null,"   Manipular Base de Datos");
        int opcion = -1;
        // El proceso se realiza mientras sea !=  de cero
        do {
            opcion = escoger_opcion();  // llama el método para escoger la opción 
            if (opcion != 0){
                    EjecutarOpcion(opcion); // llama el método para ejecutar la opción
            }
    }
        while ( opcion !=  0);
                    System.exit(0);
    }  // fin del main
	
	public static int escoger_opcion(){
		String opcion;
		int op;
		opcion = JOptionPane.showInputDialog(null,
			"1. Crear Tabla Empleado\n"+
			"2. Insertar datos en Tabla Empleado\n"+
			"3. Recuperar Empleados\n"+
			"0. Exit\n\n"+
			"Ingrese Opcion  :");
		op = Integer.parseInt(opcion);
		return op;
	}

	public static void EjecutarOpcion(int opc) throws SQLException{
		if(opc==1){
			crearTablaEmpleado();
		}
		if(opc==2){
			insertarEmpleados();
		}
		if(opc==3){
			recuperarEmpleados();
		}
		
	}

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); // conectamos a la base de datos 
		} 
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con =DriverManager.getConnection(url);
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
	}

        /*CREATE TABLE Empleado (

		    Employee_ID INTEGER,
		    Nombre VARCHAR(30)
		);*/

	public static void crearTablaEmpleado(){
		Connection con = getConnection();
		String createString;
		createString = "create table Empleado (" + "Employee_ID INTEGER, " + "Nombre VARCHAR(30)," + " PRIMARY KEY(Employee_ID))";
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);
			stmt.close();
			con.close();
            JOptionPane.showMessageDialog(null,"Empleado Tabla Creada");
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"La tabla Empleado ya existe ,continue con la opcion 2");
		}
	} // fin crearEmpleado()

	public static void insertarEmpleados() throws SQLException {
		Connection con = getConnection();
		int cont=0;
		stmt = con.createStatement();
   
		String salida="";
		String codigo; 
	   
		int cod;
		String nomb;
		String  buscaString="";
		codigo = JOptionPane.showInputDialog("Ingrese codigo   :");
		cod=Integer.parseInt(codigo);
		JOptionPane.showMessageDialog(null,"Codigo ingresado es  :"+cod);
		buscaString = "  select * from empleado where Employee_ID = '"+cod+"'  "; 

		try {
			ResultSet rs = stmt.executeQuery(buscaString);
			cont=0;
			while (rs.next()) {
				cont=1;
				int id = rs.getInt("Employee_ID");
				String name = rs.getString("Nombre");
				salida+=id+"  ,  "+ name+"\n";
				JOptionPane.showMessageDialog(null,"El empleado ya existe  :"+ salida);
			}
		}
		catch(SQLException ex) {
			System.err.println("SQLException: Error en la insercion de datos :" + ex.getMessage());
		}
		try {
			if (cont==0){
				String insertString;			
				nomb = JOptionPane.showInputDialog("Ingrese nombre  :");
				insertString="INSERT INTO empleado  VALUES ('" + codigo + "','" + nomb + "')";
				stmt.executeUpdate(insertString);
				JOptionPane.showMessageDialog(null,"Datos Insertados en tabla  Empleado");
				con.close();
			}
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: Error en la insercion de datos :" + ex.getMessage());
		}
 	}

	public static void recuperarEmpleados(){
		Connection con = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Empleado";
		result ="ID_Empleado\t\tNombre\n"; // fila de titulo

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("Employee_ID");
				String name = rs.getString("Nombre");
				result+=id+"  ,  "+ name+"\n";
			}
			stmt.close();
			con.close();
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, result);
	}
}// Fin de clase Accesobasedatos_dos