package modelo;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class UsuarioBD {
    
  public int idUsuario;
  public String nombre;
  public int categoria;
  public String telefono;
  public String usuario;
  public String correo;
  public Date fechaNacimiento;
  public String password;
  public BaseDatos base;

  public UsuarioBD(){
      this.base = new BaseDatos();
  }
  
  public UsuarioBD(int idUsuario, String nombre, int categoria,String telefono,
          String usuario,String correo,Date fecha,String password){
      this.idUsuario = idUsuario;
      this.nombre = nombre;
      this.categoria = categoria;
      this.telefono = telefono;
      this.usuario=usuario;
      this.correo = correo;
      this.fechaNacimiento = fecha;
      this.password = password;
      this.base = new BaseDatos();
  }
  
  public void guardar(String usuario, String password, int categoria, String nombre, String telefono, 
          String correo, Date fechaNacimiento) {
      try{
          base.conectar();
          String nuevo = "INSER INTO usario "
                  + "(usuario,contasena, idcategoria, nombre, telefono, correo, fecha) "
                  + "VALUES"
                  + "("+usuario+","+password+","+categoria+","+nombre+","+telefono+","+correo+","+fechaNacimiento+")";
          base.query(nuevo);
      }catch(Exception e){
          System.err.println("error guardando?? -_-");
      }
  }
  public void eliminar(int idUsuario) {
      try{
          base.conectar();
          String eliminar = "DELETE FROM aporte WHERE idusuario = " + idUsuario;
          base.query(eliminar);
      }catch(Exception e){   
      }
  }

  public void getDatos(int idUsuario) {
         try{
           base.conectar();
           String consulta = "SELECT * FROM aporte where idaporte =" +idUsuario;
           base.query(consulta);
       }catch(Exception error){
       } 
  }
  public void salir() {
  
  }
}
