/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AporteBD;
import modelo.ProblemaBD;

/**
 *
 * @author Jules
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
    
  public void registrarAporte(int idAporte, int idUsuario, int idProblema, String solucion, 
        String costo, Date fecha, String contacto, int elegido) {
      
        AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
        aporte.guardar(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
  }

  public void editarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
      aporte.getDatos(idAporte);
      aporte.editar(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
  }

  public void borrarAporte(int idAporte, int idProblema, int idUsuario, String contacto, 
        String costo, int elegido, Date fecha, String solucion) {
        
      AporteBD aporte = new AporteBD(idAporte, idUsuario, idProblema, solucion, costo, fecha, contacto, elegido);
      aporte.getDatos(idAporte);
      aporte.eliminar(idAporte);
  }
  public static String mostrarProblemas() {
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
  
  
    public static String mostrarProblemas(int idUsuario) {
      AporteBD aporte = new AporteBD();
      String[][] aportes = aporte.tablaUsr(idUsuario);
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Aporte_</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Aporte_ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
