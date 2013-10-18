/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Date;
import java.util.*;
import modelo.UsuarioBD;
import modelo.AporteBD;
import modelo.ProblemaBD;
import modelo.BaseDatos;
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
  private Date fechaNacimiento;
  private String usuario;
  private String password;
  
  public Usuario(int idUsuario, String nombre, int categoria, String telefono, 
          String usuario, String correo, Date fechaNacimiento, String password) {
      
  }
  
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
     public Date getFecha() {
        return fechaNacimiento;
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
     public void setFecha(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
     }
     public void setUsuario(String usuario) {
        this.usuario = usuario;
     }
     public void setPassword(String password) {
         this.password = password;
     }

    public void getProblemas(int idUsuario) {
         ProblemaBD problema = new ProblemaBD();
         problema.getDatos(idUsuario); //Revisar
    }

    public void getAportes(int idUsuario) {
         AporteBD aporte = new AporteBD();
         aporte.getDatos(idUsuario); //Revisar
    }

    public void entrarSistema(String nom_usuario, String password) {
         
    }

    public void cerrarSistema() {
        UsuarioBD usuario1 = new UsuarioBD();
        usuario1.salir();
    }

    public void registrarUsuario(int idUsuario, String nombre, int categoria, String telefono, String usuario,
          String correo, Date fechaNacimiento, String password) {
        
         UsuarioBD usuario1 = new UsuarioBD(idUsuario, nombre, categoria, telefono, usuario, correo, fechaNacimiento, password);
         usuario1.guardar(idUsuario, nombre, categoria, telefono, usuario, correo, fechaNacimiento, password);
    }

}