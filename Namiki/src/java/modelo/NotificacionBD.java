/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
          String eliminar = "DELETE FROM aporte WHERE idusuario = " + idNotificacion;
          
          base.query(eliminar);
      }catch(Exception e){   
      }
  }

  public void getNotificaciones(int idNotificacion) {
       try{
           base.conectar();
           String consulta = "SELECT * FROM aporte where idaporte =" +idNotificacion;
           base.query(consulta);
       }catch(Exception error){
       } 
  }
}
