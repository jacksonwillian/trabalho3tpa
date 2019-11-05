# 11581 Grid Successors
# Autores: Jackson Willian

import sys

def transformaMatriz(vetor, p = -1):

	if p == -1 and True == isNula (vetor):
		print(p)
		return None
	else:

		A = [[0,0,0], [0,0,0], [0,0,0]]

		A[0][0] = (vetor[0][1] + vetor[1][0]) % 2
		A[0][1] = (vetor[0][0] + vetor[0][2] + vetor[1][1]) % 2
		A[0][2] = (vetor[0][1] + vetor[1][2]) % 2
		A[1][0] = (vetor[0][0] + vetor[2][0] + vetor[1][1]) % 2
		A[1][1] = (vetor[0][1] + vetor[1][0] + vetor[1][2] + vetor[2][1]) % 2
		A[1][2] = (vetor[0][2] + vetor[1][1] + vetor[2][2]) % 2
		A[2][0] = (vetor[1][0] + vetor[2][1] ) % 2
		A[2][1] = (vetor[2][0] + vetor[1][1] + vetor[2][2]) % 2
		A[2][2] = (vetor[1][2] + vetor[2][1] ) % 2

		if (True == isNula (vetor)):
			print(p)
			return None
		else:
			p = p + 1
			transformaMatriz(A, p)


def isNula (vetor):

	for i in range (0, 3):
		for j in range (0,3):

			if (vetor[i][j] != 0 ):
				return False
	return True


def main ():

	linha = sys.stdin.readline()

	if (linha != ""):
		quantMatriz = int(linha)

		for i in range (quantMatriz):
			matriz = []
			
			linha = sys.stdin.readline()
			linha = sys.stdin.readline()

			linhaMatriz = []
			linhaMatriz.append( int(linha[0]) )
			linhaMatriz.append( int(linha[1]) )
			linhaMatriz.append( int(linha[2]) )
			matriz.append( linhaMatriz )

			linha = sys.stdin.readline()
			linhaMatriz = []
			linhaMatriz.append( int(linha[0]) )
			linhaMatriz.append( int(linha[1]) )
			linhaMatriz.append( int(linha[2]) )
			matriz.append( linhaMatriz )

			linha = sys.stdin.readline()
			linhaMatriz = []
			linhaMatriz.append( int(linha[0]) )
			linhaMatriz.append( int(linha[1]) )
			linhaMatriz.append( int(linha[2]) )
			matriz.append( linhaMatriz )

			transformaMatriz( matriz )
			
main()			







