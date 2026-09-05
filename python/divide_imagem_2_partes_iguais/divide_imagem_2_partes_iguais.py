# $ sudo pip install opencv-python

import cv2
import os

## COLETA ARQUIVO
nome_arquivo = 'CMYK.png'
diretorio = nome_arquivo[:-4]

## ARMAZENA
img = cv2.imread(nome_arquivo)
altura, largura = img.shape[:2]

## CALCULA PONTOS MEDIOS
# [x, y, h, w]
esquerda = [0, 			0, 			(altura),	(largura/2)] 
direita = [(largura/2), 0, 			(altura),	(largura/2)]

cima = [0, 			0, 			(altura/2),	(largura)] 
baixo = [0,			(altura/2),	(altura/2),	(largura)] 

## REFERENCIA
nomes = ['esquerda','direita', 'cima', 'baixo']
mtr = [esquerda, direita, cima, baixo]

## CORTA IMAGENS
c = -1
for v in mtr:	
	crop_img = img[v[1]:v[1]+v[2], v[0]:v[0]+v[3]]
	try:
		os.stat(diretorio)
	except:
		os.mkdir(diretorio)
	c+=1
	cv2.imwrite(os.path.join(diretorio , nome_arquivo[:-4]+'_'+nomes[c]+'_.png'), crop_img)
