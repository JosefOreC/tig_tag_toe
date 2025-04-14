
package tig_tag;

import java.util.ArrayList;

public class Jugador {
    private String name;
    private char simbolo;
    private boolean type_play;
    private Tablero tablero;
    
    private ArrayList<Integer[]> lista_jugadas=new ArrayList<>();

    public Jugador(String name, char simbolo, boolean type_play) {
        this.name= name;
        this.simbolo=simbolo;
        this.type_play = type_play;
    }
    
    public void set_tablero(Tablero tablero){
        this.tablero = tablero;
    }
    
}
