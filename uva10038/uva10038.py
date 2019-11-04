import sys


def isJolly(lista):


	tamanho = int (lista[0])

	listaDiferencaAbsoluta = []

	i = 1
	while (i < tamanho):
		# print(lista[i], lista[i+1])
		listaDiferencaAbsoluta.append(abs(lista[i] - lista[i+1]))
		i += 1

	# print(listaDiferencaAbsoluta)

	listaDiferencaAbsoluta.sort(reverse = True)
	# print(listaDiferencaAbsoluta,end="")

	if (len(listaDiferencaAbsoluta) == 0 ):
		return True
	else:


		if (listaDiferencaAbsoluta[-1] != 1 or listaDiferencaAbsoluta[0] != (tamanho - 1)):
			return False
			
		for i in range (len(listaDiferencaAbsoluta)-1):

			if (abs(listaDiferencaAbsoluta[i] - listaDiferencaAbsoluta[i+1]) > 1) :

				return False

		return True


def main():

	linha = sys.stdin.readline()
	while ( linha != ""):

		lista = []
		for elemento in linha.split(): 
			lista.append( int(elemento) )

		resposta = "Jolly" if isJolly(lista) else "Not jolly"
		print(resposta)

		linha = sys.stdin.readline()

	return 0

main() 