
package tig_tag;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    
    public char hacer_jugada(){
        int value;
        char val;
        boolean is_valid_play=false;
        String espacios_disponibles;
        try{
            espacios_disponibles = this.tablero.get_espacios_disponibles();
        }catch (Exception e){
            System.err.println("Except: Don't exits initial game.");
            return 'e';
        }
        
        if (this.type_play){   
            while (!is_valid_play){
                Random r = new Random();
                value = r.nextInt(9)+1;
                val = Integer.toString(value).charAt(0);
                for(int i=0; espacios_disponibles.length()>i; i++){
                    if (val==(espacios_disponibles.charAt(i))){
                        is_valid_play = true;
                        return val;
                    }
                }
            }
        }
        
        Scanner sc = new Scanner(System.in);
        while (!is_valid_play){
            try {
                System.out.print(this.name+">");
                value = sc.nextInt();
                
                val = Integer.toString(value).charAt(0);
                for(int i=0; espacios_disponibles.length()>i; i++){
                    if (val==(espacios_disponibles.charAt(i))){
                        is_valid_play = true;
                        return val;
                    }
                }
                System.err.println("Except: The play isn't an integer, please, input again.");
            } catch (Exception e) {
                System.err.println("Except: The play isn't an integer, please, input again.");
            }
        }
        return 'e';
        
    }
}
