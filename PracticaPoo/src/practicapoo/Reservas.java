/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Juand
 */
public class Reservas implements Serializable {
    
    int numReserva=0, numHabitacion=0;
    float costeTotal=0;
    LocalDate diaInicio;
    LocalDate diaFin;
    String cliente="";
    
    public Reservas(int numReserva, int numHabitacion, float costeTotal, LocalDate diaInicio,LocalDate diaFin,String cliente){
        
        this.numHabitacion=numHabitacion;
        this.numReserva=numReserva;
        this.diaInicio=diaInicio;
        this.costeTotal=costeTotal;
        this.cliente=cliente;
        this.diaFin=diaFin;
    }


    
}
