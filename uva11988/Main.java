import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        LinkedList lista = new LinkedList();
        String linha,s;
        char [] c;
        boolean home = true;
        
        while(scanner.hasNextLine()){
            
            linha = scanner.nextLine();
            c = linha.toCharArray();
            
            for (int i = 0; i < c.length;i++){
                if(c[i] == '['){
                    home = true;
                }else if(c[i] == ']'){
                    home = false;
                }else{
                    if(home){
                        lista.addFirst(c[i]);
                    }else{
                        lista.addLast(c[i]);
                    }
                }
            
            }
            
            s = "";
            for(int i = 0; i < lista.size();i++){
                s += lista.get(i);
            }
            lista.clear();
            System.out.println(s);
            
        }       
    }
    
   
}
