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
        String[][] vetorEquipe;
        long ordem, numero;
        int quant;
        int equipe;

        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            vetorEquipe = new String[101][];
            linha = br.readLine();
            quant =  Integer.parseInt( linha );
            while( quant > 0 ){
                br.readLine();
                linha = br.readLine();
                while( linha != "" ) {
                    vetorLinha  = linha.split(" ");
                    if( vetorLinha[3] == "I" || vetorLinha[3] == "C" ){
                       equipe = Integer.parseInt( vetorLinha[0] );
                       if( vetorEquipe[equipe] == null){
                       
                           vetorEquipe[equipe] = new String[10];
                           
                       }
                       
                        System.out.println(vetorEquipe[equipe]);
                    }

                    linha =  br.readLine();
                }
            }
        }
        catch (Exception  e){
            System.out.println(e);
        }
       
        
    }
    
}
