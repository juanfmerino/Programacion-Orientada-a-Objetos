/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.time.LocalDate;

/**
 *
 * @author Juand
 */
public class ReservaSpa extends Reservas {
    
    int numPersonas;
    String servicio;
    
    
    public ReservaSpa(int numReserva, int numHabitacion, float costeTotal, LocalDate diaInicio, LocalDate diaFin, String cliente,String servicio, int numPersonas) {
        super(numReserva, numHabitacion, costeTotal, diaInicio, diaFin, cliente);
        this.numPersonas=numPersonas;
        this.servicio=servicio;
    }


    
}
