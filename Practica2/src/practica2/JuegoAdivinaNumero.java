package practica2;

import java.util.Random;
import static practica2.MyInput.readString;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juand
 */
public class JuegoAdivinaNumero extends Juego implements Jugable {
    
    int numAdivinar;

    /**
     * Maneja las vidas de este modo de juego
     * @param Numvidas 
     */
    public JuegoAdivinaNumero(int Numvidas/*,int nA*/) {
        super(Numvidas);
        //numAdivinar=nA;
    }
    
     /**
     * Comprueba que el numero introducizo y el que hay que adivinar son iguales 
     * te duevuelve true si son iguales
     * @param numAdivinar
     * @return 
     */
    
    public boolean validaNumero(int numAdivinar){
        return true;
    }
    
    /**
     * Muestra por pantalla el nombre del modo de Juego
     */
    public void muestraNombre(){
         System.out.println("Adivina un Numero");
    }
    
    /**
     * Muetsra por pantalla la informacion del modo de juego
     */
    public void muestraInfo(){
         System.out.println("El juego consitira en adivinar un numero del 1-10, para ello tendras 3 intentos");
    }
    
    /**
     * Se genera un numero aleatorio para adivinar
     * @return 
     */
    public int numAleatorio(){
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt(11);
    }
    
    /**
     * Se realiza una modificacion de la clase reiniciaPartdia para este modo de juego
     * Se realiza el polimorfismo
     */
    
    public void reiniciaPartida(){
        super.reiniciaPartida();
        numAdivinar=numAleatorio();
    }
    
    
    /**
     * Esta parte del programa se realiza todo el juego 
     * Se intriduce un numero si este es igual al adivinar se acaba la partida y
     * entonces se actualizara el record, si se falla el programa te dira si el numero
     * es mayor o menor al introduzido, si no aciertas el numero y no te quedan vidas
     * entonces perderas la partida
     */
    public void juega(){
        
        int num=0;
        boolean i=true;
        boolean excepcion=true;
        
        reiniciaPartida();
       do{
           do{
                   
               try{
                    System.out.println("Deberas adivinar un numero entre el 1 y 10");
                    num=MyInput.readInt();
                    excepcion=true;
                    
                }catch(NumberFormatException nfe){
                    System.out.println("El formato del numero es incorrecto");
                    excepcion=false;
                }
                
            }while((validaNumero(num)== false)||(excepcion != true));
        
            if(num!=numAdivinar){
                i=quitaVida();
                    if(num>numAdivinar)
                         System.out.println("El numero a acertar en menor");
                    else
                         System.out.println("El numero a acertar en mayor");   
            }else{
                System.out.println("Acertaste!!!");
                actualizaRecord();
                i=false;   
            }
       }while(i);
        
    }
 
}
