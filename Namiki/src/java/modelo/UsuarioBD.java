package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
          String nuevo = "INSERT INTO usuario "
                  + "(usuario,contrasena, idcategoria, nombre, telefono, correo, fecha) "
                  + "VALUES (?,?,?,?,?,?,?)";
          PreparedStatement pstmt = base.getConexion().prepareStatement(nuevo);
          pstmt.setString(1, usuario);
          pstmt.setString(2, password);
          if(categoria == 0) {
              pstmt.setNull(3, java.sql.Types.INTEGER);
          } else {
              pstmt.setInt(3, categoria);
          }
          pstmt.setString(4, nombre);
          pstmt.setString(5, telefono);
          pstmt.setString(6, correo);
          pstmt.setDate(7, fechaNacimiento);
          pstmt.execute();
      }catch(Exception e){
          System.err.println("error guardando?? -_------ -> "+ e.getClass());
      }
  }
  public void eliminar(int idUsuario) {
      try{
          base.conectar();
          String eliminar = "DELETE FROM usuario WHERE idusuario = " + idUsuario;
          base.query(eliminar);
      }catch(Exception e){   
      }
  }

    public String[] getDatos(String usuario) {
        String[] result = new String[8];
        try{
            base.conectar();
            ResultSet resultset = base.queryRS("SELECT * FROM usuario WHERE usuario = '" + usuario + "'");
            if(!resultset.next()) {
                return null;
            } else {
                result[0] = resultset.getString("idusuario");
                result[1] = resultset.getString("usuario");
                result[2] = resultset.getString("contrasena");
                result[3] = resultset.getString("idcategoria");
                result[4] = resultset.getString("nombre");
                result[5] = resultset.getString("telefono");
                result[6] = resultset.getString("correo");
                result[7] = resultset.getString("fecha");
            }
        } catch(Exception e){
            System.err.println("ERROR al obtener los datos del usuario " + usuario);
        }
        return result;
    }
  
  public void salir() {
  
  }
}