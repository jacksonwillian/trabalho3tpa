/* Main.java
 * UVa 10258 - Contest Scoreboard
 * Autores: Jackson Willian, Emanuel Rampinelle
 */

import java.util.Scanner;


class Main {

    public static void main(String[] args) {
       
        String linha;
        String[] vetorLinha;
        int[][][] vetorEquipe;
        int[][] vetor2;
        int quant, equipe, questao, time, situacao;

       Scanner scanner = new Scanner(System.in);

        try {
           
            linha = scanner.nextLine();
            quant =  Integer.parseInt( linha );
            scanner.nextLine();

            while( quant > 0 ){
                   
                vetorEquipe = new int[100][][];
                
                while( scanner.hasNextLine() ) {
                 
                    linha = scanner.nextLine();
                    if (! linha.equalsIgnoreCase("")){
                     
                           vetorLinha  = linha.split(" ");    

                           equipe = Integer.parseInt( vetorLinha[0] ) - 1;
                           questao = Integer.parseInt( vetorLinha[1] ) - 1;
                           time = Integer.parseInt( vetorLinha[2] );
                           situacao = verificaSituacao ( vetorLinha[3] );
           
                           if( vetorEquipe[equipe] == null){
                               vetorEquipe[equipe] = new int[11][];                     
                               vetorEquipe[equipe][10] = new int[2];
                               // cria a lista geral da equipe
                               vetorEquipe[equipe][10][0] = 0;
                                vetorEquipe[equipe][10][1] = 0;
                           }
              
                           if ( vetorEquipe[equipe][questao] == null){
                               vetorEquipe[equipe][questao] = new int[2];
                               vetorEquipe[equipe][questao][0] = 0;
                               vetorEquipe[equipe][questao][1] = -1;
                           }
                           
                          
                           if ( ( vetorEquipe[equipe][questao][1] == 0) && (situacao == 0) ){
                               vetorEquipe[equipe][questao][0] += 20;                           
                           }else if ( ( vetorEquipe[equipe][questao][1] == 0) && (situacao == 1)   ){
                                vetorEquipe[equipe][questao][0] += time;
                                vetorEquipe[equipe][questao][1] = 1;
                                // adiciona a lista geral da equipe 
                               vetorEquipe[equipe][10][0] += 1;
                                vetorEquipe[equipe][10][1] += vetorEquipe[equipe][questao][0]; 
                            }else if ( ( vetorEquipe[equipe][questao][1] == -1) && (situacao == 1)  ){
                                vetorEquipe[equipe][questao][0] += time;
                                vetorEquipe[equipe][questao][1] = 1;
                                // adiciona a lista geral da equipe
                                vetorEquipe[equipe][10][0] += 1;
                                vetorEquipe[equipe][10][1] += vetorEquipe[equipe][questao][0]; 
                            }else if ( ( vetorEquipe[equipe][questao][1] == -1) && (situacao == 0)  ){
                                vetorEquipe[equipe][questao][0] = 20;
                                vetorEquipe[equipe][questao][1] = 0;                            
                            }else if ( (vetorEquipe[equipe][questao][1] == -1 ) && (situacao == -1)){

                                vetorEquipe[equipe][questao][0] = 0; 
                                vetorEquipe[equipe][questao][1]= 0;
                            }

                     }else{

                         break;
                     } 
                }


                vetor2 = new int [100][3];
                int j = 0;
                for (int i = 0; i < 100; i++){
                    
                    if (vetorEquipe[i] != null){
                        vetor2[j][0] = i+1;
                        vetor2[j][1] = vetorEquipe[i][10][0];
                        vetor2[j][2] = vetorEquipe[i][10][1];
                        insereOrdenado ( vetor2, j);
                        j += 1;
                    }
                }
                

                for (int i = 0; i < j; i++){
                     System.out.println(vetor2[i][0]+" "+vetor2[i][1]+" "+vetor2[i][2]);
                }
                
                if(quant != 1){
                    System.out.println("");
                }

             quant -= 1;       
            }
        }
        catch (Exception  e){
            System.out.println(e);
        }

    }
    

    public static int verificaSituacao (String texto){
        if ("C".contentEquals(texto)) return 1; // CORRETO
        if ("I".contentEquals(texto)) return 0; //INCORRETO
        return -1; //NÃO CONSIDERAR
    }
    
    
    public static void insereOrdenado (int[][] vetor, int i){
        int[] key = vetor[i]; 
        int j = i - 1; 
        while ( (j >= 0) && (comparacao(vetor[j] , key) == -1) ) { 
                vetor[j + 1] = vetor[j]; 
                j = j - 1; 
        } 
        vetor[j + 1] = key;       
    }
    
    
    public static int comparacao(int[] valor1 , int[] valor2){
        if( valor1[1] < valor2[1] ){
            return -1;
        }else if ( ( valor1[1] == valor2[1] ) && ( valor1[2] > valor2[2] ) ){
            return -1;
        }else if ( ( valor1[1] == valor2[1] ) && ( valor1[2] > valor2[2] ) &&  ( valor1[0] > valor2[0] ) ){
            return -1;
        }
        return 0;
    }


}


