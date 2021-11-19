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
public class Cliente implements Serializable {
    
    String nombre= "", apellidos= "", Dni="",telefono="";
        
    public Cliente(String nombre, String apellidos,String Dni,String telefono){
        
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.Dni=Dni;
        this.telefono=telefono;
        
    }
    
    
}
