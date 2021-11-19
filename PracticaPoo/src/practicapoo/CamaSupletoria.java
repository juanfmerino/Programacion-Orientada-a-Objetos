/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

/**
 *
 * @author Juand
 */
public class CamaSupletoria extends ClaseDecorator{

    private int camas;

    public CamaSupletoria(Habitaciones h,int camas) {
        super(h);
        this.camas=camas;
    }

    

    public float get_precio(){
        
        return super.get_precio()+camas*20;
    }
    
}
