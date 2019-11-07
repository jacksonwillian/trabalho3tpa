/* Main.java
 * UVa 10920 - Spiral Tap
 * Autores: Jackson Willian
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math; 

class Main {

    public static void main(String[] args) {
        BufferedReader br;
        String linha, resposta;
        String[] vetorNumeros;
        long ordem, numero;

        br = new BufferedReader(new InputStreamReader(System.in));

        try {

            linha =  br.readLine();
            while( linha != null ) {
                vetorNumeros  = linha.split(" ");
                ordem = Long.parseLong(vetorNumeros[0]);
                numero = Long.parseLong(vetorNumeros[1]);;

                if(ordem != 0 && numero != 0){
                    
                     spiralTap(ordem, numero);
                
                }
                linha =  br.readLine();
            }
        }
        catch (Exception  e){
            System.out.println(e);
        }
      
    }

    
    public static void spiralTap ( long ordem, long numero){
        long meio = 0, linhaCima = 0, linhaAbaixo = 0, colunaEsquerda = 0, colunaDireita = 0;
        long camada = 0, minimo = 0, maximo = 0, subOrdem = 0;
        long valor = 0, linha = 0, coluna = 0, interGeral = 0, intervaloInicio = 0, intervaloFinal = 0;

        if(ordem % 2 != 0){
            meio = (long) (ordem / 2);
            if(numero == 1){
                linha = meio + 1;
                coluna = meio + 1;
                System.out.println("Line = "+linha+", column = "+coluna+".");
            }else if (numero == (long) Math.pow(ordem, 2)){
                linha = ordem;
                coluna = ordem;
                System.out.println("Line = "+linha+", column = "+coluna+".");               
            }else{

                camada = 1;
                minimo = 2;
                maximo = 9;
                subOrdem = 3;

                while( true ){

                    if(numero >= minimo && numero <= maximo){
                        break;
                    }

                    camada += 1;
                    subOrdem  += 2;
                    minimo = maximo + 1;
                    maximo = (long) Math.pow(subOrdem, 2);

                }

                linhaCima = meio + camada;                                                                                                                                                                                           
                colunaEsquerda = meio - camada;
                linhaAbaixo = meio - camada;
                colunaDireita = meio + camada;

                interGeral = subOrdem - 1;

                intervaloInicio = maximo - interGeral;
                intervaloFinal = (long) Math.pow(subOrdem, 2);
                if (numero >= intervaloInicio && numero <= intervaloFinal){
                    valor = intervaloFinal;
                    
                    linhaCima = linhaCima - (valor - numero);
                    linha = linhaCima+1;
                    coluna = colunaDireita+1;
                    System.out.println("Line = "+linha+", column = "+coluna+".");                     

                }else {
                    intervaloInicio = maximo - (interGeral * 2);
                    intervaloFinal = maximo - interGeral;
                if (numero >= intervaloInicio && numero <= intervaloFinal){
                        valor = intervaloFinal;
                        colunaDireita = colunaDireita - (valor - numero);
                        linha = linhaAbaixo+1;
                        coluna = colunaDireita+1;
                        System.out.println("Line = "+linha+", column = "+coluna+".");                          
                    }else{
                        intervaloInicio = maximo - (interGeral * 3);
                        intervaloFinal = maximo - (interGeral * 2);
                        if (numero >= intervaloInicio && numero <= intervaloFinal){
                            valor = intervaloFinal;
                            linhaAbaixo = linhaAbaixo + (valor - numero);
                            linha = linhaAbaixo+1;
                            coluna = colunaEsquerda+1;
                            System.out.println("Line = "+linha+", column = "+coluna+".");  

                        }else{
                            intervaloInicio = maximo - (interGeral * 4);
                            intervaloFinal = maximo - (interGeral * 3);
                            if(numero >= intervaloInicio && numero <= intervaloFinal){
                                valor = intervaloFinal;
                                colunaEsquerda =  colunaEsquerda + (valor - numero);
                                linha = linhaCima+1;
                                coluna = colunaEsquerda+1;
                                System.out.println("Line = "+linha+", column = "+coluna+".");  

                            }
                        }


                    }
                }










                 }

              }
             
            }    
            
            

 }



