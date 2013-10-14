package modelo;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class AporteBD {
   public int idAporte;
   public int idUsuario;
   public int idProblema;
   public String solucion;
   public String costo;
   public Date fecha;
   public String contacto;
   public int elegido;
   public BaseDatos base;
 
   public void guardar(int idAporte,int idUsuario, int idProblema,String solucion,
                          String costo,Date fecha,String contacto,Boolean elegido){
       try{
           base.conectar();
          // int id_Aporte = Integer.parseInt(this.txtClave.getText());
       }catch(Exception error){
           
       }
   }
   
   public void eliminar(){
       
   }
   public void getDatos(){
       
   }
   public void editar(){
       
   }
}