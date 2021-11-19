/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;

/**
 *
 * @author Juand
 */
public class Habitaciones implements Serializable {
    
    int numHabitaciones;
    float precio;
    float precioExtra;
    boolean baño;


    
    public Habitaciones(int numHabitaciones, float precio, boolean baño){
        
        this.numHabitaciones=numHabitaciones;
        this.precio=precio;
        this.baño=baño;
    }
    
    public int get_numHabitacion(){
        return numHabitaciones;
    }
    
    public float get_precio(){
        return precio;
    }
    
    public boolean get_baño(){
    
        return baño;
    }
    
    
    
}
