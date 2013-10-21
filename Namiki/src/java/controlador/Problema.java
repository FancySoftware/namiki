/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProblemaBD;

/**
 *
 * @author Jules
 * Clase Problema
 */
public class Problema extends HttpServlet {
    
    private int idProblema;
    private int idCategoria;
    private int idUsuario;
    private String descripcion;
    private Date fecha;
    private String titulo;
    private String topico;
    
// Contructor de la clase Problema
public Problema(){
    
}

/**
 * @param null
 * @return int
 * @return String
 * get's de la clase Problema
 */
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
    public Date getFecha() {
        return fecha;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getTopico() {
        return topico;
    }

/**
 * @param int
 * @param String
 * @retun void
 * set's de la clase Problema
 */
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
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTopico(String topico) {
        this.topico = topico;
    }
    
/**
 * @param idProblema
 * @param idCategoria
 * @param idUsuario
 * @param descripcion
 * @param titulo
 * @param fecha
 * @param topico
 * @return void
 * Metodo registrarProblema que crea un objeto ProblemaBD problema y guarda el 
 * problema creado por el usuario.
 */
  public void registrarProblema(int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
      
        ProblemaBD problema = new ProblemaBD();
        problema.guardar(idCategoria, idUsuario, descripcion, obtenerFecha(), titulo, topico);
  }
  
 /*
  * Metodo auxiliar para obtener un tipo de la clase sql.Date y pasarlo a la base.
  */
  private java.sql.Date obtenerFecha(){
    java.util.Calendar cal = Calendar.getInstance();
    java.util.Date utilDate = new java.util.Date(); // your util date
    cal.setTime(utilDate);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);    
    java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime()); // your sql date
    return sqlDate;
  }
/**
 * @param idProblema
 * @param idCategoria
 * @param idUsuario
 * @param descripcion
 * @param titulo
 * @param fecha
 * @param topico
 * @return void
 * Metodo editarProblema que crea un objeto ProblemaBD problema, pide los datos del
 * problema elegido y guarda los cambios.
 */
  public void editarProblema(int idProblema, int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
        
      ProblemaBD problema = new ProblemaBD();
      problema.getDatos(idProblema);
      problema.editar(idProblema, idCategoria, idUsuario, descripcion, obtenerFecha(), titulo, topico);
  }
  
/**
 * @param idProblema
 * @param idCategoria
 * @param idUsuario
 * @param descripcion
 * @param titulo
 * @param fecha
 * @param topico 
 * @return void
 * Metodo borrarProblema que crea un objeto ProblemaBD problema, pide los datos del
 * problema elegido y los elimina.
 */
  public void borrarProblema(int idProblema, int idCategoria, int idUsuario, String descripcion, 
        String titulo, Date fecha, String topico) {
        
      ProblemaBD problema = new ProblemaBD(idProblema, idCategoria, idUsuario, descripcion, obtenerFecha(), titulo, topico);
      problema.getDatos(idProblema);
      problema.eliminar(idProblema);
  }

  public static String mostrarProblemas() {
      ProblemaBD problema = new ProblemaBD();
      String[][] problemas = problema.tablaCompleta();
      String res = "";
      for (int i = 0; i < problemas.length; i++) {
          res += "<tr>";
            for (int j = 0; j < 7; j++) {
                res += "<td>" + problemas[i][j] + "</td>";
            }
          res += "</tr>";
      }
      return res;
  }

  public static String mostrarProblemasUsr(String idusuario) {
      ProblemaBD problema = new ProblemaBD();
      String[][] problemas = problema.tablaUsr(idusuario);
      String res = "";
      for (int i = 0; i < problemas.length; i++) {
          res += "<tr>";
            for (int j = 1; j < 7; j++) {
                res += "<td>" + problemas[i][j] + "</td>";
            }
            res+="<td><div class=\"dropdown\">";
            res+="<a data-toggle=\"dropdown\" href=\"#\" class=\"btn btn-primary\">Acciones <span class=\"caret\"></span></a>";
            res+="<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dLabel\">";
            res+="<li><a href=\"FormularioAporteProblema.jsp?idproblema=" 
                    + problemas[i][0] + "\">Editar</a></li>"; 
            res+="<li><a href=\"mostrarProblemaIH.jsp?borrar=" 
                    + problemas[i][0] + "\">Borrar</a></li>";
            res+="</ul></div></td>";
          res += "</tr>";
      }
      return res;
  }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int caso= Integer.parseInt(request.getParameter("form_sumbitted"));
            out.println("Caso " +caso );
            
            switch(caso){
                    case 1:
                        //REGISTRANDO PROBLEMA
            String titulo = request.getParameter("titulo");
            String topico = request.getParameter("topico");
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            String descripcion = request.getParameter("descripcion");
            if(titulo.length() ==0 && topico.length() ==0 && descripcion.length() ==0 && categoria==0){
            out.println("ERROR EN LOS DATOS");
            } else if(titulo.length() == 0) {
                out.println("ERROR titulo obligatorio");
            } else if(descripcion.length() == 0){
                out.println("ERROR Descripcion Vacia");
            } else if(categoria == 0){
                out.println("Seleciona una categoria");
            } else {
                out.println("\n Guardando problemas");
                out.println("Datos " + titulo +" "+ topico + " "+ categoria +" "+ descripcion);
            //Prueba con id de usuario y categoria inventada.
                registrarProblema(1,1,descripcion,titulo, obtenerFecha(),topico);
            }            
                        break;
                    case 2:
                        //MOSTRAR PROBLEMA
                        break;
                    default:
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
