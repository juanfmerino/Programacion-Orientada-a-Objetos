/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Random;

/**
 *
 * @author Juand
 */
public class JuegoAdivinaNumeroImpar extends JuegoAdivinaNumero implements Jugable {

    
    /**
     * Se extiende por lo tanto el juego es el mismo pero con distintas reglas 
     * Se valida el numero que debera ser Impar, se genera un numero aleatorio que 
     * siempre es impar,se pasan el numero de vidas en este modo, tambien se muestra la info y 
     * el nombre de este modo, siempre que el numero no sea impar no se restaran vidas
     * @param nA
     * @return 
     */
    public boolean validaNumero(int nA){

        if(nA % 2==1){
            return true;
        }else{
            System.out.println("El numero debera ser impar.Intentalo de nuevo");
            return false;
        }
        
    }
    public void muestraNombre(){
        System.out.println("Adivina un numero Impar");
        
        
    }
    
    public void muestraInfo(){
        System.out.println("El juego consitira en adivinar un numero impar del 1-10, para ello tendras 3 intentos");
        System.out.println("Si pones numeros Pares no restara vidas");
    }
    
    public int numAleatorio(){
        
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt(5)*2+1;  
    }
    
    public void reiniciaPartida(){
        super.reiniciaPartida();
        numAdivinar=numAleatorio();
    }
    
    
    public JuegoAdivinaNumeroImpar(int Numvidas) {
        super(Numvidas);
    }
    
    
}
