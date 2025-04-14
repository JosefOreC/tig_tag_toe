
package tig_tag;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String name;
    private char simbolo;
    private boolean type_play;
    private Tablero tablero;
    
    public ArrayList<int[]> lista_jugadas=new ArrayList<>();

    public Jugador(String name, char simbolo, boolean type_play) {
        this.name= name;
        this.simbolo=simbolo;
        this.type_play = type_play;
    }
    
    public void set_tablero(Tablero tablero){
        this.tablero = tablero;
    }
    
    private boolean analitic_play(char value){
        String espacios_disponibles;
        
        try{
            espacios_disponibles = this.tablero.get_espacios_disponibles();
        }catch (Exception e){
            System.err.println("Except: Don't exits initial game.");
            return false;
        }
        
        for(int i=0; espacios_disponibles.length()>i; i++){
            if (value==(espacios_disponibles.charAt(i))){
                return true;
            }
        }
        return false;
    }
    
    public char hacer_jugada(){
        int value;
        char val;
        boolean is_valid_play=false;
        
        try{
            this.tablero.get_espacios_disponibles();
        }catch (Exception e){
            System.err.println("Except: Don't exits initial game.");
            return 'e';
        }
        
        if (this.type_play){   
            while (!is_valid_play){
                Random r = new Random();
                value = r.nextInt(9)+1;
                val = Integer.toString(value).charAt(0);
                if(analitic_play(val)) 
                    return val;
            }
        }
        
        Scanner sc = new Scanner(System.in);
        while (is_valid_play){
            try {
                System.out.print(this.name+">");
                value = sc.nextInt();
                val = Integer.toString(value).charAt(0);
                return val;
                
            } catch (Exception e) {
                System.err.println("Except: The play isn't an integer, please, input again.");
            }
        }
        return 'e';
        
    }
    
    public void jugar(char jugada){
        if(!analitic_play(jugada)){
            System.out.println("Except: The space is not available.");
            return;
        }
        
        char tablero[][] = this.tablero.get_tablero_box();
        
        for(int i=0; i<tablero.length; i++){
            for(int j=0; tablero.length>j; j++){
                if(jugada == tablero[i][j]){
                    this.tablero.set_box_in_table(this.simbolo,i, j);
                    int jugada_realizada[] = {i,j};
                    this.lista_jugadas.add(jugada_realizada);
                }
            }
        }
        
    }
    
    
}
