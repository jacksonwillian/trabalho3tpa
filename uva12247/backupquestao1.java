/* Main.java
 * UVa 12247 - Jollo
 * Autores: Jackson Willian
 */

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Questao1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean c = true;
		while( c ) {
			int valor = 0;
			String cartas = scanner.nextLine();
			String[] cartas2  = cartas.split(" ");

			if (Integer.parseInt(cartas2[0]) != 0){

				List<Integer> principe = new ArrayList<Integer>();
				List<Integer> princesa = new ArrayList<Integer>();

				princesa.add( Integer.parseInt(cartas2[0]) );
				princesa.add( Integer.parseInt(cartas2[1]) );
				princesa.add( Integer.parseInt(cartas2[2]) );
				principe.add( Integer.parseInt(cartas2[3]) );
				principe.add( Integer.parseInt(cartas2[4]) );
				
				Collections.sort(princesa, Collections.reverseOrder());
				Collections.sort(principe, Collections.reverseOrder());

				if(princesa.get(0) > principe.get(0) && princesa.get(1) > principe.get(1)){

					System.out.println("-1");

				}else if (princesa.get(0) < principe.get(0)  &&  princesa.get(1) > principe.get(1)  ){

					valor = princesa.get(0) + 1;
					while ( valor <= 52 && (principe.contains(valor) || princesa.contains(valor))){
				 		valor += 1;
					}

					if (valor == 53){
						valor = -1;
					}
					
					System.out.println(Integer.toString( valor) );

				}else if (( princesa.get(0) > principe.get(0))  &&  ( princesa.get(1) < principe.get(1) ) ){
					// aqui
					valor = princesa.get(1) + 1;
					while ( valor <= 52 && (principe.contains(valor) || princesa.contains(valor))){
				 		valor += 1;
					}

					if (valor == 53){
						valor = -1;
					}
					
					System.out.println(Integer.toString( valor) );
				}else if ( princesa.get(0) < principe.get(0) &&  princesa.get(1) < principe.get(1)  &&  princesa.get(0) > principe.get(1)  ){

					valor = princesa.get(1) + 1;
					while (principe.contains(valor) || princesa.contains(valor)){
				 		valor += 1;
					}
					System.out.println(Integer.toString( valor) );

				}else if (princesa.get(0) < principe.get(0) &&  princesa.get(1) < principe.get(1)   &&  princesa.get(0) <= principe.get(1)  ){

					valor = 1;
					while (principe.contains(valor) || princesa.contains(valor)){
				 		valor += 1;
					}
					System.out.println(Integer.toString( valor) );
				}
			
				c = scanner.hasNext();

			}else{
				c = false;
			}
		}
		scanner.close();

	}
}