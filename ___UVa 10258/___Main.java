/*import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main implements Comparable<Main> {

    private int id_time;
    private int quant_acerto;
    private int time_penalidade;
    private boolean status_acerto;
    private boolean apareceu;
 
    public Main(){}
    
    public boolean isApareceu() {
        return apareceu;
    }

    public void setApareceu(boolean apareceu) {
        this.apareceu = apareceu;
    }
    
    
    public boolean isStatus_acerto() {
        return status_acerto;
    }

    public void setStatus_acerto(boolean status_acerto) {
        this.status_acerto = status_acerto;
    }
     
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
            
            int id_team;
            int acertos;
            int penalidade;
            boolean atual_acerto;
            boolean atual_apareceu;
            
            int quant_problem = Integer.parseInt(buf);
            int quant_resolvido = 0;
            buf = scanner.nextLine();
            
            while (scanner.hasNextLine()){
                
                buf = scanner.nextLine();
                linha = buf.split(" ");
                
                if(!"".equals(buf)){
                    
                    id_atual    = linha[0];
                    status_env  = linha[3];

                    //Se existe um time no já registrado
                    if(mapinha.containsKey(id_atual)){
                        
                        //Se a resposta for correta
                        if(status_env.equalsIgnoreCase("C")){
                            
                            chave       = mapinha.get(id_atual);
                            
                            id_team     = Integer.parseInt(id_atual);
                            acertos     = lista.get(chave).getQuant_acerto() + 1;
                            penalidade  = lista.get(chave).getTime_penalidade();
                            penalidade += Integer.parseInt(linha[2]);
                            
                            atual_apareceu = true;
                            atual_acerto = true;
                            
                            
                            
                        //Se for incorreta
                        }else if(status_env.equalsIgnoreCase("I")){
                            
                            //Pega o index da lista, com base no mapa;
                            chave       = mapinha.get(id_atual);
                            
                            //Pega id do Team;
                            id_team     = Integer.parseInt(id_atual);
                            //Pega o numero de acertos;
                            acertos     = lista.get(chave).getQuant_acerto();
                            //Pega a penalidade soma 20 por está incorreto;
                            penalidade  = lista.get(chave).getTime_penalidade();
                            atual_acerto = lista.get(chave).isStatus_acerto();
                            atual_apareceu = true;
                            
                            if(!atual_acerto){
                                penalidade+=20;
                            }
                                
                        //Qualquer um dos outros casos
                        }else{
                            
                            chave       = mapinha.get(id_atual);
                            
                            id_team     = Integer.parseInt(id_atual);
                            acertos     = lista.get(chave).getQuant_acerto();
                            penalidade  = lista.get(chave).getTime_penalidade();
                            atual_acerto = lista.get(chave).isStatus_acerto();
                            atual_apareceu = true;
                        }
                        
                        //Atualiza o team;
                        Main aux_time = f_montaTeam(id_team,acertos,penalidade,atual_acerto,atual_apareceu);
                        lista.set(chave,aux_time);
                        
                    }else{
                        
                        //Pega ID do Team;
                        id_team = Integer.parseInt(id_atual);
                        
                        if(status_env.equalsIgnoreCase("C")){
                                
                            acertos     = 1;
                            penalidade  = Integer.parseInt(linha[2]);
                            atual_acerto = true;
                            atual_apareceu = true;
                            
                           
                        }else if(status_env.equalsIgnoreCase("I")){
                            
                            acertos     = 0;
                            penalidade  = 20;
                            atual_acerto = false;
                            atual_apareceu = true;
                        }else{
                            
                            acertos     = 0;
                            penalidade  = 0;
                            atual_acerto = false;
                            atual_apareceu = true;
                           
                        }
                        
                        index_global++;
                        mapinha.put(id_atual, index_global);
                        
                        //ADD;
                        Main aux_time = f_montaTeam(id_team,acertos,penalidade,atual_acerto,atual_apareceu);
                        lista.add(aux_time);
                        
                        
                    }
                    
                }else{
                    
                    Collections.sort(lista);
                    
                    for (int i=0; i< lista.size();i++){
                        
                        if(lista.get(i).isApareceu()){
                           
                            
                            if(lista.get(i).getQuant_acerto() == 0){
                                lista.get(i).setTime_penalidade(0);
                            }
                            
                            System.out.println(lista.get(i).getId_time()+" "+lista.get(i).getQuant_acerto() +" "+lista.get(i).getTime_penalidade());
                            
                            lista.get(i).setQuant_acerto(0);
                            lista.get(i).setTime_penalidade(0);
                            lista.get(i).setStatus_acerto(false);
                            lista.get(i).setApareceu(false);
                        }
                        
                        
                    }
                    
                    

                    System.out.printf("\n");
                    
                    
                    
                    
                }
                
            }
               
        Collections.sort(lista);
        for (int i=0; i< lista.size();i++){
            if(lista.get(i).isApareceu()){
                if(lista.get(i).getQuant_acerto() == 0){
                    lista.get(i).setTime_penalidade(0);
                }
                
                System.out.println(lista.get(i).getId_time()+" "+lista.get(i).getQuant_acerto() +" "+lista.get(i).getTime_penalidade());
                lista.get(i).setQuant_acerto(0);
                lista.get(i).setTime_penalidade(0);
            }                //System.out.println(lista_time.get(i).getId_time());
        }
        System.out.println();
        }
      
    }

    public static Main f_montaTeam(int id,int acertos,int penalidade,boolean status_acerto,boolean atual_apareceu){
        
        Main team = new Main();
        
        team.setId_time(id);
        team.setQuant_acerto(acertos);
        team.setTime_penalidade(penalidade);
        team.setStatus_acerto(status_acerto);
        team.setApareceu(atual_apareceu);
        
        return team;
        
    }
    
    
    
    
    @Override
    public int compareTo(Main a) {
        
        if(this.getQuant_acerto()> a.getQuant_acerto()){
            return -1;    
        }else if(this.getQuant_acerto() == a.getQuant_acerto()){
            
            if(this.getTime_penalidade() > a.getTime_penalidade()){
                return 1;
            }else if(this.getTime_penalidade() == a.getTime_penalidade()){
                if(this.getId_time() > a.getId_time()){
                    return 1;
                }else if(this.getId_time() == a.getId_time()){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return 1;
        }
    }

        
}
    

*/
