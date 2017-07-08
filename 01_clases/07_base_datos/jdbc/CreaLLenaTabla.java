/**
 * Este ejemplo supone que exite la Base de Datos "ELO330" ya registrada
 * con MySQL, a la cual se le añade la tabla Amigos que contiene los
 * datos que están codificados en el ejemplo.
 * Para crear la Base de Datos ELO330 use, por ejemplo, el administrador 
 * proporcionado por XAMPP
 */

import java.sql.*;

class CreaLLenaTabla {
    static public void main( String[] args ) {
        Connection conexion;
        Statement sentencia;
    
        System.out.println( "Iniciando programa." );
        try {  // se carga el Driver JDBC
            Class.forName("com.mysql.jdbc.Driver" );
        } catch( Exception e ) {
            System.out.println( "No se pudo cargar el driver" );
            e.printStackTrace();
            return;
        }
        try {
              // Se establece la conexión con la base de datos
              // Se solicita a DriverManager que proporcione una conexión para una 
              // fuente de datos MySQL, con nombre "ELO330"
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ELO330","root", "");
            System.out.println( "Conexion establecida" );
            sentencia = conexion.createStatement();
            try {
                  // Se elimina la tabla en caso de que ya existiese
                sentencia.execute( "DROP TABLE AMIGOS" );
            } catch( SQLException e ) {System.out.println( "Tabla no eliminada" );};
            sentencia.executeUpdate( "CREATE TABLE AMIGOS ("+
                                     " NOMBRE VARCHAR(15) NOT NULL, " +
                                     " APELLIDOS VARCHAR(30) NOT NULL, " +
                                     " CUMPLE DATE) " );
            sentencia.executeUpdate( "INSERT INTO AMIGOS " +
                                     "VALUES('César','Reyes','1988/05/14')" );	  
            sentencia.executeUpdate( "INSERT INTO AMIGOS " +
                                     "VALUES('Matías','Lacasia','1990:10:18')" );
            sentencia.executeUpdate( "INSERT INTO AMIGOS " +
                                     "VALUES('Luis','Muñoz', '1990-03-17')" );
            sentencia.executeUpdate( "INSERT INTO AMIGOS " +
                                     "VALUES('Maximiliano','Zamora', '1988-08-03')" );
            sentencia.close();
            conexion.close();
        } catch( Exception e ) {System.out.println( e ); return;	}
        System.out.println( "Creacion finalizada." );
    } 
}

