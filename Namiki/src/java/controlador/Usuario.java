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
import modelo.UsuarioBD;

/**
 *
 * @author Edd
 */
public class Usuario extends HttpServlet {
    
  private int idUsuario;
  private String nombre;
  private int categoria;
  private String telefono;
  private String correo;
  private Date fechaNacimiento;
  private String usuario;
  private String password;
  
//  public Usuario(int idUsuario, String nombre, int categoria, String telefono, 
//          String usuario, String correo, Date fechaNacimiento, String password) {
//      
//  }
  
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

    public void registrarUsuario(String nombre, int categoria, String telefono, String usuario,
          String correo, Date fechaNacimiento, String password) {
        
         UsuarioBD usuario1 = new UsuarioBD(idUsuario, nombre, categoria, telefono, usuario, correo, fechaNacimiento, password);
         usuario1.guardar(idUsuario, nombre, categoria, telefono, usuario, correo, fechaNacimiento, password);
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
            int caso = Integer.parseInt(request.getParameter("form_sumbitted"));
            /*
             * 1 - Registro
             * 2 - Inicio Sesión
             */
            switch(caso) {
                case 1:
                    String usuario = request.getParameter("usuario");
                    String nombre = request.getParameter("nombre");
                    String password = request.getParameter("password");
                    String correo = request.getParameter("correo");
                    String telefono = request.getParameter("telefono");
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    if(usuario != null && nombre != null && password != null
                            && correo != null && telefono != null && categoria > 0) {
                        
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String answer;
            if(usuario == null || password == null) {
                answer = "Usuario o contraseña invalidos";
            } else {
                answer = "usuario= " + usuario + ";password= "+password;
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
