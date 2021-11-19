/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Juand
 */
public class Facturacion implements Serializable {
    
    String Codigo="",cliente="";
    float costeTotal=0;
    LocalDate fechaFact;
    
    public Facturacion(String Codigo,String cliente,float costeTotal,LocalDate fechaFact){
        
        this.Codigo=Codigo;
        this.cliente=cliente;
        this.costeTotal=costeTotal;
        this.fechaFact=fechaFact;
    
    }
    
   
}
