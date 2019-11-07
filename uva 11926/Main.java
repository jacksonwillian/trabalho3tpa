import java.util.BitSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        BitSet agenda_bit = new BitSet(1000001);
        String [] linha;

        String buf =  scanner.nextLine();
        linha = buf.split(" ");
        
        int quant_unico;
        int quant_rept;
        
        int inic;
        int end;
        int inter;
       
        
        boolean conflit;
        
        while (scanner.hasNextLine() && !buf.equals("0 0")){
            
            conflit = false;
            
            quant_unico = Integer.parseInt(linha[0]);
            quant_rept  = Integer.parseInt(linha[1]);
            
            //System.out.println(quant_unico + " " + quant_rept);
            
            for(int i = 0; i < quant_unico;i++){
                
                buf = scanner.nextLine();
                linha = buf.split(" ");
                //System.out.println(buf);
                

                inic    = Integer.parseInt(linha[0]);
                end     = Integer.parseInt(linha[1]);

                if(!conflit){
                    for(int j = inic; j < end ; j++){
                        if(agenda_bit.get(j)){
                            conflit = true;
                            break;
                        }

                            agenda_bit.set(j,true);
                    }
                }
                
            }
            
            for(int i = 0; i < quant_rept;i++){
                
                buf = scanner.nextLine();
                linha = buf.split(" ");
                
                
                    
                inic    = Integer.parseInt(linha[0]);
                end     = Integer.parseInt(linha[1]);
                inter   = Integer.parseInt(linha[2]);

                if(!conflit){

                    while(inic < agenda_bit.size() && end < agenda_bit.size()){

                        for(int j = inic; j < end ;j++){
                            if(agenda_bit.get(j)){
                                conflit = true;
                                break;

                            }
                            agenda_bit.set(j,true);

                        }
                        inic += inter;
                        end += inter;
                        
                        if(end > agenda_bit.size()-1){
                            end = agenda_bit.size()-1;
                        }
                    }
                }
            }

            
            
            if(conflit){
                System.out.println("CONFLICT");
            }else{
                System.out.println("NO CONFLICT");
            }
            
            buf = scanner.nextLine();
            linha = buf.split(" ");
            
            agenda_bit.clear();

            
        }
        // System.out.println();
        scanner.close();
    }
}
