/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Jules 
 */
public class Usuario {

  private int idUsuario;
  private String nombre;
  private int categoria;
  private String telefono;
  private String correo;
  private String fecha;
  private String usuario;
  private String password;
  
     public int getidUsuario() {
        return idUsuario;
     }
     public String getNombre() {
        return nombre;
     }
     public int getCategoria() {
        return categoria;
     }
     public String getTelefono() {
        return telefono;
     }
     public String getFecha() {
        return fecha;
     }
     public String getUsuario() {
        return usuario;
     }
     public String getPassword() {
         return password;
     }
     
     public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
     }
     public void setnombre(String nombre) {
        this.nombre = nombre;
     }
     public void setCategoria(int categoria) {
        this.categoria = categoria;
     }
     public void setDTelefono(String telefono) {
        this.telefono = telefono;
     }
     public void setFecha(String fecha) {
        this.fecha = fecha;
     }
     public void setUsuario(String usuario) {
        this.usuario = usuario;
     }
     public void setPassword(String password) {
         this.password = password;
     }

     public void getProblemas() {
     }

     public void getAportes() {
     }

     public String entrarSistema() throws SQLException,ClassNotFoundException {
        String retorno = "Datos Incorrectos";
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String query = "select idUsuario from usuario where idUsuario = ? and password = ?";
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement(query);
        pstm.setInt(1, idUsuario);
        rs = pstm.executeQuery();
        if (rs.next())
            retorno = "Datos Correctos";
        else
            retorno = "Datos Incorrectos";
            con.close();
        return retorno;
    }

    public void cerrarSistema() {
        
    }

    public boolean registrarUsuario() throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("insert Into Usuario values(?,?,?,?,?,?)");
        pstm.setString(1, nombre);
        pstm.setInt(2, categoria);
        pstm.setString(3, telefono);
        pstm.setString(4, correo);
        pstm.setString(5, fecha);
        pstm.setString(6, usuario);
        pstm.setString(7, password);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
    }

}