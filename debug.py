from tablero import *
from jugador import *
from main import *
from partida import *

while (comando:=input("main>")) != "exit":
    try:
        exec(comando)
    except Exception as E:
        print(E)
