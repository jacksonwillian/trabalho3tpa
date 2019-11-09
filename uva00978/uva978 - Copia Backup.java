/* Main.java
 * 978 - Lemmings Battle
 * Autores: Jackson Willian
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Iterator; 

class Soldado implements Comparable<Soldado>{ 

    private int hp;
    private int freqUso;
    private int ordInsercao;
 

    public Soldado(int hp, int ordInsercao) {
        super();
        this.hp = hp;
        this.ordInsercao = ordInsercao;
        this.freqUso = 0;

    
    }
 
    public int getHp() {
        return hp;
    }
 
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getFreqUso() {
        return freqUso;
    }
 
    public void setFreqUso(int freqUso) {
        this.freqUso = freqUso;
    } 

    public int getOrdInsercao() {
        return ordInsercao;
    }
 
    public void setOrdInsercao(int ordInsercao) {
        this.ordInsercao = ordInsercao;
    }

   @Override
   public int compareTo (Soldado o) {

        // System.out.println("Comparacao");
        // System.out.println(this.hp+" "+this.ordInsercao+" "+this.freqUso);
        // System.out.println(o);
        if (this.freqUso == o.getFreqUso() && this.hp == o.getHp() && this.ordInsercao == o.getOrdInsercao()){
            // System.out.println("caso 1");
            return 0;
        }else if ( this.freqUso == o.getFreqUso() ) {
            
            if ( this.hp < o.getHp() ){
                // System.out.println("caso 2");
                return 1;
            }else{
                // System.out.println("caso 3");
                return -1;
            }
        }else if( this.freqUso > o.getFreqUso() ){

             // System.out.println("caso 4");
          
           
             return 1;
     

        }else {

            if( this.freqUso < o.getFreqUso() ){
                // System.out.println("caso 5");
                return -1;

            }
         }  

         return 0; 

    }

    

    @Override
    public String toString() {
        return hp+ " "+ ordInsercao +" "+freqUso;
    }



}


class Main {

    public static void main(String[] args) {
        BufferedReader br;
        int quantCampo, quantSG, quantSB, quantTeste;
        String linha;
        String[] linhas;
        TreeSet<Soldado> sg, sb, resposta;
         Soldado sgPower, sbPower;   
         Iterator<Soldado> sgIterator, sbIterator, respostaIterator;       
         boolean terminou;
         int resultado;

        





        br = new BufferedReader(new InputStreamReader(System.in));

        try {

            linha =  br.readLine();
            quantTeste = Integer.parseInt( linha );

           for (int i = 0; i < quantTeste; i++){ 

                    sg = new TreeSet<Soldado>();
                    sb = new TreeSet<Soldado>();

                    linha =  br.readLine();

                    linhas = linha.split(" ");

                    quantCampo = Integer.parseInt(linhas[0]);
                    quantSG = Integer.parseInt(linhas[1]);
                    quantSB = Integer.parseInt(linhas[2]);
                    
                    for (int j = 0; j < quantSG; j++){
                    	linha =  br.readLine();
                      //  System.out.println(linha);
                        Soldado soldado = new Soldado (Integer.parseInt(linha), j); 
                        sg.add( soldado );
                    }

                    
                    for (int j = 0; j < quantSB; j++){
                        linha =  br.readLine();
                      //  System.out.println(linha);
                        Soldado soldado = new Soldado (Integer.parseInt(linha), j); 
                        sb.add( soldado );
                    }




                    // System.out.println("TODOS OS ELEMENTOS DE SG");
                    // sgIterator = sg.iterator();
                    // while (sgIterator.hasNext()) {
                    //     Soldado Soldado = sgIterator.next();
                    //      System.out.println(Soldado);
                    // }

                    
                    // System.out.println("TODOS OS ELEMENTOS DE SB");
                    // sbIterator = sb.iterator();
                    // while (sbIterator.hasNext()) {
                    //     Soldado Soldado = sbIterator.next();
                    //      System.out.println(Soldado);
                    // }




            // ARQUI É A PARTE QUE NAO PRECISA MEXER


                    terminou = false;

            
                    // System.out.println(" -- INICIO COMBATE -- \n");
                    //combates
                    while ( ! terminou ) { 
            
                                // System.out.println("TODOS OS ELEMENTOS DE SG " +quantCampo );
                                // sgIterator = sg.iterator();
                                // while (sgIterator.hasNext()) {
                                //     Soldado Soldado = sgIterator.next();
                                //      System.out.println(Soldado);
                                // }

                                
                                // System.out.println("TODOS OS ELEMENTOS DE SB"+quantCampo);
                                // sbIterator = sb.iterator(); 
                                // while (sbIterator.hasNext()) {
                                //     Soldado Soldado = sbIterator.next();
                                //      System.out.println(Soldado);
                                // }

                        

                        if (  sg.isEmpty() == false && sb.isEmpty() == false ){

                            
                            sgPower = sg.first();
                            sbPower = sb.first();
                            resultado = 0;
                          

                            sg.remove(sgPower);
                            sb.remove(sbPower);


                            // ganhou o combate sbPower
                            if( sgPower.getHp() < sbPower.getHp() ){

                                resultado = sbPower.getHp() - sgPower.getHp();
                                sbPower.setHp(resultado);
                                sbPower.setFreqUso(sbPower.getFreqUso() + 1);
                                sb.add( sbPower );
                                 // System.out.println("\nazul "+resultado );
                            // ganhou o  combate sgPower
                            }else if ( sgPower.getHp() > sbPower.getHp() ){
                                resultado = sgPower.getHp() -  sbPower.getHp();
                                sgPower.setHp(resultado);
                                sgPower.setFreqUso(sgPower.getFreqUso() + 1);
                                sg.add( sgPower );
                                // System.out.println("\nverde "+resultado );
                            }

                        }else{

                          terminou = true;
                        }

                        quantCampo -= 1;
                   } 

                  
                   // System.out.println(" -- FIM COMBATE -- \n");

                   resposta = new TreeSet<Soldado>();

                   if( sg.size() == 0 && sb.size() == 0 ){

                        System.out.println("green and blue died");


                   }else if (sg.size() != 0){

                        System.out.println("green wins");
                   
                      
                        while ( ! sg.isEmpty() ) {

                            Soldado soldado = sg.first();
                            sg.remove(soldado);
                            soldado.setFreqUso(0);
                            resposta.add( soldado );

                        }


                    }else{

                        System.out.println("blue wins"); 


                      
                        while ( ! sb.isEmpty() ) {
                            Soldado soldado = sb.first();
                            sb.remove(soldado);
                            soldado.setFreqUso(0);
                            resposta.add( soldado );
                        }
                    }    

                        respostaIterator = resposta.iterator();
                        while (respostaIterator.hasNext()) {
                            Soldado soldado = respostaIterator.next();
                            System.out.println( soldado.getHp() );
                        }   


            // Aqui TERMINA A PARTE
                

                    System.out.println(""); 

             
            }

        }
        catch (Exception  e){
            System.out.println(e);
        }
      
    }


    public static void batalha (TreeSet<Soldado> sg, TreeSet<Soldado> sb, int quantCampo){



    }


 }

// fim classe Main
