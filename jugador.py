import random

from tablero import Tablero
class Jugador:
    name: str
    simbolo: str
    tablero: Tablero
    lista_jugadas: list
    type_play: bool

    def __init__(self, name, simbolo, tipo_juego):
        """
            tipo_juego
            0: manual
            1: automatico
        """
        self.name = name
        self.simbolo = simbolo
        self.lista_jugadas = []
        self.type_play = tipo_juego

    def set_tablero(self, tablero):
        self.tablero = tablero

    def hacer_jugada(self):
        if not self.type_play:
            jugada_is_valid = False
            while not jugada_is_valid:
                try:
                    jugada = int(input(f" {self.name}>"))
                    jugada_is_valid = True
                except Exception:
                    print("The play is not an int, please, input again.")

            return jugada

        try:
            jugada = ''
            while not jugada in self.tablero.espacios_disponibles:
                jugada = random.randint(1,9)

            return jugada
        except:
            return "Except: Don't exits initial game."




    def jugar(self, jugada):
        if not (jugada in self.tablero.espacios_disponibles):
            return "Exception \nThe space is not available."

        for i in self.tablero.tablero:
            for j in i:
                if jugada == j:
                    I = self.tablero.tablero.index(i)
                    J = self.tablero.tablero[I].index(j)
                    self.tablero.set_box_in_table(self.simbolo, I, J)
                    self.lista_jugadas.append([I,J])
                    return



