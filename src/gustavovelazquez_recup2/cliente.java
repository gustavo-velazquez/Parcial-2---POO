/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gustavovelazquez_recup2;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author USUARIO
 */
public class cliente {
    
    private String nombre;

    public cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void insertarCliente(){
        
        conexion cn = new conexion();
        Connection cnn = cn.getCnn();
        String q="INSERT INTO cliente(nombre)values(?)";
        try{
                PreparedStatement ps =  cnn.prepareStatement(q);
                ps.setString(1 ,this.nombre);
                ps.executeUpdate(); 
        }
        catch(Exception e){
            System.out.println(e);
        }
        cn.cerrarconexion();
    }
    
}
