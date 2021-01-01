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
public class vehiculo {
    
    private String modelo;
    private double precio;
    private String acepta_plan_cuotas;

    public vehiculo() {
    }

    public vehiculo(String modelo, double precio, String acepta_plan_cuotas) {
        this.modelo = modelo;
        this.precio = precio;
        this.acepta_plan_cuotas = acepta_plan_cuotas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAcepta_plan_cuotas() {
        return acepta_plan_cuotas;
    }

    public void setAcepta_plan_cuotas(String acepta_plan_cuotas) {
        this.acepta_plan_cuotas = acepta_plan_cuotas;
    }
    
    public void insertarVehiculo(){
        
        conexion cn = new conexion();
        Connection cnn = cn.getCnn();
        String q="INSERT INTO vehiculo(modelo,precio,acepta_cuotas,idventa) values(?,?,?,?)";
        try{
                PreparedStatement ps =  cnn.prepareStatement(q);
                ps.setString(1 ,this.modelo);
                ps.setDouble(2, this.precio);
                ps.setString(3, this.acepta_plan_cuotas);
                ps.setInt(4, (cn.ultimoidVenta()));
                ps.executeUpdate(); 
        }
        catch(Exception e){
            System.out.println(e);
        }
        cn.cerrarconexion();
    }
    
}
