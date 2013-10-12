/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    
  public void registrarAporte() {
  }

  public void editarAporte() {
  }

  public void borrarAporte() {
  }
}
