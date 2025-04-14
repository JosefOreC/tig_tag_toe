/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tig_tag;

import static java.util.Collections.reverseOrder;

/**
 * 
 * @author danie
 */
public class Tablero {
    private int espacios_disponibles[] = {1,2,3,4,5,6,7,8,9};
    private char tablero[][] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
       
    public Tablero(){
        
    }
    
    public int[] get_espacios_disponibles(){
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
            line_table('|', ' ', this.tablero[j]);
            line_table('|', ' ', null);
        }
        line_table('+', '-', null);
    }
    
    public void set_box_in_table(char value, int i, int j){
        this.tablero[i][j] = value;
    }
    
}
