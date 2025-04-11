from Tablero import Tablero
class Jugador:
    name: str
    simbolo: str
    tablero: Tablero
    def __init__(self, name, simbolo, tablero):
        self.name = name
        self.simbolo = simbolo
        self.tablero = tablero

    def jugar(self, jugada):
        if not jugada in self.tablero.espacios_disponibles:
            return "Exception \nThe space is not available."

        for i,j in self.tablero.tablero:
            if jugada == j:
                I = self.tablero.tablero.index(i)
                J = self.tablero.tablero[I].index(j)
                self.tablero.set_box_in_table(self.simbolo, I, J)
                return



