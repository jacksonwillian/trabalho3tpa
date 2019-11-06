# 10920 - Spiral Tap
# Autores: Jackson Willian

import sys

def SpiralTap(ordem, numero):
	if (ordem % 2 != 0):
		meio = int(ordem / 2)
		if (numero == 1):
			return meio+1, meio+1
		elif (numero == (ordem**2) ):
			return ordem, ordem
		else:
			# submatriz comeca em ordem 3
			# anel , min , max, ordem, 
			anel = False
			subMatriz = [1, 2, 9, 3]
			while (anel == False) and ( subMatriz[2] < ordem**2):
				if (numero >= subMatriz[1]) and ( numero <= subMatriz[2] ): 
					anel = True
				else:
					subMatriz[0] += 1
					subMatriz[1] = subMatriz[2] + 1
					subMatriz[3] = subMatriz[3] + 2
					subMatriz[2] = subMatriz[3]**2

			linhaAcima = meio + subMatriz[0]
			colunaEsquerda = meio - subMatriz[0]
			linhaAbaixo = meio - subMatriz[0] 
			colunaDireita = meio + subMatriz[0]


			achou = False
			valorMaximo = subMatriz[2] # do anel
			espaco = subMatriz[3] - 1 # valor do quanto deve ser subtraido para encontrar o valor que está na linha

			intervalor1 = [ valorMaximo - espaco, valorMaximo]
			intervalor2 = [ valorMaximo - (espaco * 2), valorMaximo - espaco]
			intervalor3 = [ valorMaximo - (espaco * 3) , valorMaximo - (espaco * 2)]
			intervalor4 = [ valorMaximo - (espaco * 4) , valorMaximo - (espaco * 3)]

			if( numero >=  intervalor1[0] and numero <= intervalor1[1] ):
				valor = intervalor1[1]
				linhaAcima = linhaAcima - (valor - numero)
				return linhaAcima+1, colunaDireita+1
			elif( numero >=  intervalor2[0] and numero <= intervalor2[1] ):
				valor = intervalor2[1]
				colunaDireita = colunaDireita - (valor - numero)
				return linhaAbaixo+1, colunaDireita+1
			elif( numero >=  intervalor3[0] and numero <= intervalor3[1] ):
				valor = intervalor3[1]
				linhaAbaixo = linhaAbaixo + (valor- numero)
				return linhaAbaixo+1 , colunaEsquerda+1		
			elif ( numero >=  intervalor4[0] and numero <= intervalor4[1] ):
				valor = intervalor4[1]
				colunaEsquerda =  colunaEsquerda + (valor - numero)
				return linhaAcima+1, colunaEsquerda+1


def main():

	linha = sys.stdin.readline()
	while(linha != ""):
		ordem = int( str(linha.split()[0]) )
		numero = int( str(linha.split()[1]) )
		if(ordem !=0 and numero != 0):
			lin, col = SpiralTap(ordem, numero)
			print("Line = {}, column = {}.".format(lin, col))
		linha = sys.stdin.readline()
	
	return 0

main()