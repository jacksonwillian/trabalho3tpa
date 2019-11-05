/* Main.java
 * 10107 - What is the Median?
 * Autores: Jackson Willian
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;

class Main {

	public static void main(String[] args) {
		
		BufferedReader br;
		String linha;
		ArrayList<Long> lista;
		int i;
		Long mediana = (long) 0;

		br = new BufferedReader(new InputStreamReader(System.in));
		lista = new ArrayList<Long>();

		try {
			linha =  br.readLine();
			while( linha != null ) {
				
				lista.add(Long.parseLong(linha.trim() ));
				Collections.sort( lista );
				i = lista.size();
				if ((i % 2) != 0){
					mediana = lista.get( (i / 2) );
				}else{
					mediana = (Long) (lista.get( ((int ) (i / 2)) - 1  ) +  lista.get( (int ) (i / 2) ) ) / 2;
				}
				// System.out.println(lista);
				System.out.println(mediana);
			    linha =  br.readLine();
			}
	    }
	    catch (Exception  e){
	        System.out.println(e);
	    }
		
	}

}
