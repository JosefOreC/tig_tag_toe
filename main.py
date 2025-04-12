
from partida import Partida
from jugador import Jugador

bot = Jugador(name="COMP1", simbolo='B', tipo_juego=True)
jugador = Jugador(name="Josef", simbolo="x", tipo_juego=False)

game = Partida(jugador1=bot, jugador2=jugador)
game.iniciar_partida()

