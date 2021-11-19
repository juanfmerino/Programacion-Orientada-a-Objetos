/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juand
 */
/** 
 * Este menu sirve para identificar el juego al que queremos jugar 
 * y cuando acabemos de jugar nos realizara una pregunta, donde 
 * s es seguir juagando y n es acabar de jugar
 * @param arg
 */
public class PracticaJuego {

    public static void main(String[] args) {
        
        Jugable Juego;
        char respuesta=' ';
        Scanner sn = new Scanner(System.in);
        
        do{
            Juego =eligeJuego();
            Juego.muestraNombre();
            Juego.muestraInfo();
            Juego.juega();
            System.out.println("Deseas volver a jugar?");
            respuesta = sn.next().charAt(0);
        }while((respuesta=='S')||(respuesta=='s')); 
        
      
    }
    
    /**
     * Este metodo lo que hace es sacar por pantalla el menu de juegos que se encuentran en la Aplicacion
     * Deberas eleguir un juego entre 1 y 4
     * @return 
     */
    
    public static Jugable eligeJuego(){
        int opcion = 0;
        boolean excepcion=true;
        
         Jugable j1=new JuegoAdivinaNumero(3);
         Jugable j2=new JuegoAdivinaNumeroPar(3);
         Jugable j3=new JuegoAdivinaNumeroImpar(3);
         Jugable j4=new JuegoAhorcadoIngles(3);
         Jugable[] js =new Jugable[4];    
         
         js[0]=j1;
         js[1]=j2;
         js[2]=j3;
         js[3]=j4;
         
         do{
            System.out.println("Juegos a eleguir");
            System.out.println("1. Jugar a Adivina Numero");
            System.out.println("2. Jugar a Adivina Numero Par");
            System.out.println("3. Jugar a Adivina Numero Impar");
            System.out.println("4. Jugar Ahorcado en Ingles");
           
            try{
                    System.out.println("Escribe una de las opciones");
                    opcion = MyInput.readInt();
                    excepcion=true;
                    
                }catch(NumberFormatException nfe){
                    System.out.println("El formato del numero es incorrecto");
                    excepcion=false;
                }
            
            
            
            if((opcion!=1) && (opcion!=2) && (opcion!=3)&& (opcion!=4))
                System.out.println("La opcion debe estar entre 1 y 4\n");
                
            System.out.println("");
        }while((opcion!=1) &&(opcion!=2) && (opcion!=3)&& (opcion!=4)||(excepcion != true));
       
         
         
        return js[opcion - 1];
    }

    
}
