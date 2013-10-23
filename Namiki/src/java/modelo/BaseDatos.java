package modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class BaseDatos {
    private String usuario;
    private String password;
    private String nombreBD;
    private Connection conexion;
    private Statement declaracion;
    private String url;
    
    private boolean debug;

    private final String USUARIO = "namiki";
    private final String PASSWORD = "namiki1Pass";
    private final String NOMBREBD = "namiki";
    private final String URL = "mysql.3nyder.com"; 
    
    BaseDatos() {
       this.usuario = this.USUARIO;
       this.password = this.PASSWORD;
       this.nombreBD = this.NOMBREBD;
       this.url = this.URL;
       this.debug = true;
   }
   
   BaseDatos(String usuario, String password, String nombreBD, String url) {
       this.usuario = usuario;
       this.password = password;
       this.nombreBD = nombreBD;
       this.url = url;
       this.debug = true;
   }
   
   public Connection getConexion() {
       try {
           conexion = DriverManager.getConnection(
            "jdbc:mysql://" + url + "/" + nombreBD, 
            usuario, 
            password);
       } catch(SQLException e) {
           System.err.println("ERROR en la conexión en getConexion()");
       }
       return this.conexion;
   }
   
   public void conectar() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Onta el JDBC Driver?");
        return;
    }
}

public int query(String request) {
   try {
    conexion = DriverManager.getConnection(
        "jdbc:mysql://" + url + "/" + nombreBD, 
        usuario, 
        password);
    declaracion = conexion.createStatement();
    System.out.println(request);
    return declaracion.executeUpdate(request);
} catch (SQLException e) {
    if(debug) {
        printSQLException(e);
    }
    System.out.println("Falló la operación");
}
return 0;
}

public ResultSet queryRS(String request) {
   try {
    conexion = DriverManager.getConnection(
        "jdbc:mysql://" + url + "/" + nombreBD, 
        usuario, 
        password);
    declaracion = conexion.createStatement();
    System.out.println(request);
    return declaracion.executeQuery(request);
} catch (SQLException e) {
    if(debug){
        printSQLException(e);
    }
    System.out.println("Falló la operación");
}
return null;
}

public void salir(){
   try{
    conexion.close();
} catch(SQLException e) {
   System.out.println("No existe una conexión a la base de datos");  
}
}
private static void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
        if (e instanceof SQLException) {
            if (ignoreSQLException(
                ((SQLException)e).
                getSQLState()) == false) {
                e.printStackTrace(System.err);
            System.err.println("SQLState: " +
                ((SQLException)e).getSQLState());

            System.err.println("Error Code: " +
                ((SQLException)e).getErrorCode());

            System.err.println("Message: " + e.getMessage());

            Throwable t = ex.getCause();
            while(t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}
}

private static boolean ignoreSQLException(String sqlState) {

    if (sqlState == null) {
        System.out.println("The SQL state is not defined!");
        return false;
    }

    // X0Y32: Jar file already exists in schema
    if (sqlState.equalsIgnoreCase("X0Y32"))
        return true;

    // 42Y55: Table already exists in schema
    if (sqlState.equalsIgnoreCase("42Y55"))
        return true;

    return false;
}
}