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
public class Problema {
    
    private int idProblema;
    private int idCategoria;
    private int idUsuario;
    private String descripcion;
    private String fecha;
    private String titulo;
    private String topico;
    
    public Problema(int idProblema, int idCategoria, int idUsuario,
                String fecha, String titulo, String topico) {

        }
    
    public int getidProblema() {
        return idProblema;
    }
    public int getidCategoria() {
        return idCategoria;
    }
    public int getidUsuario() {
        return idUsuario;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getTopico() {
        return topico;
    }
    
    public void setidProblema(int idProblema) {
        this.idProblema = idProblema;
    }
    public void setidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setDescripcion(String Descripcion) {
        this.descripcion = descripcion;
    }
    public void setFecha(String Fecha) {
        this.fecha = fecha;
    }
    public void setTitulo(String Titulo) {
        this.titulo = titulo;
    }
    public void setTopico(String Topico) {
        this.topico = topico;
    }
    
    public boolean registrarProblema() throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("insert Into Problema values(?,?,?,?,?,?)");
        pstm.setInt(1, idCategoria);
        pstm.setInt(2, idUsuario);
        pstm.setString(3, descripcion);
        pstm.setString(4, fecha);
        pstm.setString(5, titulo);
        pstm.setString(6, topico);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
    }
    
    public boolean editarProblema(int idUsuario, int idProblema) throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("update problema set idCategoria = ?, descripcion = ?, titulo = ?, topico = ? where idUsuario = ? and idProblema = ?");
        pstm.setInt(1, idCategoria);
        pstm.setString(2, descripcion);
        pstm.setString(3, titulo);
        pstm.setString(4, topico);
        pstm.setInt(5, idUsuario);
        pstm.setInt(6, idProblema);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
    }
    
    public boolean borrarProblema(int idUsuario, int idProblema) throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("delete from Problema where idUsuario = ? and idProblema = ?");
        pstm.setInt(1, idUsuario);
        pstm.setInt(2, idProblema);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
        
    }   
}
