/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
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
//        PrintWriter out = response.getWriter();
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
                    int categoria = (request.getParameter("categoria").equalsIgnoreCase("") || request.getParameter("categoria") == null) ? -1 : Integer.parseInt(request.getParameter("categoria"));
                    if(usuario_registro != null && nombre != null && password_registro != null
                            && correo != null && telefono != null && categoria > -1 && categoria < 6) {
                        java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime());
                        registrarUsuario(usuario_registro, password_registro, categoria, nombre, telefono, correo, fecha);
                        UsuarioBD usuariobd = new UsuarioBD();
                        String[] datos = usuariobd.getDatos(usuario_registro);
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("username", usuario_registro);
                        sesion.setAttribute("idusuario", datos[0]);
                        sesion.setAttribute("type", new Integer(categoria));
                        response.sendRedirect("perfil.jsp");
                    } else {
                        if(usuario_registro == null || usuario_registro.length() < 6) {
                            answer += "Usuario inválido, almenos 6 caracteres<br />";
                        }
                        if(nombre == null || nombre.length() < 6) {
                            answer += "Nombre inválido, almenos 6 caracteres<br />";
                        }
                        if(password_registro == null || password_registro.length() < 4) {
                            answer += "Password inválido, almenos 4 caracteres<br />";
                        }
                        if(correo == null || correo.length() < 7 || correo.indexOf("@") == -1) {
                            answer += "Correo inválido<br />";
                        }
                        if(telefono == null || telefono.length() < 8) {
                            answer += "Telefono inválido, almenos 8 números<br />";
                        }
                        if(categoria < 0 || categoria > 6) {
                            answer += "Categoría inválida, Seleccione una opción<br />";
                        }
                        request.setAttribute("errorMessage", answer);
                        request.getRequestDispatcher("/registrar.jsp").forward(request, response);
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
//                                answer = "usuario= " + usuario + ";password= "+password+";categoria= "+datos[3];
                                System.err.println(answer);
                                HttpSession sesion = request.getSession();
                                sesion.setAttribute("usuario", usuario);
                                sesion.setAttribute("idusuario", datos[0]);
                                sesion.setAttribute("type", datos[3]);
//                                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
//                                rd.forward(request, response);
                                response.sendRedirect("perfil.jsp");
                                return;
                            }
                        }
                    }
                    request.setAttribute("errorMessage", answer);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } finally {            
            
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
