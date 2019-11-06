import java.util.BitSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        BitSet agenda_bit = new BitSet(1000010);
        String [] linha;

        String buf =  scanner.nextLine();
        linha = buf.split(" ");
        
        int quant_unico = Integer.parseInt(linha[0]);
        int quant_rept  = Integer.parseInt(linha[1]);
        
        int inic;
        int end;
        int inter;
       
        
        boolean no_conflit = true;
        
        while (scanner.hasNextLine()){
            
            buf = scanner.nextLine();
            linha = buf.split(" ");
            
            
            if(quant_unico > 0 && no_conflit){
                    
                    
                inic    = Integer.parseInt(linha[0]);
                end     = Integer.parseInt(linha[1]);
              
              
                if(agenda_bit.get(inic,end).cardinality()>0){
                    
                    no_conflit = false;
                    
                }else{
  
                    agenda_bit.set(inic, end);
                }
                    
                quant_unico--;
                
            }else if(quant_rept > 0 && no_conflit) {
                
                inic    = Integer.parseInt(linha[0]);
                end     = Integer.parseInt(linha[1]);
                inter   = Integer.parseInt(linha[2]);
                
                for(int i = 0; i < agenda_bit.size();i +=inter){
                    
                    if(agenda_bit.get(inic+i,end+i).cardinality()>0){
                    
                        no_conflit = false;

                    }else{
                        
                        agenda_bit.set(inic + i, end + i);
                    }
                
                }
                
                quant_rept--;
            
            }else{
                
                if(quant_unico == 0 && quant_rept == 0 && !buf.equals("")){
                        
                        quant_unico = Integer.parseInt(linha[0]);
                        quant_rept  = Integer.parseInt(linha[1]);
                        
                        if(no_conflit){
                            System.out.println("NO CONFLICT");

                        }else{
                            System.out.println("CONFLICT");
                            no_conflit = true;           
                        }
                        if(!buf.equals("")){
                            quant_unico = Integer.parseInt(linha[0]);
                            quant_rept  = Integer.parseInt(linha[1]);
                            agenda_bit.clear();
                        }
                }
            }
        }

        scanner.close();
    }
}
