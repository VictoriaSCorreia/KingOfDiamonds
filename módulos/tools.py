def entrada():  
    """ Recebe os dados dos jogadores e insere todos em uma 
    lista global composta por dicionários
    """
    global jogadores
    jogadores = list()
    jogador = dict()
    for c in range(0, 5):
        while True:
            jogador[f'Jogador {c+1}'] = input(f'Jogador {c+1}: ').strip()
            if entradaperm(jogador[f'Jogador {c+1}']):
                break
            else:
                print('Insira um valor válido.')
        jogadores.append(jogador.copy())
        jogador.clear()

def entradaperm(n):  
    """ Valida se o dado é um número inteiro de 0 a 100 
    :param n: dado a ser validado
    :return: valor bool
    """
    if str(n).isnumeric():
        ninteiro = int(n)
        if 0 <= ninteiro <= 100:
            return True

def resultado(): 
    """ Calcula a média dos números na lista jogadores no método entrada()
    multiplicada por 0.8
    """
    jogadas = list()
    soma = 0
    for c in range(0, len(jogadores)):
        jogadas.append(int(jogadores[c][f'Jogador {c+1}'])) # Necessário para converter os dados str em int
    for j in jogadas:
        soma += j
    total = (soma / len(jogadores) * 0.8)
    print(total)
    print(vencedor(jogadas, total))

def vencedor(lista, n): 
    """ Determina quais jogadores escolheu o número mais próximo do resultado
    :param lista: lista das jogadas
    :param n: resultado 
    :return: ganhadores
    """
    ganhadores = list()
    ganhador = dict()
    for c in range(0, len(lista)):
        if n > lista[c]:
            diferença = n - lista[c]
        else:
            diferença = lista[c] - n
        if c == 0:
            maisprox = diferença 
            num = lista[c]
        else:
            if diferença <= maisprox:
                maisprox = diferença
                num = lista[c]
    for c in range(0, len(lista)):
        if num == lista[c]:
            ganhador['Vencedor'] = f'Jogador {c+1}'
            ganhadores.append(ganhador.copy())
    return ganhadores
    