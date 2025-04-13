from jugador import Jugador
from tablero import Tablero
from random import randint

class Partida:
    jugador1: Jugador
    jugador2: Jugador

    def __init__(self, jugador1, jugador2):
        self.jugador1 = jugador1
        self.jugador2 = jugador2
        self.tablero = Tablero()
        self.jugador1.set_tablero(self.tablero)
        self.jugador2.set_tablero(self.tablero)
        self.turnos_jugador_iniciante = [i+1 for i in range(9) if i%2==0]
        self.turnos_jugador_continuador = [i+1 for i in range(9) if i%2!=0]
        self.turno_act = 1
        self.estado = True
        self.status = {'now': 'en juego'}

    def definir_jugador_inicio(self):
        #jugador1: 0, jugador2: 1
        jugador_turno = randint(0, 1)
        if jugador_turno ==0:
            self.jugadores = {'jugador_iniciante': self.jugador1, 'jugador_continuador':self.jugador2}
            return
        self.jugadores = {"jugador_iniciante": self.jugador2, 'jugador_continuador': self.jugador1}

    def is_turn_of(self):
        return self.is_turn_of_when(self.turno_act)

    def is_turn_of_when(self, turno):
        if turno in self.turnos_jugador_iniciante:
            return self.jugadores.get("jugador_iniciante")
        return self.jugadores.get('jugador_continuador')

    def get_name_jugador_turn(self):
        return self.is_turn_of().name

    def turno(self):
        jugador = self.is_turn_of()
        print(f"Turno {self.turno_act}|", end=" ")
        jugada = jugador.hacer_jugada()
        if jugador.type_play:
            print(f" {jugador.name}> {jugada}")

        if (response:=jugador.jugar(jugada)) == None:

            self.tablero.delete_espacio_disponible(jugada)
            self.turno_act += 1
            if (win:=self.estado_partida()) != None:
                self.status = {'now': 'Partida terminada', 'winner name': win.name, 'loser name': (loser:=self.is_turn_of_when(self.turno_act-2)).name , 'winner': win, 'loser': loser, 'end': 'A player won'}
            return

        print(response)
        self.turno()
        return

    def analizar_tablero(self, jugador):

        jugadas = sorted(jugador.lista_jugadas)

        is_posibility_diagonal_win = [1,1] in jugadas
        if is_posibility_diagonal_win:
            if [0,0] in jugadas and [2,2] in jugadas: return True
            if [0,2] in jugadas and [2,0] in jugadas: return True

        cont0 = cont1= cont2 = cont_0 = cont_1 = cont_2 = 0
        for i,j in jugadas:
            if i == 0: cont0+=1
            elif i==1: cont1+=1
            elif i == 2: cont2+=1

            if j == 0:
                cont_0 += 1
            elif j == 1:
                cont_1 += 1
            elif j == 2:
                cont_2 += 1

            lista_conteo = [cont0, cont1, cont2, cont_1, cont_2, cont_0]
            if 3 in lista_conteo:
                return True

        return False

    def iniciar_partida(self):
        print("--------------------------------------------------------")
        print("Presione enter para empezar el juego...")
        print("--------------------------------------------------------")
        input()
        print(f"Haz iniciado partida. ")
        print(f"Definiendo quien empieza...")
        self.definir_jugador_inicio()
        print(f"\nEl que empieza a jugar es: {self.jugadores.get('jugador_iniciante').name}")

        while self.estado:
            self.tablero.display_tablero()
            self.turno()
        self.tablero.display_tablero()
        print("La partida ha finalizado.")


    def estado_partida(self):
        if self.turno_act == 5:
            is_player_initial_win = self.analizar_tablero(self.jugadores.get("jugador_iniciante"))
            if is_player_initial_win:
                self.estado = False
                print(f"{self.jugadores.get('jugador_iniciante').name} ha ganado!")
                return


        is_player1_win = self.analizar_tablero(self.jugador1)

        if is_player1_win:
            self.estado = False
            print(f"{self.jugador1.name} ha ganado!")
            return self.jugador1

        is_player2_win = self.analizar_tablero(self.jugador2)

        if is_player2_win:
            self.estado = False
            print(f"{self.jugador2.name} ha ganado!")
            return self.jugador2

        if self.turno_act > 9:
            self.estado = False
            print("Han empatado.")
            self.status = {'now':'Partida terminada', 'end': 'Empate'}
            return

