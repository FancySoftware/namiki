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


    public String[][] getDatos(int idAporte){
        base.conectar();
        String[][] res = new String[1][8];
        String query = "SELECT * FROM aporte WHERE idaporte = " +idAporte;
        ResultSet consulta = base.queryRS(query); 
           try{   
                while(consulta.next()){
                    this.idAporte = consulta.getInt("idaporte");
                    res[0][0] = consulta.getString("idaporte");
                    this.idProblema = consulta.getInt("idproblema");
                    res[0][1] = consulta.getString("idproblema");
                    this.idUsuario = consulta.getInt("idusuario");
                    res[0][2] = consulta.getString("idusuario");
                    this.solucion = consulta.getString("solucion");
                    res[0][3] = consulta.getString("solucion");
                    this.costo = consulta.getString("costo");
                    res[0][4] = consulta.getString("costo");
                    this.fecha = consulta.getDate("fecha");
                    res[0][5] = consulta.getString("fecha");
                    this.costo = consulta.getString("contacto");
                    res[0][6] = consulta.getString("contacto");
                    this.elegido = consulta.getInt("elegido");
                    res[0][7] = consulta.getString("elegido");
                }
           }catch(SQLException e){
               System.out.println("APORTE NO ENCONTRADO");
           }       
           return res;
    }
   
   public void editar(int idAporte,int idUsuario, int idProblema,String solucion,
           String costo,Date fecha,String contacto,int elegido){

           base.conectar();
           String update = "UPDATE aporte SET solucion ='" + solucion 
                   + "', costo = '" + costo
                   + "', fecha = '" + fecha
                   + "', contacto = '" + contacto
                   + "' WHERE idaporte = "+idAporte;
           base.query(update);
   
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
        ResultSet rs = base.queryRS("SELECT * FROM aporte WHERE idusuario = '" + idUsuario +"'");
        
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