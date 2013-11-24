/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.NotificacionBD;

/**
 * @author Namiki
 * Clase Notificacion
 */
public class Notificacion extends HttpServlet {
    
    public String mensaje;
    public int idUsuario;

//Constructor de la clase Notificacion
public Notificacion() {
    
}

/**
 * @param void
 * @return int
 * @return String
 * get's de la clase Notificacion
 */
    public String getMensaje() {
        return mensaje;
    }
    public int getidUsuario() {
        return idUsuario;
    }

/**
 * @param tipo 
 * @return int
 * @return String
 * set's de la clase Notificacion
 */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

public void desplegarMensaje(int idUusario) {
    NotificacionBD notif = new NotificacionBD();
    notif.getNotificaciones(idUsuario);
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
            out.println("<title>Servlet Notificacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Notificacion at " + request.getContextPath() + "</h1>");
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
