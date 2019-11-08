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
    private int ordInsercao;

    public Soldado(int hp, int ordInsercao) {
        super();
        this.hp = hp;
        this.ordInsercao = ordInsercao;
    
    }
 
    public int getHp() {
        return hp;
    }
 
    public void setHp(int hp) {
        this.hp = hp;
    } 

    public int getOrdInsercao() {
        return ordInsercao;
    }
 
    public void setOrdInsercao(int ordInsercao) {
        this.ordInsercao = ordInsercao;
    }

   @Override
   public int compareTo (Soldado o) {
        
        if (this.hp == o.getHp()  &&  this.ordInsercao < o.getOrdInsercao() ) return 1;
        if (this.hp < o.getHp() ) return 1;
        if (this.hp == o.getHp() && this.ordInsercao > o.getOrdInsercao() ) return -1;
         if (this.hp > o.getHp()) return -1;
        return 0;
    } 

    @Override
    public String toString() {
        return hp+ " "+ ordInsercao;
    }



}


class Main {

    public static void main(String[] args) {
        BufferedReader br;
        int quantCampo, quantSG, quantSB, quantTeste;
        String linha;
        String[] linhas;
        TreeSet<Soldado> sg, sb;
         Iterator<Soldado> sgIterator, sbIterator;
         boolean terminou;
         int resultado;

        Soldado sgPower, sbPower;

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
                        Soldado soldado = new Soldado (Integer.parseInt(linha), j); 
                        sg.add( soldado );
                    }

                    
                    for (int j = 0; j < quantSB; j++){
                        linha =  br.readLine();
                        Soldado soldado = new Soldado (Integer.parseInt(linha), j); 
                        sb.add( soldado );
                    }




                    // System.out.println("TODOS OS ELEMENTOS DE SG");
                    // sgIterator = sg.iterator();
                    // while (sgIterator.hasNext()) {
                    //     Soldado Soldado = sgIterator.next();
                    //      System.out.println(Soldado.getHp() + " "+ Soldado.getOrdInsercao());
                    // }

                    
                    // System.out.println("TODOS OS ELEMENTOS DE SB");
                    // sbIterator = sb.iterator();
                    // while (sbIterator.hasNext()) {
                    //     Soldado Soldado = sbIterator.next();
                    //      System.out.println(Soldado.getHp() + " "+ Soldado.getOrdInsercao());
                    // }





                 
                    terminou = false;

                     // System.out.println(" -- COMBATE -- \n");
                    // combates
                    while ( ! terminou ) { 




                    	if ( (  sg.isEmpty() == false && sb.isEmpty() == false ) ){

                            sgPower = sg.first();
                            sbPower = sb.first();
                            resultado = 0;

                            sg.remove(sgPower);
                            sb.remove(sbPower);

                            // ganhou o combate sbPower
                            if( sgPower.getHp() < sbPower.getHp() ){

                                resultado = sbPower.getHp() - sgPower.getHp();
                                sbPower.setHp(resultado);
                                sb.add( sbPower );
                                // System.out.println("\nazul "+resultado );
                            // ganhou o  combate sgPower
                            }else if ( sgPower.getHp() > sbPower.getHp() ){
                                resultado = sgPower.getHp() -  sbPower.getHp();
                                sgPower.setHp(resultado);
                                sg.add( sgPower );
                                // System.out.println("\nverde "+resultado );
                            }


             

                    	}else{

                          terminou = true;
                    	}

                        quantCampo -= 1;
            	   } 

                   // System.out.println("jogo acabou");



                   if( sg.size() == 0 && sb.size() == 0 ){

                        System.out.println("green and blue died");


                   }else if (sg.size() != 0){

                        System.out.println("green wins");

                        sgIterator = sg.iterator();
                        while (sgIterator.hasNext()) {
                            Soldado Soldado = sgIterator.next();
                            System.out.println( Soldado.getHp() );
                        }


                    }else{

                        System.out.println("blue wins"); 


                        sbIterator = sb.iterator();
                        while (sbIterator.hasNext()) {
                            Soldado Soldado = sbIterator.next();
                            System.out.println( Soldado.getHp() );
                        }



                    }

                    System.out.println(""); 

             
            }

        }
        catch (Exception  e){
            System.out.println(e);
        }
      
    }


 }

// fim classe Main
