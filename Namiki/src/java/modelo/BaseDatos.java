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
 
    private final String USUARIO = "namiki";
    private final String PASSWORD = "namiki1Pass";
    private final String NOMBREBD = "namiki";
    private final String URL = "mysql.3nyder.com"; 
 
 BaseDatos() {
     this.usuario = this.USUARIO;
     this.password = this.PASSWORD;
     this.nombreBD = this.NOMBREBD;
     this.url = this.URL;
 }
 
 BaseDatos(String usuario, String password, String nombreBD, String url) {
     this.usuario = usuario;
     this.password = password;
     this.nombreBD = nombreBD;
     this.url = url;
 }
 
 public void conectar() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Onta el JDBC Driver?");
        return;
    }
 }
 public ResultSet query(String request) {
     try {
        System.out.println("Antes del Query");
        conexion = DriverManager.getConnection(
                "jdbc:mysql://" + url + "/" + nombreBD, 
                usuario, 
                password);
        declaracion = conexion.createStatement();
        return declaracion.executeQuery(request);
    } catch (SQLException e) {
        System.out.println("Falló la conexión");
    }
    return null;
 }
 public void querySinRespuesta(String request){
     try {
        System.out.println("Antes del Query");
        conexion = DriverManager.getConnection(
                "jdbc:mysql://" + url + "/" + nombreBD, 
                usuario, 
                password);
        declaracion = conexion.createStatement();
        declaracion.executeQuery(request);
    } catch (SQLException e) {
        System.out.println("Falló la operación");
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