/*
    # Emanuel Rampinelli Gloria
    # uva 11988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        LinkedList lista = new LinkedList();
        
        String linha;
        char [] c;
        int pont;
       
        try{
            
            linha =  buf.readLine();
            
            while(linha !=null){
                
                c = linha.toCharArray();

                pont = 0;

                for (int i = 0; i < c.length;i++){

                    if(c[i] == '['){
                        pont = 0;
                    }else if(c[i] == ']'){
                        pont = lista.size();
                    }else{
                        lista.add(pont++,c[i]);
                    }

                }
                for(int j = 0; j < lista.size();j++){
                    System.out.print(lista.get(j));
                }
                
                System.out.print("\n");
                lista.clear();
                
                linha =  buf.readLine();
            }
        }catch(Exception e){
            System.out.print(e);
        }
       
    }

}
