/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Juand
 */
public abstract class Juego {
    
    int vida;
    private int vidas_iniciales;
    int record=0;
    
    /**
     * Se pasan el numero de vidas que tendras en el juego
     * @param Numvidas
     */
    public Juego(int Numvidas){
        vida=Numvidas;
        vidas_iniciales=Numvidas;
        
    }
    
    /**
     * Muestra por pantalla la vidas que te quedan 
     * para ello tendras que llamarlo
     */
    public void muestraVidasRestantes(){
        System.out.println("Te quedan:"+this.vida);
    }
    
    /**
     * Cada vez que se falla se invoca este metodo donde se resta una vida
     * Cuando las vidas se termine se devuelve false y se termina el juego
     * @return 
     */
    public boolean quitaVida(){
        vida=vida-1;
        if(vida>0){
          return true;
            }else{
            System.out.println("Juego Terminado");
            
            return false;
            }   
    }
    
    /**
     * Al principio de las partidas se invoca este metodo donde se restablecen las vidas iniciales
     */
    public void reiniciaPartida(){
        vida=vidas_iniciales;
        System.out.println("La partida se ha reiniciado con exito, tienes " +vida+ " vidas");
 
    }
    
    /**
     * Este metodo se incova una vez que has completado con exito el juego 
     * Donde te actualiza tu record de vidas anterior si ha sido superado
     */
    public void actualizaRecord(){
        
        if(vida==record){
            System.out.println("Se ha alcanzado el record");
        }else{if(vida>record)
                record=vida;
                System.out.println("Se ha batido el record.El valor actual es:"+record); 
            
        }  

    }
    
    /*public abstract void juega ();*/
    
    
    
}
