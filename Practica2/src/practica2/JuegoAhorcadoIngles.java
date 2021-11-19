package practica2;

import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juand
 */
public class JuegoAhorcadoIngles extends Juego implements Jugable {
    
    Scanner sn = new Scanner(System.in);
    ArrayList<Character> cadenaAdivinar= new ArrayList<Character>();
    
    /**
     * Se maneja el numero de vidas 
     * @param nV 
     */
    
    public JuegoAhorcadoIngles(int NV) {
        super(NV);
    }
    
    /**
     * devuelve la cadena que hay que adivinar sacada aleatoriamente del fichero Ahorcado
     * @return cadena 
     */
    
    public ArrayList<Character> obtenerPalabra() /*throws JuegoAhorcadoException*/{
        ArrayList<Character> cadena= new ArrayList<Character>();
        ArrayList<String> palabras= new ArrayList<String>();
        palabras=MyInput.leeFichero("Ahorcado.txt");
        
        Random r= new Random(System.currentTimeMillis());
        
        String palabra=palabras.get(r.nextInt(palabras.size()));
        for (int i=0; i<palabra.length();i++)
           cadena.add(palabra.charAt(i));
        
        return cadena;
    }
    

    public void reiniciaPartida(){
        
        boolean condicion;
        
        super.reiniciaPartida();
        
        //do{
            //try {
                cadenaAdivinar=obtenerPalabra();
            /*    condicion=true;
            } catch (JuegoAhorcadoException e) {
                System.out.print(e.getMessage());
                condicion= false;
            }
        }while(condicion==false);*/
    }
    
    /**
      * Esta parte es donde se implementa el juego
      * Primero se crear cad que es arry con el trabaja el usuario y despues 
      * dos booleans con el que se sabra cuando has acertado una letra y cuando has fallado
      * Se introduce la letra y depues la compara con las letras de la palabra que hay que adivinar
      * si se encuentra la saca por pantalla todas las veces que este, si no esta se resta una vida.
      * Cuando se te acaban las vidas pierdes la partida y si la adivinas antes de se te acaben las 
      * vidas se actualiza tu record 
      */
    
    public void juega(){
        
        int i,t;
        String letra;
        boolean acertar=false;
        boolean fallar=true;
        ArrayList<Character> cadena= new ArrayList<Character>();
        
        reiniciaPartida();
        
        
        
        for(t=0;t<cadenaAdivinar.size();t++)
            cadena.add('-' );
        
        System.out.print("La cadena a adivinar: ");
        for(t=0;t<cadenaAdivinar.size();t++)
            System.out.print(cadena.get(t));
        
        System.out.println(" ");

        
        do{
            do{
                System.out.println("Introduce una letra:");
                letra=MyInput.readString();

                if(letra==letra.toUpperCase()){
                    System.out.println("La letra introducida debe ser en minuscula");
                }
            }while(letra==letra.toUpperCase());
            

            for(i=0;i<cadenaAdivinar.size();i++){
                if(cadenaAdivinar.get(i)==letra.charAt(0)){
                    cadena.set(i, letra.charAt(0));
                    
                    fallar=false;
                }
                if(cadena.indexOf('-')==-1){
                    acertar = true;
                    break;
                }
            }
            
            if(fallar==true){
               System.out.println("La letra no se encuentra en la palabra");
               if(super.quitaVida()==false){
                       System.out.println("Perdiste la Partido. Intentalo otra vez");
                       break;
                    }                
                super.muestraVidasRestantes();
            }else{
                 System.out.println("Letra Encontrada!!!!");
                  System.out.println(cadena);
                 
                   if(cadena==cadenaAdivinar){
                       System.out.println("Palabra Encontrada. Fin del juego");
                   }
                   fallar=true;
            }
                
        }while((acertar==false));
        
        if(acertar==true){
             actualizaRecord();
         }
    }
    
    /**
    *Muestra por println la información necesaria para saber jugar al juego
    */
    public void muestraInfo(){
        System.out.println("El juego consitira en adivinar una palabra aleatoria, para ello tendras 3 intentos,");
         System.out.println("cada letra que falles te restara una vida");
    }
    
    /**
    *Muestra el nombre del juego al que se va a jugar
    */
    public void muestraNombre(){
        System.out.println("Juego del Ahorcado en Ingles");
    }
    
    private boolean esPalabraErronea(String palabra) throws JuegoAhorcadoException{
        int i;
        
        for(i=0;i<cadenaAdivinar.size();i++){
            if(cadenaAdivinar.get(i)<97 || cadenaAdivinar.get(i)>122);
                throw new JuegoAhorcadoException("La palabra contiene un caracter erroneo");
        }
        
        return false;
            
   }
    
}
