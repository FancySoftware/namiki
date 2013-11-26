/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class NotificacionBD {
  
  public int idNotificacion;
  public int idUsuario;
  public int leido;
  public String mensaje;
  public BaseDatos base;
  
  
  public NotificacionBD(){
    this.base = new BaseDatos();
}
  
  public NotificacionBD(int idNotificacion,int idUsuario,int leido,String mensaje){
      this.idNotificacion = idNotificacion;
      this.idUsuario = idUsuario;
      this.leido = leido;
      this.mensaje = mensaje;
      this.base = new BaseDatos();
  }
  public void guardar(int idNotificacion,int idUsuario,int leido,String mensaje) {
      try{
         base.conectar();
         String notificacion= "INSERT INTO notificacion (idnotificacion,idusuario,mensaje)VALUES('"+idNotificacion+"','"
                 +idUsuario+"','"+leido+"','"+ mensaje+"')";
         base.query(notificacion);
      }catch(Exception e){
      }
  }

  public void eliminar(int idNotificacion) {
         try{
          base.conectar();
          String eliminar = "DELETE FROM notificacion WHERE idnotificacion = " + idNotificacion;
          
          base.query(eliminar);
      }catch(Exception e){   
      }
  }

  
 public String[] getNotificaciones(int idUsuario){
   base.conectar();
        int numRows = 0;
        ResultSet cont = base.queryRS("SELECT COUNT(*) numRows FROM notificacion"
                + "WHERE idUsuario = " + idUsuario);
        try {
            if(cont.next()){
                numRows = cont.getInt("numRows");
            } else {
                System.out.println("Error al contar los registros");
                numRows = 0;
            }
        } catch (SQLException e) {
            System.err.println("notificacionDB");
        }
        System.out.println(numRows);
        ResultSet rs = base.queryRS("SELECT * FROM notificacion"
                + "WHERE idusuario = "+ idUsuario);
        String[] res = new String[numRows];
        int actual = 0;
        try {
            while(rs.next()){
                res[actual] = rs.getString("mensaje");
                actual++;
            }
        } catch (SQLException e) {
            System.err.println("mensajesDB");
        }
        return res;
}
}
