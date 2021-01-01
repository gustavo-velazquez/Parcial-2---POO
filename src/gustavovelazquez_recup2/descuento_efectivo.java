/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gustavovelazquez_recup2;

/**
 *
 * @author USUARIO
 */
public class descuento_efectivo implements forma_pago {
    
    double desc;

    public descuento_efectivo() {
        this.desc = 0.20;
    }
    
    

    public double getDesc() {
        return desc;
    }

    public void setDesc(float desc) {
        this.desc = desc;
    }
    
    

    @Override
    public double calcular_porcentaje_importe(double importe) {
        double total;
        
        total=importe-(importe*desc);
         
        return total;
    }
    
}
