/*
    # Emanuel Rampinelli Gloria
    # uva 11988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> lista = new LinkedList();
    
        String linha;
        char [] c;
        
        int indicador;
       
        try{
            
            linha =  buf.readLine();
            
            while(linha !=null){
                
                c = linha.toCharArray();

                indicador = 0;

                for (int i = 0; i < c.length;i++){

                    if(c[i] == '['){
                        indicador = 0;
                    }else if(c[i] == ']'){
                        indicador = lista.size();
                    }else{
                        lista.add(indicador++,c[i]);
                    }

                }
                
                StringBuilder res = new StringBuilder();
                for (char x : lista) res.append(x);
                
                System.out.println(res.toString());
                
                lista.clear();
                linha =  buf.readLine();
            }
        }catch(Exception e){
            System.out.print(e);
        }
       
    }

}
