/* Main.java
 * UVA 10038 - Jolly Jumpers
 * Autores: Jackson Willian
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

class Main {

	public static void main(String[] args) {
		
		Scanner scanner;  
		String linha, resposta;
		String[] vetorNumeros;

		scanner = new Scanner(System.in);
		while( scanner.hasNext() ) {
			linha = scanner.nextLine();
			vetorNumeros  = linha.split(" ");
			resposta = isJolly(vetorNumeros) ? "Jolly" : "Not jolly";
		    System.out.println( resposta );
		}
		scanner.close();
	}


	public static boolean isJolly (String[] vetorNumeros){
		
		ArrayList<Integer> listaDiferenca = new ArrayList<Integer>();
		int tamanhoVetor, tamanhoLista, i, valorA, valorB;

		tamanhoVetor = Integer.parseInt(vetorNumeros[0]);
		i = 1;
		while (i < tamanhoVetor){
			valorA = Integer.parseInt(vetorNumeros[i]);
			valorB = Integer.parseInt(vetorNumeros[i+1]);
			listaDiferenca.add( Math.abs(valorA - valorB) );
			i++;
		}

		Collections.sort( listaDiferenca, Collections.reverseOrder() );

		tamanhoLista = listaDiferenca.size();
		if ( tamanhoLista == 0){
			return true;
		}else if ( (listaDiferenca.get( tamanhoLista - 1 ) != 1) || (listaDiferenca.get( 0 ) != (tamanhoVetor - 1) )) {
			return false;
		}else{
			for(i = 0; i < (tamanhoLista - 1); i++ ){
				if( Math.abs( listaDiferenca.get(i) - listaDiferenca.get(i+1) ) > 1 ){
					return false;
				}
			}
			return true;
		}
	}
}

