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
public class plan_cuotas_fijas implements forma_pago{
    
    double desc;

    public plan_cuotas_fijas() {
        this.desc = 0.3;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

    
    @Override
    public double calcular_porcentaje_importe(double importe) {
        double total;
        total= importe+(importe*0.3);
        
        return total;
    }
    
}
