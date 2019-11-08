/* Main.java
 * 11849 - CD
 * Autores: Jackson Willian
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Iterator; 

class Main {

    public static void main(String[] args) {
        BufferedReader br;
        int quantJack, quantJill, quantCdVenda;
        String linha;
        TreeSet<Integer> cdsJack, cdsJill;
        Iterator<Integer> disco;
        boolean equivalente;

        br = new BufferedReader(new InputStreamReader(System.in));

        try {

            linha =  br.readLine();
            while(! linha.equals("0 0")) {
              
                cdsJack = new TreeSet<Integer>();
                cdsJill = new TreeSet<Integer>();

                quantJack = Integer.parseInt(linha.split(" ")[0]);
                quantJill = Integer.parseInt(linha.split(" ")[1]);

                for (int i = 0; i < quantJack; i++){
                	linha =  br.readLine();
                	cdsJack.add( Integer.parseInt(linha) );
                }


                for (int i = 0; i < quantJill; i++){
                	linha =  br.readLine();
                	cdsJill.add( Integer.parseInt(linha) );
                }

                quantCdVenda = 0;
                disco = cdsJack.iterator();
                while (disco.hasNext()) { 

                    equivalente = cdsJill.contains( disco.next() );
            		if ( equivalente ){
                        quantCdVenda += 1;
                    } 
        		} 

                System.out.println(quantCdVenda);

               	linha =  br.readLine();              
            }
        }
        catch (Exception  e){
            System.out.println(e);
        }
      
    }

         

 }



