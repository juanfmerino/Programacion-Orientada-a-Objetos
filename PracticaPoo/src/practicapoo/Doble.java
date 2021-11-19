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
public class Doble extends Habitaciones  {

    public Doble(int numHabitaciones, float precio, boolean baño) {
        super(numHabitaciones, precio, baño);
    }
    
    
   

    
    public float precioBaño(boolean baño){
        
        if(baño==true){
            precioExtra=20;
        }else{
            precioExtra=0;
        }
    return precioExtra;
    }
}
