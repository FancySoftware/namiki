/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.BaseDatos;
import modelo.NotificacionBD;

/**
 * @author Namiki
 * 
 */
public class Notificacion extends HttpServlet {
    
    public String mensaje;
    public int idUsuario;
    private String email;
    private static Properties properties = new Properties();
    private Session sessionMail;

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
    public String getEmail(){
        return email;
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
    public void setEmail(String email){
        this.email = email;
    }
    public String[] desplegarMensaje(String idUsuario) {
        System.out.println("usuario:"+idUsuario);
    NotificacionBD notif = new NotificacionBD();
    String[] res = notif.getNotificaciones(idUsuario);
    return res;
  }

    public static String getDatos(String idAporte) throws SQLException{
        int idaporte = Integer.parseInt(idAporte);
        BaseDatos base = new BaseDatos();
        String consulta = "SELECT * FROM usuario u, aporte a WHERE u.idusuario = a.idusuario AND idaporte = " + idaporte;
        ResultSet res = base.queryRS(consulta);
        res.next();
        String rs = res.getString("correo");
        return rs;
    }
            
    public void enviarCorreo(){
        initMail();
        sendEmail();
    }
    
    private  void initMail(){
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.mail.sender", "nancyarlette.03@gmail.com");
        properties.put("mail.smtp.user","nancyarlette.03@gmail.com");
        properties.put("mail.smtp.auth","true");
        
        sessionMail = Session.getDefaultInstance(properties);
        sessionMail.setDebug(true);
    }
    public void sendEmail(){
        initMail();
        try{
        MimeMessage message;
            message = new MimeMessage(sessionMail);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("Namiki");
            message.setText("Notificacion Namiki. Uno de tus aportes fue seleccionado");
         
            Transport t = sessionMail.getTransport("smtp");
            t.connect((String)properties.get("mail.stmp.user"),"ingsoftNamiki");
            t.sendMessage(message, message.getAllRecipients());
            t.close(); 
        }catch(MessagingException ex){
            return;
        }
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
