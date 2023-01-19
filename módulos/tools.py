def start():
    """Inicia as partidas, mostra o resultado de cada uma e a pontuação geral"""
    global jogadores
    jogadores = list()
    while len(jogadores) != 1:
        entrada()
        resultado()
        pontuação()    
        
        
def entrada():  
    """ Recebe os dados dos jogadores e insere todos em uma 
    lista global composta por dicionários
    """
    partida = 1
    rodadas = 0
    if len(jogadores) == 0 or len(jogadores) == 5:
        njogadas = 5  # Num de jogadores por rodada
    elif len(jogadores) == 4:
        njogadas = 4
    elif len(jogadores) == 3:
        njogadas = 3
    elif len(jogadores) == 2:
        njogadas = 2
    while partida < njogadas + 1:
        try:
            numero = int(input(f'Jogador {partida}: '))
            if 0 <= numero <= 100:
                jogadores.append({f'Jogador {partida}': numero})
                partida += 1
            else:
                raise ValueError
        except ValueError:
            print('Insira um valor válido.')
    rodadas +=1
    

def resultado(): 
    """ Calcula a média dos números na lista jogadores
    multiplicada por 0.8
    """
    global total
    jogadas = [int(jogador[f'Jogador {i + 1}']) for i, jogador in enumerate(jogadores)] 
    total = sum(jogadas) / len(jogadores) * 0.8
    print(total)
    print(vencedor(jogadas, total))


def vencedor(lista, n): 
    """ Determina quais jogadores escolheu o número mais próximo do resultado
    """
    global ganhadores
    ganhadores = list()
    maisprox = min(lista, key=lambda x: abs(x-n))
    for i, jogador in enumerate(jogadores):
        if maisprox == int(jogador[f'Jogador {i + 1}']):
            ganhadores.append({'Ganhador': f'Jogador {i + 1}'})
    return ganhadores


def pontuação():
    """Pontuação geral dos jogadores"""
    global score
    lista = list()
    score = list()
    numJogadores = len(jogadores)
    totalInt = round(total)
    cemZero = True
    
    if len(score) == 0: # Inicializa as listas
        for i in range(0, numJogadores):
            score.append({f'Jogador {i + 1}': 0})
            lista.append(f'Jogador {i + 1}')
    if numJogadores > 2:
        for i in range(0, numJogadores):
            score[i][f'Jogador {i + 1}'] -= 1

    if numJogadores == 5: 
        for i in range(0, len(ganhadores)):
            for c, valor in enumerate(lista):
                if valor == ganhadores[i]['Ganhador']:
                    score[c][f'Jogador {c + 1}'] += 1
    elif numJogadores == 4:
        if len(ganhadores) == 1: # Se não há jogadas repetidas (Regra com 4 pessoas)
            for i in range(0, len(ganhadores)):
                for c, valor in enumerate(lista):
                    if valor == ganhadores[i]['Ganhador']:
                        score[c][f'Jogador {c + 1}'] += 1
    elif numJogadores == 3:
        for i in range(0, 3): 
            if jogadores[i][f'Jogador {i + 1}'] == totalInt: # Se acertou o número exato (Regra com 3 pessoas)
                score[i][f'Jogador {i + 1}'] -= 1
        if len(ganhadores) == 1:
            for i in range(0, len(ganhadores)):
                for c, valor in enumerate(lista):
                    if valor == ganhadores[i]['Ganhador']:
                        score[c][f'Jogador {c + 1}'] += 1
            for i in range(0, 3):
                if jogadores[i][f'Jogador {i + 1}'] == totalInt: 
                    score[i][f'Jogador {i + 1}'] -= 1
    elif numJogadores == 2:
            for i in range(0, 2):
                for c in range(0, 2):
                    if jogadores[i][f'Jogador {i + 1}'] == 0:
                        if jogadores[c][f'Jogador {c + 1}'] == 100:
                            score[i][f'Jogador {i + 1}'] -= 1 # Se jogaram 100 e 0 (Regra com 2 pessoas)
                            cemZero = False           
            if cemZero:
                for i in range(0, 2):
                    score[i][f'Jogador {i + 1}'] -= 1
                for i in range(0, 2):
                    if jogadores[i][f'Jogador {i + 1}'] == totalInt:
                        score[i][f'Jogador {i + 1}'] -= 1
                if len(ganhadores) == 1:
                    for i in range(0, len(ganhadores)):
                            for c, valor in enumerate(lista):
                                if valor == ganhadores[i]['Ganhador']:
                                    score[c][f'Jogador {c + 1}'] += 1
                    for i in range(0, 2):
                        if jogadores[i][f'Jogador {i + 1}'] == totalInt: 
                            score[i][f'Jogador {i + 1}'] -= 1
    print(totalInt)
    print(score)
    jogadores.clear()     
