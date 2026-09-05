import os

extensao = '.png'

for raiz, diretorios, arquivos in os.walk('pasta/'):
    for arquivo in arquivos:
        if extensao not in arquivo:
            continue
		#faca alguma coisa com cada arquivo
        print(arquivo)
