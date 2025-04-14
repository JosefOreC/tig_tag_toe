/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tig_tag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static java.util.Collections.reverseOrder;

/**
 * 
 * @author danie
 */
public class Tablero {
    private String espacios_disponibles="";
    private char tablero_box[][] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
       
    public Tablero(){
        for(int i=1; i<10; i++){
            this.espacios_disponibles+=Integer.toString(i);
        }
    }
    
    public String get_espacios_disponibles(){
        return this.espacios_disponibles;
    }
    
    private static void line_table(char sep, char line, char[] inter){
        
        boolean is_inter_exist = inter != null;
        int cont = 0;            
        for(int i=0; i<25; i++){
            if (i%8 == 0) System.out.print(sep);
            else if ((i==4 || i==12 || i==20) && is_inter_exist){
                System.out.print(inter[cont]);
                cont++;
            }
            else System.out.print(line);                  
        }
        System.out.println("");
    }
    
    public void display_tablero(){
        for(int j =0; j<3; j++){
            line_table('+', '-', null);
            line_table('|', ' ', null);
            line_table('|', ' ', this.tablero_box[j]);
            line_table('|', ' ', null);
        }
        line_table('+', '-', null);
    }
    
    public void set_box_in_table(char value, int i, int j){
        this.tablero_box[i][j] = value;
    }
    
    public char[][] get_tablero_box(){
        return this.tablero_box;
    }
    
    public void delete_espacio_disponible(char value){
        String new_espacios_disponibles = "";
        for(int i=0; i<this.espacios_disponibles.length(); i++){
            if(this.espacios_disponibles.charAt(i)!=value){
                new_espacios_disponibles+=this.espacios_disponibles.charAt(i);
            }
        }
        this.espacios_disponibles=new_espacios_disponibles;
    }
    
}
