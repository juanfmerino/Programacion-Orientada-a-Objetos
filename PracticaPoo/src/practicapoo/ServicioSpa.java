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
public class ServicioSpa implements Serializable {
    
    String Codigo="",descripcion="";
    float coste=0;
    
    public ServicioSpa(String Codigo, String descripcion, float coste){
    
        this.Codigo=Codigo;
        this.descripcion=descripcion;
        this.coste=coste;
    }
    
    
    public void obtenerListadoServicio(Balneario balneario){
        

        
    }
    
    public void obtenerInfoServicio(Balneario balneario,String codigo){
        

    }
}
