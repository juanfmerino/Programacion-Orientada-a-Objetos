/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *Es la excepcion que se invoca cuando surge un error en la palabra
 * en la clase JuegoAhorcadoIngles
 * @author Juand
 */
public class JuegoAhorcadoException extends Exception {
    
    public JuegoAhorcadoException(String palabra){
        super(palabra);
    }
    
    
}
