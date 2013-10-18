package controlador;

import java.sql.Date;
import modelo.ProblemaBD;
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
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTopico(String topico) {
        this.topico = topico;
    }
    
    public void registrarProblema(int idProblema, int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
      
        ProblemaBD problema = new ProblemaBD(idProblema, idCategoria, idUsuario, descripcion, fecha, titulo, topico);
        problema.guardar(idProblema, idCategoria, idUsuario, descripcion, fecha, titulo, topico);
  }

  public void editarProblema(int idProblema, int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
        
      ProblemaBD problema = new ProblemaBD(idProblema, idCategoria, idUsuario, descripcion, fecha, titulo, topico);
      problema.getDatos(idProblema);
      problema.editar(idProblema, idCategoria, idUsuario, descripcion, fecha, titulo, topico);
  }

  public void borrarProblema(int idProblema, int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
        
      ProblemaBD problema = new ProblemaBD(idProblema, idCategoria, idUsuario, descripcion, fecha, titulo, topico);
      problema.getDatos(idProblema);
      problema.eliminar(idProblema);
  }
}
