// /*
//  * To change this license header, choose License Headers in Project Properties.
//  * To change this template file, choose Tools | Templates
//  * and open the template in the editor.
//  */

// import java.util.ArrayList;
// import java.util.Collections;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.lang.Math; 

// /**
//  *
//  * @author Jackson
//  */
// class Main {

    
//     public static void main(String[] args) {
       
//         BufferedReader br;
//         String linha, resposta;
//         String[] vetorLinha;
//         int[][][] vetorEquipe;
//         long ordem, numero;
//         int quant;
//         int equipe, questao, time, situacao;

//         br = new BufferedReader(new InputStreamReader(System.in));

//         try {
           
//             linha = br.readLine();
//             quant =  Integer.parseInt( linha );
//             while( quant > 0 ){
//                 vetorEquipe = new int[100][][];
//                 br.readLine();
//                 linha = br.readLine();
//                 while( linha != "" ) {
//                     vetorLinha  = linha.split(" ");
//                     situacao = verificaSituacao ( vetorLinha[3] );
//                     if( situacao != -1){
//                        equipe = Integer.parseInt( vetorLinha[0] ) - 1;
//                        questao = Integer.parseInt( vetorLinha[1] ) - 1;
//                        time = Integer.parseInt( vetorLinha[2] );
//                        if( vetorEquipe[equipe] == null){
//                            vetorEquipe[equipe] = new int[11][];
                           
//                            vetorEquipe[equipe][10] = new int[2];
//                            // cria a lista geral da equipe
//                            vetorEquipe[equipe][10][0] = 0;
//                             vetorEquipe[equipe][10][1] = 0;
//                        }
                       
//                        if ( vetorEquipe[equipe][questao] == null){
//                            vetorEquipe[equipe][questao] = new int[2];
                           
                           
//                            vetorEquipe[equipe][questao][0] = 0;
//                            vetorEquipe[equipe][questao][1] = -1;

//                        }
                       
                       
                       
//                        if ( ( vetorEquipe[equipe][questao][1] == 0) && (situacao == 0) ){
//                            vetorEquipe[equipe][questao][0] += 20;                           
//                        }else if ( ( vetorEquipe[equipe][questao][1] == 0) && (situacao == 1)   ){
//                             vetorEquipe[equipe][questao][0] += time;
//                             vetorEquipe[equipe][questao][1] = 1;
//                             // adiciona a lista geral da equipe 
//                            vetorEquipe[equipe][10][0] += 1;
//                             vetorEquipe[equipe][10][1] += vetorEquipe[equipe][questao][0]; 
//                         }else if ( ( vetorEquipe[equipe][questao][1] == -1) && (situacao == 1)  ){
//                             vetorEquipe[equipe][questao][0] += time;
//                             vetorEquipe[equipe][questao][1] = 1;
//                             // adiciona a lista geral da equipe
//                             vetorEquipe[equipe][10][0] += 1;
//                             vetorEquipe[equipe][10][1] += vetorEquipe[equipe][questao][0]; 
//                         }else if ( ( vetorEquipe[equipe][questao][1] == -1) && (situacao == 0)  ){
//                             vetorEquipe[equipe][questao][0] = 20;
//                             vetorEquipe[equipe][questao][1] = 0;                            
//                         }
  
//                     }
//                     linha =  br.readLine();
//                 }
                
//                 // caso de teste
                
                
//                 for (int i = 0; i < 101; i++){
                
//                     System.out.println("Equipe: "+(i+1)+" Questoes: "+vetorEquipe[i][10][0]+" Penalidade: "+vetorEquipe[i][10][1]);
//                 }
                
                
                
                
                
//              quant -= 1;       
//             }
          
//         }
//         catch (Exception  e){
//             System.out.println(e);
//         }
       
        
        
        
//     }
    
//     public static int verificaSituacao (String texto){
//         if ("C".contentEquals(texto)) return 1; // CORRETO
//         if ("I".contentEquals(texto)) return 0; //INCORRETO
//         return -1; //NÃO CONSIDERAR
//     }
    
    
// }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math; 
import java.util.Vector;


/**
 *
 * @author Jackson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        BufferedReader br;
        String linha, resposta;
        String[] vetorLinha;
        int[][][] vetorEquipe;
        int[][] vetor2;
        long ordem, numero;
        int quant;
        int equipe, questao, time, situacao;

        br = new BufferedReader(new InputStreamReader(System.in));

        try {
           
            linha = br.readLine();
            quant =  Integer.parseInt( linha );
            while( quant > 0 ){
                vetorEquipe = new int[100][][];
                br.readLine();
                linha = br.readLine();
                while( ! linha.equalsIgnoreCase("") ) {
                    vetorLinha  = linha.split(" ");
                    situacao = verificaSituacao ( vetorLinha[3] );
                    if( situacao != -1){
                       equipe = Integer.parseInt( vetorLinha[0] ) - 1;
                       questao = Integer.parseInt( vetorLinha[1] ) - 1;
                       time = Integer.parseInt( vetorLinha[2] );
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
                        }
  
                    }
                    linha =  br.readLine();
                }
                
                // caso de teste
                vetor2 = new int [100][3];
                int j = 0;
                for (int i = 0; i < 100; i++){
                    
                    if (vetorEquipe[i] != null){
                        vetor2[j][0] = i+1;
                        vetor2[j][1] = vetorEquipe[i][10][0];
                        vetor2[j][2] = vetorEquipe[i][10][1];
                        
                    System.out.println("Equipe: "+(i+1)+" Questoes: "+vetorEquipe[i][10][0]+" Penalidade: "+vetorEquipe[i][10][1]);
                    
                    }
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
    
    
    public static void insereOrdenado (int[][] vetor, posicao){
    
     
    }
    
    
}
