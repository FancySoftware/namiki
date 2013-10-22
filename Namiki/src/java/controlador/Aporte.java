/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AporteBD;

/**
 *
 * @author Jules
 * Clase Aporte
 */
public class Aporte extends HttpServlet {
    
    private int idAporte;
    private int idProblema;
    private int idUsuario;
    private String contacto;
    private String costo;
    private int elegido;
    private Date fecha;
    private String solucion;
    
// Contructor de la clase Aporte 
public Aporte(){
    
}

/**
 * @param null
 * @return int
 * @return String
 * get's de la clase Aporte
 */
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
    
/**
 * @param int 
 * @param String
 * @return void
 * set's de la clase Aporte
 */
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
    
/**
 * @param idUsuario
 * @param idProblema
 * @param solucion
 * @param costo
 * @param fecha
 * @param contacto
 * @param elegido 
 * @return void
 * Metodo registrarAporte que crea un objeto AporteBD aporte y guarda el aporte
 * creado por el usuario.
 */
  public void registrarAporte(int idUsuario, int idProblema, String solucion, 
        String costo, Date fecha, String contacto, int elegido) {
      
        AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
        aporte.guardar(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
  }

/**
 * @param idAporte
 * @param idProblema
 * @param idUsuario
 * @param contacto
 * @param costo
 * @param elegido
 * @param fecha
 * @param solucion 
 * @return void
 * Metodo editarAporte que crea un objeto AporteBD aporte, pide los datos del
 * aporte elegido y guarda los cambios.
 */
  public void editarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
      aporte.getDatos(idAporte);
      aporte.editar(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
  }

/**
 * @param idAporte
 * @param idProblema
 * @param idUsuario
 * @param contacto
 * @param costo
 * @param elegido
 * @param fecha
 * @param solucion 
 * @retun void
 * Metodo borrarAporte que crea un objeto AporteBD aporte, pide los datos del
 * aporte elegido y los elimina.
 */
  public void borrarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
      aporte.getDatos(idAporte);
      aporte.eliminar(idAporte);
  }
  
  public static String mostrarAportes() {
      AporteBD aporte = new AporteBD();
      String[][] aportes = aporte.tablaCompleta();
      String res = "";
      for (int i = 0; i < aportes.length; i++) {
          res += "<tr>";
            for (int j = 0; j < 8; j++) {
                res += "<td>" + aportes[i][j] + "</td>";
            }
          res += "</tr>";
      }
      return res;
  }
  
  public static String mostrarAportesUsr(int idUsuario) {
      AporteBD aporte = new AporteBD();
      String[][] aportes = aporte.tablaUsr(idUsuario);
      String res = "";
      for (int i = 0; i < aportes.length; i++) {
          res += "<tr>";
            for (int j = 1; j < 8; j++) {
                res += "<td>" + aportes[i][j] + "</td>";
            }
            res+="<td><div class=\"dropdown\">";
            res+="<a data-toggle=\"dropdown\" href=\"#\" class=\"btn btn-primary\">Acciones <span class=\"caret\"></span></a>";
            res+="<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dLabel\">";
            res+="<li><a href=\"FormularioAporteProblemaIH.jsp?idaporte=" 
                    + aportes[i][0] + "\">Editar</a></li>"; 
            res+="<li><a href=\"mostrarAporteIH.jsp?borrar=" 
                    + aportes[i][0] + "\">Borrar</a></li>";
            res+="</ul></div></td>";
          res += "</tr>";
      }
      return res;
  }
    
    
/**
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
          String solucion = request.getParameter("solucion");
            String costo = request.getParameter("costo");
            String contacto= request.getParameter("contacto");
            if(solucion.length() ==0 && costo.length() ==0 && contacto.length() ==0){
            out.println("ERROR EN LOS DATOS");
            } else if(solucion.length() == 0) {
                out.println("ERROR titulo obligatorio");
            } else if(costo.length() == 0){
                out.println("ERROR Descripcion Vacia");
            } else if(contacto.length() == 0){
                out.println("Seleciona una categoria");
            } else {
                out.println("\n Guardando aportes");
            //Prueba con id de usuario y categoria inventada.
                registrarAporte(1000,1000,solucion,costo, obtenerFecha(),contacto,elegido);
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
