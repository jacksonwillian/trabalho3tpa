
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;



public class Main {
    

    
    
    public static void main(String[] args){
        
        BufferedReader buf          = new BufferedReader(new InputStreamReader(System.in));
        
        Deque [][]estacoesMatriz     = new Deque [100][2]; //NÃO ESTA ATRIBUINDO
        Deque<Integer> restoCarga   = new ArrayDeque();
        
        Stack<Integer> carrinho = new Stack();
        
        int quantConjuntos;
        int quantEstacoes;
        int cargaMaxCarrinho;
        int quantMaxCargaPlataformB;
    
        int tempoGasto = 0;
    
        boolean existeCargaCarrinho         = false;
        boolean existeCargaPlataformB       = false;
        
        
        
        int quantCargaLinha = 0;
        int limite = 0;
        
        int cargaAtual;
        int estacaoAtual = 1;
        
        String linha;
        String linhaSplit[];    
        
        try{
            
            linha = buf.readLine();
            quantConjuntos = Integer.parseInt(linha);
            
            while(linha !=null){
                
                linha = buf.readLine();
                linhaSplit = linha.split(" ");
                
                quantEstacoes           = Integer.parseInt(linhaSplit[0]);
                cargaMaxCarrinho        = Integer.parseInt(linhaSplit[1]);
                quantMaxCargaPlataformB = Integer.parseInt(linhaSplit[2]);
                
                do{
                    linha = buf.readLine();
                    linhaSplit = linha.split(" ");
                    
                    quantCargaLinha = Integer.parseInt(linhaSplit[0]);
                    
                    if(quantCargaLinha > 0){
                        
                        if(quantCargaLinha <= cargaMaxCarrinho){
                            
                  
                            carrinho = cargaInicioCarrinho(carrinho,linhaSplit,cargaMaxCarrinho);
                            
                        }else{
                            
                             
                            
                            carrinho = cargaInicioCarrinho(carrinho,linhaSplit,cargaMaxCarrinho);
                            
                            //MATRIZ DE DEQUE NÃO ESTA ATRIBUINDO
                            //estacoesMatriz[1][1] = reserverPlatformOne(restoCarga,linhaSplit,cargaMaxCarrinho,quantCargaLinha);
                           
                            System.out.println(carrinho.pop());
                            System.out.println(carrinho.pop());
                            System.out.println(carrinho.pop());

                        }
                            
                        existeCargaCarrinho = true;
                        tempoGasto      +=2;
                        
                    }
                    
                }while(existeCargaCarrinho && existeCargaPlataformB);
            
                
                
                
                linha = buf.readLine();
            }
        
        
        }catch(IOException | NumberFormatException e){
            
            System.out.println("EROUUUUUUU: " + e);
        
        }
          
        
    }
    
    public static Deque reserverPlatformOne(Deque platformInicial,String[] linha, int inicio,int limite){
     
        for(int i = inicio + 1; i <= limite;i++){
            
            platformInicial.push(linha[i]);
            
           
        }

        return platformInicial;
    }
    
 
    
       public static Stack cargaInicioCarrinho(Stack carrinho,String[] linha,int limite){
        
        int quantCarga = limite;
        
        for(int i = 1 ; i <= quantCarga;i++){
            carrinho.push(Integer.parseInt(linha[i]));
        }

        return carrinho;
    }
    
    public static Stack controlePlataforma(Stack carrinho,Deque[][] estacoes,int estacaoAtual){
        
        /*
        while(estacaoAtual <= quantEstacoes){

            estacaoAtual    +=1;

            if (!carrinho.empty()){

                cargaAtual = carrinho.pop();

                if(cargaAtual == estacaoAtual){
                    estacoesMatriz[estacaoAtual][0].push(cargaAtual);
                }else{
                    estacoesMatriz[estacaoAtual][1].push(cargaAtual);
                    existeCargaPlataformB = true;
                }

                tempoGasto +=1;

            }else{

                if(estacoesMatriz[estacaoAtual][1].peek() == null){

                    existeCargaPlataformB = false;
                    estacaoAtual    +=1;
                    tempoGasto      +=2;

                }else{

                    if(carrinho.size() < cargaMaxCarrinho){
                        cargaAtual = (int) estacoesMatriz[estacaoAtual][1].poll();
                        carrinho.push(cargaAtual);
                        tempoGasto +=1;
                    }
                }
            }
        
        
        */
        return carrinho;
    
    }
}

    

