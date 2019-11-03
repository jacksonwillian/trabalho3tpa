

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main implements Comparable<Main> {

    private int id_time;
    private int quant_acerto;
    private int time_penalidade;
    
    public Main(){}
    
    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public int getQuant_acerto() {
        return quant_acerto;
    }

    public void setQuant_acerto(int quant_acerto) {
        this.quant_acerto = quant_acerto;
    }

    public int getTime_penalidade() {
        return time_penalidade;
    }

    public void setTime_penalidade(int time_penalidade) {
        this.time_penalidade = time_penalidade;
    }
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Main> lista = new ArrayList();
            Map<String,Integer> mapinha = new HashMap();
            
            String [] linha;
            String buf = scanner.nextLine();
            String id_atual;
            String status_env;
            
            int index_global = -1;
            
            int chave;
            int acertos;
            int penalidade;
            
            
            int quant_problem = Integer.parseInt(buf);
            
            while (scanner.hasNextLine()){
                
                buf = scanner.nextLine();
                linha = buf.split(" ");
                
                if(!"".equals(buf)){
                    
                    id_atual    = linha[0];
                    status_env  = linha[3];
                    
                    
                    //Se existe um time no já registrado
                    if(mapinha.containsKey(id_atual)){
                        
                        //Criar um time aux;
                        Main aux_time = new Main();
                        
                        //Se a resposta for correta
                        if(status_env.equalsIgnoreCase("C")){
                            
                            chave       = mapinha.get(id_atual);
                            acertos     = lista.get(chave).getQuant_acerto() + 1;
                            penalidade  = lista.get(chave).getTime_penalidade();
                            penalidade += Integer.parseInt(linha[2]);
                            
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                            //Se for incorreta
                        }else if(status_env.equalsIgnoreCase("I")){
                            
                            //Pega o index da lista, com base no mapa;
                            chave       = mapinha.get(id_atual);
                            //Pega o numero de acertos;
                            acertos     = lista.get(chave).getQuant_acerto();
                            //Pega a penalidade soma 20 por está incorreto;
                            penalidade  = lista.get(chave).getTime_penalidade() + 20;
                            
                            //Atualiza o aux;
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                            
                            //Qualquer um dos outros casos
                        }else{
                            
                            chave       = mapinha.get(id_atual);
                            acertos     = lista.get(chave).getQuant_acerto();
                            penalidade  = lista.get(chave).getTime_penalidade();
                            
                            
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                        }
                        
                        //ADD;
                        lista.set(chave,aux_time);
                        
                    }else{
                        
                        //Criar um time aux;
                        Main aux_time = new Main();
                        
                        if(status_env.equalsIgnoreCase("C")){
                            
                            
                            acertos     = 1;
                            penalidade  = Integer.parseInt(linha[2]);
                            
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                            
                        }else if(status_env.equalsIgnoreCase("I")){
                            
                            acertos     = 0;
                            penalidade  = 20;
                            
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                        }else{
                            
                            acertos     = 0;
                            penalidade  = 0;
                            
                            aux_time.setId_time(Integer.parseInt(id_atual));
                            aux_time.setQuant_acerto(acertos);
                            aux_time.setTime_penalidade(penalidade);
                            
                        }
                        index_global++;
                        mapinha.put(id_atual, index_global);
                        //ADD;
                        lista.add(aux_time);
                        
                        
                    }
                    
                }
            }
               
            Collections.sort(lista);
            
            for (int i=0; i< lista.size();i++){
                System.out.println(lista.get(i).getId_time()+" "+lista.get(i).getQuant_acerto() +" "+lista.get(i).getTime_penalidade());
                //System.out.println(lista_time.get(i).getId_time());
                //System.out.println(lista_time.get(i).getId_time());
            }
        }
      
    }

    @Override
    public int compareTo(Main a) {
         if(this.getQuant_acerto()> a.getQuant_acerto()){
            return 1;    
        }else if(this.getQuant_acerto()< a.getQuant_acerto()){
            return 0;
        }else{
            if(this.getTime_penalidade() > a.getTime_penalidade()){
                return 0;
            }else{
                return 1;
            }
        }
    }

        
}
    

