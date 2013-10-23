/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.Problema.getDescripcion;
import static controlador.Problema.getTopico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AporteBD;
import modelo.ProblemaBD;

/**
 *
 * @author Jules
 * Clase Aporte
 */
public class Aporte extends HttpServlet {
    
    private static int idAporte;
    private static int idProblema;
    private static int idUsuario;
    private static String contacto;
    private static String costo;
    private static int elegido;
    private static Date fecha;
    private static String solucion;
    
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
    public static String getContacto() {
        return contacto;
    }
    public static String getCosto() {
        return costo;
    }
    public int getElegido() {
        return elegido;
    }
    public Date getFecha() {
        return fecha;
    }
    public static String getSolucion() {
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
      
        AporteBD aporte = new AporteBD();
        aporte.guardar(idAporte, idUsuario, idProblema, solucion, costo, obtenerFecha(), contacto, elegido);
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
  public void editarAporte(int idAporte,int idUsuario,int idProblema, String solucion, String costo,String contacto,int elegido) {
        
      AporteBD aporte = new AporteBD();
      aporte.getDatos(idAporte);
      aporte.editar(idAporte, idUsuario, idProblema, solucion, costo, obtenerFecha(), contacto, elegido);
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
  public static void borrarAporte(int idAporte) {
        
      AporteBD aporte = new AporteBD();
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
  
  public static boolean getDatos(int idaporte) {
      AporteBD problema = new AporteBD();
      String[][] datos= problema.getDatos(idaporte);
      if(datos == null) {
          return false;
      }
                    Aporte.idAporte = Integer.parseInt(datos[0][0]);
                    Aporte.idProblema = Integer.parseInt( datos[0][1]);
                    Aporte.idUsuario = Integer.parseInt(datos[0][2]);
                    
                    Aporte.solucion =  datos[0][3]; 
                    Aporte.costo = datos[0][4];
                    try {
                    Aporte.fecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(datos[0][5]);
                    } catch(ParseException e){
                        System.out.println("Error en la fecha");
                    } 
                    Aporte.costo = datos[0][6];
                    Aporte.elegido = Integer.parseInt(datos[0][7]);
      return true;
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
            switch(caso){
                    case 1:
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
            break;
                 case 2: //editar
                     String idprob =request.getParameter("idProblema");
                   out.println(idprob);
                   out.println("Caso de editar");
                   String solucion_nvo= request.getParameter("solucion");
                   String costo_nvo = request.getParameter("costo");
                   String contacto_nvo = request.getParameter("contacto");
                   
    ;
                   if(solucion_nvo.length() == 0 && costo_nvo.length() ==0 && contacto_nvo.length() ==0){
                       out.println("ERROR EN LOS DATOS");
                   } else if(solucion_nvo.length() == 0) {
                       out.println("ERROR solucion obligatorio");
                   } else if(costo_nvo.length() == 0){
                       out.println("ERROR costo Vacia");
                   } else if(contacto_nvo.length() == 0){
                       out.println("ERROR CONTACTO INVALIDO");
                   } else {
                       System.out.println("\n Editando problema");                    
                       editarAporte(idAporte,idProblema,idUsuario,solucion_nvo,costo_nvo,contacto_nvo,elegido);
                       System.out.println("SE LOGRO EDITAR");
                       response.sendRedirect("perfil.jsp");
                   }
                     
                 break;
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
