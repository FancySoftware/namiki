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
public class Aporte {
    
    private int idAporte;
    private int idProblema;
    private int idUsuario;
    private String contacto;
    private String costo;
    private int elegido;
    private String fecha;
    private String solucion;
    
    public int getidAporte() {
        return idAporte;
    }
    public int getidProblema() {
        return idProblema;
    }
    public int getidUsuario() {
        return idUsuario;
    }
    public String getContacto() {
        return contacto;
    }
    public String getCosto() {
        return costo;
    }
    public int getElegido() {
        return elegido;
    }
    public String getFecha() {
        return fecha;
    }
    public String getSolucion() {
        return solucion;
    }
    
    public void setidAporte(int idAporte) {
        this.idAporte = idAporte;
    }
    public void setidProblema(int idProblema) {
        this.idProblema = idProblema;
    }
    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setCosto(String costo) {
        this.costo = costo;
    }
    public void setElegido(int elegido) {
        this.elegido = elegido;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
  public boolean registrarAporte() throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("insert Into Aporte values(?,?,?,?,?,?,?)");
        pstm.setInt(1, idProblema);
        pstm.setInt(2, idUsuario);
        pstm.setString(3, contacto);
        pstm.setString(4, costo);
        pstm.setInt(5, elegido);
        pstm.setString(6, fecha);
        pstm.setString(7, solucion);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
  }

  public boolean editarAporte(int idUsuario, int idProblema) throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("update aporte set idPrblema = ?, contacto = ?, costo = ?, elegido = ?, fecha = ?, solucion = ? where idUsuario = ? and idProblema = ?");
        pstm.setString(1, contacto);
        pstm.setString(2, costo);
        pstm.setInt(3, elegido);
        pstm.setString(4, solucion);
        pstm.setInt(5, idUsuario);
        pstm.setInt(6, idProblema);
        resultado = pstm.executeUpdate();
        if (resultado == 1)
            retorno = true;
        if (con != null)
            con.close();
        return retorno;
  }

  public boolean borrarAporte(int idUsuario, int idProblema) throws SQLException,ClassNotFoundException {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Namiki?\" +\n" + "\"user=&password=");
        pstm = con.prepareStatement("delete from Aporte where idUsuario = ? and idProblema = ?");
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
