package modelo;

import java.sql.Date;

/**
 * @author Administrador
 */
public class ProblemaBD {
    private int idProblema;
    private int idCategoria;
    private int idUsuario;
    public String descripcion;
    public Date fecha;
    public String titulo;
    public String topico;
    public BaseDatos base;
 
   
   public ProblemaBD() {
       this.base = new BaseDatos();
   }
   
   public ProblemaBD(int id_problema,int id_categoria,int id_usuario,String descripcion, 
           Date fecha,String titulo, String topico) {
       this.idProblema = id_problema;
       this.idCategoria = id_categoria;
       this.idUsuario = id_usuario;
       this.descripcion = descripcion;
       this.fecha = fecha;
       this.titulo = titulo;
       this.topico = topico;
       this.base = new BaseDatos();
   }
   
   public void guardar(int idProblema,int idCategoria, int idUsuario, 
           String descripcion,Date fecha,String titulo, String topico){
       try{
           base.conectar();
           String usuario = "INSERT INTO aporte VALUES("+idProblema+","
                                    +idCategoria+","+idUsuario+","+descripcion+","
                                    +fecha+","+titulo+","+topico+")";
           base.query(usuario);
       }catch(Exception error){     
    }
   }
   public void eliminar(int idProblema){
       try{
           base.conectar();
           String eliminar = "DELETE FROM aporte where idaporte ="+idProblema;
           base.query(eliminar);
       }catch(Exception error){
           
       }
   }

   public void getDatos(int idProblema){
       try{
           base.conectar();
           String consulta = "SELECT * FROM aporte where idaporte =" +idProblema;
           base.query(consulta);
       }catch(Exception error){
       } 
   }
   
   public void editar(int idProblema,int idCategoria, int idUsuario, 
           String descripcion,Date fecha,String titulo, String topico){
       try{
           base.conectar();
           String update = "UPDATE usuario SET descripcion "+descripcion+"WHERE idproblema = " +idProblema
                   + " and idusuario = "+idUsuario+ " and idcategoria = " +idCategoria 
                   + " and descripcion = "+descripcion+ " and fecha = " 
                   +fecha+ " and titulo = "+titulo+ "and topico = " +topico;
           base.query(update);
       }catch(Exception error){
       }
   }
   
}