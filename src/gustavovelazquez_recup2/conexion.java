
package gustavovelazquez_recup2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class conexion {
    
    private String servidor= "localhost";
    private String database= "venta_automovil";
    private String usuario="root";
    private String contraseña="";
    private String url="";
    
    private Connection cnn;
    private Statement stm;
    private ResultSet rs;
    
   

    public  conexion() {
        
         try{
           
            //LEVANTO EL DRIVER
            Class.forName("com.mysql.jdbc.Driver");
            //DEFINO LA URL
            url="jdbc:mysql://"+servidor+":3306/"+database;
            //ESTABLEZCO LA CONEXION
            cnn=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conexion a base de datos"+url+".......ok");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
    }

    public Connection getCnn() {
        return cnn;
    }
    
     public Connection cerrarconexion(){
    
        try{
            cnn.close();
            System.out.println("\nCerrando conexion "+url+".......ok");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        cnn=null;
        return cnn;
    }
    
    
    
    public ResultSet consultar(String  q) throws SQLException{
        
        stm = cnn.createStatement();
        rs = stm.executeQuery(q);
        
        return rs;
         
    }
    
    public void eliminar(String q){
        
        try{
            stm=cnn.createStatement();
            stm.executeUpdate(q);
            System.out.println(q);
            JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
    public void modificar(String q){
        
        try{
            stm=cnn.createStatement();
            stm.executeUpdate(q);
            System.out.println(q);
            JOptionPane.showMessageDialog(null,"Registro modificsdo correctamente");
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
 
    
    
   
    
    ///obtener ultimo id cargado
     public int ultimoidVenta(){
        int id=1;
        String q="Select MAX(idventa) FROM venta";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(q);
            rs= ps.executeQuery();
            
            while(rs.next()){
                id=rs.getInt(1);//recorro la tabla con el id mayor y lo guardo en id; columna = 1
            }
        } catch (Exception e) {
        }
        return id;
     }

}




