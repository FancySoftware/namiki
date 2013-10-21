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
import javax.servlet.http.HttpSession;
import modelo.AporteBD;
import modelo.ProblemaBD;
import modelo.UsuarioBD;

/**
 *
 * @author Jules
 * Clase Usuario
 */
public class Usuario extends HttpServlet {


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

    public void registrarUsuario(String usuario, String password, int categoria, String nombre, String telefono, 
          String correo, Date fechaNacimiento) {
        
         UsuarioBD usuario1 = new UsuarioBD();
         usuario1.guardar(usuario, password, categoria, nombre, telefono, correo, fechaNacimiento);
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
            String answer = "";
            int caso = Integer.parseInt(request.getParameter("form_sumbitted"));
            /*
             * 1 - Registro
             * 2 - Inicio Sesión
             */
            switch(caso) {
                case 1:
                    String usuario_registro = request.getParameter("usuario");
                    String nombre = request.getParameter("nombre");
                    String password_registro = request.getParameter("password");
                    String correo = request.getParameter("correo");
                    String telefono = request.getParameter("telefono");
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    if(usuario_registro != null && nombre != null && password_registro != null
                            && correo != null && telefono != null && categoria > -1 && categoria < 6) {
                        java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime());
                        registrarUsuario(usuario_registro, password_registro, categoria, nombre, telefono, correo, fecha);
                        HttpSession session = request.getSession();
                        session.setAttribute("username", usuario_registro);
                        session.setAttribute("type", new Integer(categoria));
                        answer = "Success";
                    } else {
                        answer = "Failure";
                    }
                    break;
                case 2:
                    String usuario = request.getParameter("usuario");
                    String password = request.getParameter("password");
                    if(usuario == null || password == null) {
                        answer = "Usuario o contraseña invalidos";
                    } else {
                        UsuarioBD usuariobd = new UsuarioBD();
                        String[] datos = usuariobd.getDatos(usuario);
                        if(datos == null) {
                            answer = "El usuario no existe";
                        } else {
                            if(!password.equalsIgnoreCase(datos[2])) {
                                answer = "Contraseña invalida";
                            } else {
                                answer = "usuario= " + usuario + ";password= "+password+";categoria= "+datos[3];
                                System.err.println(answer);
                                HttpSession session = request.getSession();
                                session.setAttribute("username", usuario);
                                session.setAttribute("type", datos[3]);
                            }
                        }
                    }
                    break;
                default:
                    break;
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Response at " + request.getContextPath() + "</h1>");
            out.println("<p>"+answer+"</p>");
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
