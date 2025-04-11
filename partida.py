from jugador import Jugador
from Tablero import Tablero
from random import randint

class Partida:
    jugador1: Jugador
    jugador2: Jugador
    tablero: Tablero

    def __init__(self, jugador1, jugador2, tablero):
        self.jugador1 = jugador1
        self.jugador2 = jugador2
        self.tablero = tablero
        self.turnos_jugador_iniciante = [i+1 for i in range(9) if i%2==0]
        self.turnos_jugador_continuador = [i+1 for i in range(9) if i%2!=0]
        self.turno_act = 1

    def definir_jugador_inicio(self):
        #jugador1: 0, jugador2: 1
        jugador_turno = randint(0, 1)
        if jugador_turno ==0:
            self.jugadores = {self.turnos_jugador_iniciante: self.jugador1, self.turnos_jugador_continuador:self.jugador2}
            return
        self.jugadores = {self.turnos_jugador_iniciante: self.jugador2, self.turnos_jugador_continuador: self.jugador1}

    def is_turn_of(self):
        if self.turno_act in self.turnos_jugador_iniciante:
            return self.jugadores.get(self.turnos_jugador_iniciante)
        else: return self.jugadores.get(self.turnos_jugador_continuador)

    def get_name_jugador_turn(self):
        return self.is_turn_of().name
    def turno(self):
        jugador = self.is_turn_of()
        jugada = int(input(f"Turno {self.turno_act}| {jugador.name}>"))
        jugador.jugar(jugada)






