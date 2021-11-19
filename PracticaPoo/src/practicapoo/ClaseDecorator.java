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
public abstract class ClaseDecorator extends Habitaciones {
    
    
    private Habitaciones habitacion;

    public ClaseDecorator(Habitaciones h) {
        super(0, 0, false);
        
        habitacion=h;
    }
    
    public int get_numHabitacion(){
        return habitacion.get_numHabitacion();
    }
    
    public float get_precio(){
        return habitacion.get_precio();
    }

    public boolean get_baño(){
    
        return habitacion.get_baño();
    }
    
}
