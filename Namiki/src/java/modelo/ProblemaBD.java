package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 
   
    /**
     * Constructor por default
     */
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
   
    public void guardar(int idCategoria, int idUsuario, 
                String descripcion,Date fecha,String titulo, String topico){
        base.conectar();
        String problema= "INSERT INTO problema (idcategoria,idusuario,descripcion,fecha,titulo,topico) VALUES('"
                                +idCategoria+"','"+idUsuario+"','"+descripcion+"','"
                                +fecha+"','"+titulo+"','"+topico+"')";
        System.out.println("Guandando datos");
        base.query(problema);
    }
    
    /**
     * 
     * @param idProblema Int
     */
    public void eliminar(int idProblema){
        base.conectar();
        String eliminar = "DELETE FROM problema WHERE idproblema = "+idProblema;
        base.query(eliminar);
    }

    /**
     * 
     * @param idProblema Int
     */
    public String[][] getDatos(int idProblema){
        base.conectar();
        String[][] res = new String[1][7];
        String query = "SELECT * FROM problema WHERE idproblema = " +idProblema;
        ResultSet consulta = base.queryRS(query); 
           try{
                while(consulta.next()){
                    this.idProblema = consulta.getInt("idproblema");
                    res[0][0] = consulta.getString("idproblema");
                    this.idCategoria =consulta.getInt("idcategoria");
                    res[0][1] = consulta.getString("idcategoria");
                    this.idUsuario = consulta.getInt("idusuario");
                    res[0][2] = consulta.getString("idusuario");
                    this.titulo = consulta.getString("titulo");
                    res[0][3] = consulta.getString("titulo");
                    this.topico = consulta.getString("topico");  
                    res[0][4] = consulta.getString("topico");
                    this.descripcion = consulta.getString("descripcion");
                    res[0][5] = consulta.getString("descripcion");
                    this.fecha = consulta.getDate("fecha");
                    res[0][6] = consulta.getString("fecha");
                }
           }catch(SQLException e){
               System.out.println("PROBLEMA NO ENCONTRADO");
           }       
           return res;
    }
   
    public void editar(int idProblema,int idCategoria, int idUsuario, 
            String descripcion,Date fecha,String titulo, String topico){
        base.conectar();
        String update = "UPDATE problema SET descripcion "+descripcion+"WHERE idproblema = " +idProblema
                + " and idusuario = "+idUsuario+ " and idcategoria = " +idCategoria 
                + " and descripcion = '"+descripcion+ "' and fecha = '" 
                +fecha+ "' and titulo = '"+titulo+ "' and topico = '" +topico+"'";
        base.query(update);
    }
    
    public String[][] tablaCompleta() {
        base.conectar();
        int numRows = 0;
        ResultSet cont = base.queryRS("SELECT COUNT(*) numRows FROM problema");
        try {
            if(cont.next()){
                numRows = cont.getInt("numRows");
            } else {
                System.out.println("Error al contar los registros");
                numRows = 0;
            }
        } catch (SQLException e) {}
        System.out.println(numRows);
        ResultSet rs = base.queryRS("SELECT * FROM problema P, categoria C "
                + "WHERE P.idcategoria =C.idcategoria ORDER BY P.fecha DESC" );
        String[][] res = new String[numRows][7];
        int actual = 0;
        try {
            while(rs.next()){
                res[actual][0] = rs.getString("idproblema");
                res[actual][1] = rs.getString("categoria");
                res[actual][2] = rs.getString("idusuario");
                res[actual][3] = rs.getString("titulo");
                res[actual][4] = rs.getString("topico");
                res[actual][5] = rs.getString("descripcion");
                res[actual][6] = rs.getString("fecha");
                actual++;
            }
        } catch (SQLException e) {}
        return res;
    }
    
    public String[][] tablaUsr(String idusuario) {
        base.conectar();
        int numRows = 0;
        ResultSet cont = base.queryRS("SELECT COUNT(*) numRows FROM problema "
                + "WHERE idusuario = '" + idusuario + "'" );
        try {
            if(cont.next()){
                numRows = cont.getInt("numRows");
            } else {
                System.out.println("Error al contar los registros");
                numRows = 0;
            }
        } catch (SQLException e) {}
        System.out.println(numRows);
        ResultSet rs = base.queryRS("SELECT * FROM problema P, categoria C "
                + "WHERE P.idusuario = '" + idusuario + "' and P.idcategoria = C.idcategoria ORDER BY P.fecha DESC");
        String[][] res = new String[numRows][7];
        int actual = 0;
        try {
            while(rs.next()){
                res[actual][0] = rs.getString("idproblema");
                res[actual][1] = rs.getString("categoria");
                res[actual][2] = rs.getString("idusuario");
                res[actual][3] = rs.getString("titulo");
                res[actual][4] = rs.getString("topico");
                res[actual][5] = rs.getString("descripcion");
                res[actual][6] = rs.getString("fecha");
                actual++;
            }
        } catch (SQLException e) {}
        return res;
    }
}