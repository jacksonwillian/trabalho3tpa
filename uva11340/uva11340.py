# 11340 Newspaper
# Autores: Jackson Willian

import sys 

def main():

	quantTeste = int(sys.stdin.readline())
	for i in range (quantTeste):
		quantLinha = int(sys.stdin.readline())
		listaPreco = []
		for j in range (quantLinha):
			linha =  sys.stdin.readline()
			listaPreco.append( [  linha.split()[0], int( linha.split()[1] ) ] )

		valor = 0
		linha = ""
		quantLinha = int(sys.stdin.readline())
		for j in range (quantLinha):

			linha +=  sys.stdin.readline()

		for k in range ( len(listaPreco) ):
			frequencia = linha.count(listaPreco[k][0]) 
			valor += frequencia * listaPreco[k][1] if frequencia > 0 else 0
		print("%.2f$" %(valor/100))

	

	return 0

main()





