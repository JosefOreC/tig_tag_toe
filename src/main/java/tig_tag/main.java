/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tig_tag;
/**
 *
 * @author danie
 */
public class main {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        Tablero obj = new Tablero();
        obj.display_tablero();
        obj.set_box_in_table('X', 1, 1);
        obj.display_tablero();
        System.out.println(obj.get_espacios_disponibles());
        obj.delete_espacio_disponible('8');
        System.out.println(obj.get_espacios_disponibles());
    }
    
}
