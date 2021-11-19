package practica2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juand
 */
public class MyInput {
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
        String string=" ";
        try {
        string = br.readLine(); }
        catch (IOException ex) {
        System.out.println(ex); }
        return string; }
        // Lee un dato tipo int desde el teclado
        public static int readInt() {
                return Integer.parseInt(readString()); 
        }
        // Lee un dato tipo double desde el teclado
        public static double readDouble() {
        return Double.parseDouble(readString()); }
        //Lee un dato tipo byte desde el teclado
        public static byte readByte() {
        return Byte.parseByte(readString()); }
        // Lee un dato tipo short desde el teclado
        public static short readShort() {
        return Short.parseShort(readString()); }
        // Lee un dato tipo long desde el teclado
        public static long readLong() {
        return Long.parseLong(readString()); }
        //Lee un dato tipo float desde el teclado
        public static float readFloat() {
        return Float.parseFloat(readString()); }
        
        public static ArrayList <String> leeFichero(String Ahorcado){
            ArrayList <String> v = new ArrayList <String>();
            File fichero=null;
            FileReader fr=null;
            BufferedReader br=null;
            try{
            fichero=new File(Ahorcado);
            fr=new FileReader(fichero);
            br=new BufferedReader(fr);
            String linea;
            while ((linea=br.readLine())!=null){
            v.add(linea);}
            }
            catch (Exception e){
            e.printStackTrace();
            }
            finally {
            try {
            if (null!= fr){
            fr.close();
            br.close();}
            }
            catch (Exception e1){
            e1.printStackTrace();
            }
            }
            return v;
        }
}

