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
        Jugador obj1 = new Jugador("bot",'X', true);
        Tablero obj = new Tablero();
        obj1.set_tablero(obj);
        char jugada = obj1.hacer_jugada();
        obj1.jugar(jugada);
        obj.display_tablero();
        System.out.print(obj1.lista_jugadas.get(0)[0]);
        System.out.print(obj1.lista_jugadas.get(0)[1]);
    }
    
}
