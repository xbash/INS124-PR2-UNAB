/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rgonzalez
 */
public class ClassMysql {
        static Statement stmt; 
        static Connection con;
        static String url=("jdbc:mysql://127.0.0.1:3306/Proyecto?user=root&password=newPsrotax21"); 

    public ClassMysql() {
       this.con= getConnection();
    }
        
        
        public Connection getCon (){
            return this.con;
        }
        public static Connection getConnection()
	{
	        try { 
                        Class.forName("com.mysql.jdbc.Driver"); // conectamos a la base de datos                                        
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException, no se encuentra el Driver: ");
			System.err.println(e.getMessage());
                    	}
		try {
                       	con =DriverManager.getConnection(url);       
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
	}
        
        
        public  void EjecutarQuery(String Query)
	{
		Connection con = getConnection();
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(Query);
			stmt.close();
			con.close();
		     } catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());   
                        JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	
	}
}
