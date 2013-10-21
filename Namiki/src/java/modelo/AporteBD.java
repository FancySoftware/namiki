package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
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
 
   
   public AporteBD(){
       this.base = new BaseDatos();
   }
   
   public AporteBD(int id_aporte,int id_usuario,int id_problema,String solucion,
           String costo,Date fecha,String contacto, int elegido){
       this.idAporte = id_aporte;
       this.idUsuario = id_usuario;
       this.idProblema = id_problema;
       this.solucion = solucion;
       this.costo = costo;
       this.fecha = fecha;
       this.contacto = contacto;
       this.elegido = elegido;
       this.base = new BaseDatos();
   }
   
   public void guardar(int idAporte,int idUsuario, int idProblema,String solucion,
           String costo,Date fecha,String contacto,int elegido){
       try{
           base.conectar();
           String usuario = "INSERT INTO aporte VALUES("+idAporte+","
                                    + idUsuario+","+idProblema+","+solucion+","
                                    +costo+","+fecha+","+ contacto+","+ elegido+")";
           base.query(usuario);
       }catch(Exception error){     
    }
   }
   public void eliminar(int idAporte){
       try{
           base.conectar();
           String eliminar = "DELETE FROM aporte where idaporte ="+idAporte;
           base.query(eliminar);
       }catch(Exception error){
           
       }
   }

   public void getDatos(int idAporte){
       try{
           base.conectar();
           String consulta = "SELECT * FROM aporte where idaporte =" +idAporte;
           base.query(consulta);
       }catch(Exception error){
       } 
   }
   
   public void editar(int idAporte,int idUsuario, int idProblema,String solucion,
           String costo,Date fecha,String contacto,int elegido){
       try{
           base.conectar();
           String update = "UPDATE usuario SET solucion"+ solucion+"WHERE idaporte = "+idAporte
                   +" and idusuario = "+idUsuario+ " and idProblema = " + idProblema 
                   + "and solucion = " +solucion +" and costo = " + costo + " and fecha = " 
                   + fecha + "and contacto = "+  contacto + "and elegido = " +  elegido;
           base.query(update);
       }catch(Exception error){
       }
   }
   public String[][] tablaCompleta() {
        base.conectar();
        int numRows = 0;
        ResultSet cont = base.queryRS("SELECT COUNT(*) numRows FROM aporte");
        try {
            if(cont.next()){
                numRows = cont.getInt("numRows");
            } else {
                System.out.println("Error al contar los registros");
                numRows = 0;
            }
        } catch (SQLException e) {}
        System.out.println(numRows);
        ResultSet rs = base.queryRS("SELECT * FROM aporte");
        String[][] res = new String[numRows][8];
        int actual = 0;
        try {
            while(rs.next()){
                res[actual][0] = rs.getString("idaporte");
                res[actual][1] = rs.getString("idproblema");
                res[actual][2] = rs.getString("idusuario");
                res[actual][3] = rs.getString("solucion");
                res[actual][4] = rs.getString("costo");
                res[actual][5] = rs.getString("fecha");
                res[actual][6] = rs.getString("contacto");
                res[actual][7] = rs.getString("elegido");
                actual++;
            }
        } catch (SQLException e) {}
        return res;
    }
   
   public String[][] tablaUsr(int idUsuario) {
        base.conectar();
        int numRows = 0;
            ResultSet cont = base.queryRS("SELECT COUNT(*) numRows FROM aporte "
                + "WHERE idusuario = '" + idUsuario + "'" );
        try {
            if(cont.next()){
                numRows = cont.getInt("numRows");
            } else {
                System.out.println("Error al contar los registros");
                numRows = 0;
            }
        } catch (SQLException e) {}
        System.out.println(numRows);
        ResultSet rs = base.queryRS("SELECT * FROM aporte");
        String[][] res = new String[numRows][8];
        int actual = 0;
        try {
            while(rs.next()){
                res[actual][0] = rs.getString("idaporte");
                res[actual][1] = rs.getString("idproblema");
                res[actual][2] = rs.getString("idusuario");
                res[actual][3] = rs.getString("solucion");
                res[actual][4] = rs.getString("costo");
                res[actual][5] = rs.getString("fecha");
                res[actual][6] = rs.getString("contacto");
                res[actual][7] = rs.getString("elegido");
                actual++;
            }
        } catch (SQLException e) {}
        return res;
    }
    
}