
package practicapoo;

import java.io.*; //Por ejemplo, para tratar excepciones de Entrada/Salida de datos 
import java.util.ArrayList; 

/**
 * Esta clase posee los métodos que se utilizan para leer datos por teclado
 */
public class MyInput {
    
// Lee una cadena de caracteres desde el teclado

    /**
     * Este método lee una cadena de caracteres desde el teclado
     * @return la cadena de caracteres escrita por el teclado
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
        String string="";
        try {
            string = br.readLine(); }
        catch (IOException ex) {
            System.out.println(ex); }
        return string; }
    
// Lee un dato tipo int desde el teclado

    /**
     * Este método lee un dato de tipo entero (int) desde el teclado
     * @return el número digitado por teclado
     * @throws NumberFormatException si se introduce un caracter no numérico 
     */
    public static int readInt() throws NumberFormatException{  
     return Integer.parseInt(readString()); }

// Lee un dato tipo double desde el teclado

    /**
     * Este método lee un dato de tipo double desde el teclado
     * @return el número de tipo double
     */
    public static double readDouble() {
    return Double.parseDouble(readString()); }

//Lee un dato tipo byte desde el teclado

    /**
     * Este método lee un dato de tipo byte desde el teclado
     * @return el número de tipo byte
     */
    public static byte readByte() {
    return Byte.parseByte(readString()); }

// Lee un dato tipo short desde el teclado

    /**
     * Este método lee un dato de tipo short desde el teclado
     * @return el número de tipo short
     */
    public static short readShort() {
    return Short.parseShort(readString()); }

// Lee un dato tipo long desde el teclado

    /**
     * Este método lee un dato de tipo long desde el teclado
     * @return el número de tipo long
     */
    public static long readLong() {
    return Long.parseLong(readString()); }

//Lee un dato tipo float desde el teclado

    /**
     * Este método lee un dato de tipo float desde el teclado
     * @return el número de tipo float
     */
    public static float readFloat() {
    return Float.parseFloat(readString()); }
    
}
