class Tablero:

    def __init__(self):
        self.espacios_disponibles = [i for i in range(9)]
        self.tablero = [[1,2,3],[4,5,6],[7,8,9]]

    def get_espacios_disponibles(self):
        return self.espacios_disponibles

    def display_tablero(self):
        def line_table(sep, line, inter):
            if inter:
                inter = inter[::-1]
            for i in range(25):
                if i % 8 ==0:
                    print(sep, end="")
                elif i in [4,12,20] and inter:
                    print(inter[-1], end="")
                    inter.pop()
                else: print(line, end="")
            print()
        line_table('+', '-', None)
        line_table('|'," ", None)
        line_table('|', " ", self.tablero[0])
        line_table('|', " ", None)
        line_table('+', '-', None)
        line_table('|', " ", None)
        line_table('|', " ", self.tablero[1])
        line_table('|', " ", None)
        line_table('+', '-', None)
        line_table('|', " ", None)
        line_table('|', " ", self.tablero[2])
        line_table('|', " ", None)
        line_table('+', '-', None)

    def set_box_in_table(self, value, i, j):
        self.tablero[i][j] = value



if __name__ == '__main__':
    pass
