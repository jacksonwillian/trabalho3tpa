
import sys 


# Autores: Jackson Willian
# Problema: UVa 11100 –  The Trip, 2007 


def addBolsa(setBolsa, bolsa):

	menor = -1
	indice = -1
	for i in range( len(setBolsa) ):
		if (menor == -1) or ( menor > len(setBolsa[i]) ):
			menor = len(setBolsa[i])
			indice = i

	if (indice != -1) and (bolsa not in setBolsa[indice]):

		setBolsa[indice].append(bolsa)
		setBolsa[indice].sort()
		
	return None

		


def quantListas( lstBolsas ):
	conjunto =  set(lstBolsas)
	maior = 0
	for i in conjunto:
		freq = lstBolsas.count(i)
		if ( maior <  freq):
			maior = freq
	return maior
			
	
	
	
	
	
	
	

	
	
	
	


def main():
	
	quantTeste = int( sys.stdin.readline() )
	
	while ( quantTeste != 0 ):
		
		lstBolsas = []
	
		texto = sys.stdin.readline()
		texto = texto.strip()
			
		for bolsa in texto.split(" "):
			if (bolsa != " " and bolsa != ""):
				lstBolsas.append( int(bolsa) )

		lstBolsas.sort()

		tamanho = quantListas( lstBolsas )
		
		setBolsa = []
		for i in range (tamanho):

			setBolsa.append([])

	
		

		for bolsa in lstBolsas:

			addBolsa(setBolsa, bolsa)

		print(len(setBolsa))
		for sets in setBolsa:
			linha = ""
			for bolsa in sets:
				linha += str(bolsa) + " "
			print(linha.strip())

		quantTeste = int( sys.stdin.readline() )

		if(quantTeste != 0):
			print()
		
	return 0
	
main()

