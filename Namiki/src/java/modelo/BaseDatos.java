package modelo;

import java.sql.DriverManager;
import java.sql.Connection;
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
 
    private final String USUARIO = "namiki";
    private final String PASSWORD = "namikiPass1";
    private final String NOMBREBD = "namiki";
    private final String URL = "3nyder.com:3306"; 
 
 BaseDatos() {
     usuario = USUARIO;
     password = PASSWORD;
     nombreBD = NOMBREBD;
     url = URL;
     conexion = null;
     declaracion = null;
 }
 
 public void conectar(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Onta el JDBC Driver?");
        return;
    }
    try {
        conexion = DriverManager
        .getConnection("jdbc:mysql://" + url + "/" + nombreBD, usuario, password);

    } catch (SQLException e) {
        System.out.println("Falló la conexión");
        return;
    }
    if (conexion != null) {
        try {
            declaracion = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Falló la conexión");
            return;
        }
        System.out.println("Todo en orden");
    } else {
        System.out.println("Se murió");
    }
 }
 public void query(String request){
     try {
        declaracion.executeQuery(request);
        System.out.println("Operacion exitosa");
    } catch (SQLException e) {
        System.out.println("Falló la conexión");
    }
     
 }
 public void salir(){
     try{
     conexion.close();
     } catch(SQLException e) {
         System.out.println("No existe una conexión a la base de datos");  
     }
 }
}