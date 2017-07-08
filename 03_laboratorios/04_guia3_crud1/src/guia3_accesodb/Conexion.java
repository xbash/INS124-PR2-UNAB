/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3_accesodb;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author jsepulveda
 */
public class Conexion {
    public static final String Url = "jdbc:mysql://localhost:3306/guia3_crud";
    public static final String Username = "root";
    public static final String Password = "newPsrotax21";
    public static Connection getConnection(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(Url,Username,Password);
            JOptionPane.showMessageDialog(null,"Bien, conexion exitosa!");
        } catch(Exception ex){
            System.out.println("Se ha producido un error al conectarse a MySQL. Excepcion: "+ex);
        }
        return conexion;
    }
}
