/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Administrador
 */
public class Problema {
    
    Integer idProblema;
    Integer idCategoria;
    Integer idUsuario;
    String descripcion;
    String fecha;
    String titulo;
    String topico;
    
    public Problema(Integer idProblema, Integer idCategoria, Integer idUsuario,
                String fecha, String titulo, String topico) {
        
        }
    
    public Integer getidProblema() {
        return this.idProblema;
    }
    public Integer getidCategoria() {
        return this.idCategoria;
    }
    public Integer getidUsuario() {
        return this.idUsuario;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getFecha() {
        return this.fecha;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getTopico() {
        return this.topico;
    }
    
    public void setidProblema() {
        idProblema = idProblema;
    }
    public void setidCategoria() {
        idCategoria = idCategoria;
    }
    public void setidUsuario() {
        idUsuario = idUsuario;
    }
    public void setDescripcion() {
        descripcion = descripcion;
    }
    public void setFecha() {
        fecha = fecha;
    }
    public void setTitulo() {
        titulo = titulo;
    }
    public void setTopico() {
        topico = topico;
    }
    
    public void registrarProblema() {
        
    }
    
    public void editarProblema() {
        
    }
    
    public void borrarProblema() {
        
    }
}
