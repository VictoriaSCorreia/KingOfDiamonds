def start():
    entrada()
    resultado()

def entrada():  
    """ Recebe os dados dos jogadores e insere todos em uma 
    lista global composta por dicionários
    """
    global jogadores
    jogadores = list()
    i = 0
    rodadas = 0
    if len(jogadores) == 0 or len(jogadores) == 5:
        limite = 5
    elif len(jogadores) == 4:
        limite = 4
    elif len(jogadores) == 3:
        limite = 3
    elif len(jogadores) == 2:
        limite = 2
    while i < limite:
        try:
            numero = int(input(f'Jogador {i + 1}: '))
            if 0 <= numero <= 100:
                jogadores.append({f'Jogador {i + 1}': numero})
                i += 1
            else:
                raise ValueError
        except ValueError:
            print('Insira um valor válido.')
    rodadas +=1
    

def resultado(): 
    """ Calcula a média dos números na lista jogadores
    multiplicada por 0.8
    """
    jogadas = [int(jogador[f'Jogador {i + 1}']) for i, jogador in enumerate(jogadores)]
    total = sum(jogadas) / len(jogadores) * 0.8
    print(total)
    print(vencedor(jogadas, total))


def vencedor(lista, n): 
    """ Determina quais jogadores escolheu o número mais próximo do resultado
    """
    ganhadores = list()
    maisprox = min(lista, key=lambda x: abs(x-n))
    for i, jogador in enumerate(jogadores):
        if maisprox == int(jogador[f'Jogador {i + 1}']):
            ganhadores.append({'Ganhador': f'Jogador {i + 1}'})
    #pontuação(ganhadores)
    return ganhadores

'''def pontuação(ganhadores):
    global score
    score = list()
    for j in ganhadores:
        score.append({f'{j}': })'''

    

