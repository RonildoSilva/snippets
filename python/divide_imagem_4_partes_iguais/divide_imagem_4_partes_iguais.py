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
inf_esq = [0,			(altura/2),	(altura/2),	(largura/2)] 
sup_esq = [0, 			0, 			(altura/2),	(largura/2)] 
inf_dir = [(largura/2), (altura/2),	(altura), 	(largura)]
sup_dir = [(largura/2), 0, 			(altura/2),	(largura/2)]

## REFERENCIA
nomes = ['inf_esq','sup_esq','inf_dir','sup_dir']
mtr = [inf_esq, sup_esq, inf_dir, sup_dir]

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
