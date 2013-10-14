/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.Date;
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
    private Date fecha;
    private String solucion;
    
public Aporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, String fecha, String solucion) {
    
}
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
    public Date getFecha() {
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
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
  public void registrarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
      
        AporteBD aporte = new AporteBD(idAporte, idProblema, idUsuario, contacto, costo, elegido, fecha, solucion);
        aporte.guardar(idAporte, idProblema, idUsuario, contacto, costo, elegido, fecha, solucion);
  }

  public void editarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idProblema, idUsuario, contacto, costo, elegido, fecha, solucion);
      aporte.getDatos(idAporte);
      aporte.editar(idAporte, idProblema, idUsuario, contacto, costo, elegido, fecha, solucion);
  }

  public void borrarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idProblema, idUsuario, contacto, costo, elegido, fecha, solucion);
      aporte.get(idAporte);
      aporte.eliminar();
  }
}
