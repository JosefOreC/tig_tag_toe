
from partida import Partida
from jugador import Jugador

def crear_partida():
    bot = Jugador(name="COMP1", simbolo='B', tipo_juego=True)
    jugador = Jugador(name="COMP2", simbolo="x", tipo_juego=True)

    game = Partida(jugador1=bot, jugador2=jugador)
    game.iniciar_partida()
    return game

if __name__ == "__main__":
    crear_partida()