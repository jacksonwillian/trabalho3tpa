/* Main.java
 * UVa 10038 - Jolly Jumpers
 * Autores: Jackson Willian
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i  = 0, j = 0;
		int tamanho = 0;
		int valor = 0;
		String resposta;

		while( scanner.hasNext() ) {
			String linha = scanner.nextLine();
			String[] listaNumero  = linha.split(" ");

			tamanho = listaNumero.length;
			ArrayList<Integer> arrayNumero = new ArrayList<Integer>();
			arrayNumero.add(Integer.parseInt(listaNumero[0]));
			for (i = 0; i < tamanho; i++){
				   valor = Integer.parseInt(listaNumero[i]);
					arrayNumero.add(valor);
				    j = i-1;
				    while (( j >= 0) && (arrayNumero.get(j) < valor )){
				    	arrayNumero.set(j+1, arrayNumero.get(j));	
						j = j -1;
				    }
				 arrayNumero.set(j+1, valor);
			}

			resposta = isJolly(arrayNumero) ? "Jolly" : "Not jolly";
		    System.out.println( resposta );
		}

		scanner.close();
	}


	public static boolean isJolly (ArrayList arrayNumero){
		int valorA, valorB;
		for (int i = 0; i < (arrayNumero.size() - 1) ; i+=2){
			valorA = (Integer)arrayNumero.get(i);
			valorB = (Integer)arrayNumero.get(i+1);
			 // System.out.println( valorA );
			 System.out.println( valorA +","+ valorB );
		    // if (( valorA != valorB) &&  (Math.abs( valorA - valorB) != 1)){
		    // 	 System.out.println( valorA +","+ valorB );
		    //     return false;
		    // }
		}
		return true;
	}
}


		// 	if (Integer.parseInt(cartas2[0]) != 0){

		// 		ArrayList<Integer> principe = new ArrayList<Integer>();
		// 		ArrayList<Integer> princesa = new ArrayList<Integer>();

		// 		princesa.add( Integer.parseInt(cartas2[0]) );
		// 		princesa.add( Integer.parseInt(cartas2[1]) );
		// 		princesa.add( Integer.parseInt(cartas2[2]) );
		// 		principe.add( Integer.parseInt(cartas2[3]) );
		// 		principe.add( Integer.parseInt(cartas2[4]) );
				
		// 		Collections.sort(princesa, Collections.reverseOrder());
		// 		Collections.sort(principe, Collections.reverseOrder());

		// 		if(princesa.get(0) > principe.get(0) && princesa.get(1) > principe.get(1)){

		// 			System.out.println("-1");

		// 		}else if (princesa.get(0) < principe.get(0)  &&  princesa.get(1) > principe.get(1)  ){

		// 			valor = carta (princesa.get(0) + 1 , principe, princesa );
		// 			System.out.println(Integer.toString( valor) );

		// 		}else if (( princesa.get(0) > principe.get(0))  &&  ( princesa.get(1) < principe.get(1) ) ){
					
		// 			valor = carta ( princesa.get(1) + 1 , principe, princesa );
		// 			System.out.println(Integer.toString( valor) );
		// 		}else if ( princesa.get(0) < principe.get(0) &&  princesa.get(1) < principe.get(1)  &&  princesa.get(0) > principe.get(1)  ){

		// 			valor = carta ( princesa.get(1) + 1, principe, princesa );
		// 			System.out.println(Integer.toString( valor) );

		// 		}else if (princesa.get(0) < principe.get(0) &&  princesa.get(1) < principe.get(1)   &&  princesa.get(0) <= principe.get(1)  ){

		// 			valor = carta ( 1 , principe, princesa );
		// 			System.out.println(Integer.toString( valor) );
		// 		}
			
		// 	}else{
		// 		c = false;
		// 	}
		// }
