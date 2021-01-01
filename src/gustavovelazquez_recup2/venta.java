/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gustavovelazquez_recup2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class venta {
    
    private ArrayList<vehiculo> productos;
    private cliente usuario;
    private int cuotas;
    private double importe;

    public venta() {
    }

    public venta(ArrayList<vehiculo> productos, cliente usuario, int cuotas) {
        this.productos = productos;
        this.usuario = usuario;
        this.cuotas = cuotas;
        this.importe = 0.0;
    }

    public ArrayList<vehiculo> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<vehiculo> productos) {
        this.productos = productos;
    }

    public cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(cliente usuario) {
        this.usuario = usuario;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public void genera_venta(forma_pago a){
        double total=0.0;
        for(vehiculo v: productos){
            
            if(v.getAcepta_plan_cuotas().equals("si")){
               v.setPrecio(a.calcular_porcentaje_importe(v.getPrecio()));
                
            }
            else{
                v.setPrecio(a.calcular_porcentaje_importe(v.getPrecio()));
            }
            
            total+=v.getPrecio();//total a pagar
            
        }
        
        this.importe=total;
        System.out.println(total);
           
    }
    
    
    public double generar_plan_cuotas(){
        
        double desc=0.0;
        double total=0.0;
        for(vehiculo v: productos){
            
            if(v.getAcepta_plan_cuotas().equals("si")){
              desc+=v.getPrecio()*0.3;
              total+=(v.getPrecio()+desc);//aumento el precio
              System.out.println("Cuotas: "+cuotas+"\nprecio x cuota : "+(total/cuotas));
            }
            else{
                desc+=v.getPrecio()*0.2;
                total+=(v.getPrecio()-desc);//resto el desc
                System.out.println("Cuotas: "+cuotas+"\nprecio x cuota : "+(total/cuotas));
            }
            
        }
        
        return (total/cuotas);
    }
    
    
    
    public void insertarVenta(int idc){
        
        
        String q="INSERT INTO venta(idcliente,cuotas,importe) values(?,?,?)";
        
        try{
            conexion cn = new conexion();
            Connection cnn = cn.getCnn();
           
            this.usuario.insertarCliente();;
            
            PreparedStatement ps =  cnn.prepareStatement(q);
            ps.setInt(1, idc);
            ps.setInt(2, this.cuotas);
            ps.setDouble(3, this.importe);
            ps.executeUpdate(); 
                
            for(vehiculo v:this.productos)
                    v.insertarVehiculo();
                
                
                
                
                  
            JOptionPane.showMessageDialog(null,"Registro almacenado correctamente");
            cn.cerrarconexion();
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
    }
}
