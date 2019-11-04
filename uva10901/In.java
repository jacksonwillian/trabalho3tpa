import java.util.Scanner;
import java.util.Queue;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * In
 */
public class In {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c, x, n, t, m;
        x = 0;
        c = input.nextInt();
        while (x < c){
            n = input.nextInt();
            t = input.nextInt();
            m = input.nextInt();

            LinkedList<Vector> entrada = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                Vector<Integer> carro = new Vector<Integer>();
                int t_entrada = input.nextInt();
                String l_entrada = input.nextLine();

                carro.add(t_entrada);
                l_entrada=l_entrada.replace(" ","");
                if (l_entrada.equalsIgnoreCase("right")) {
                    carro.add(1);
                }
                else{
                    carro.add(-1);
                } 
                carro.add(i);

                entrada.add(carro);
            }
            bimba(n, t , m, entrada);
            System.out.println("");
            x = x+1;
        }
        input.close();
    }

    public static void bimba(int n, int t, int m, LinkedList<Vector> entrada ) {
    
        Integer[] saida = new Integer[m];

        Queue<Vector> balca = new LinkedList<>();

        int ctime = 0;
        int lado =  -1;
        int k = 0;

        while(entrada.peek() != null) {
            int j = 0;
            while ((int)entrada.get(j).get(0) <= ctime && n > balca.size()) {
                if ((int)entrada.get(j).get(1) == lado){
                    balca.add(entrada.get(j));
                    entrada.remove(j);
                    j=0;
                    if (entrada.size() == 0) {
                        break;
                    }
                }
                else{
                    j = j+1;
                    if (j >= entrada.size()) break;
                }
            }
            if (balca.size() > 0) {
                ctime = ctime + t;
                lado = lado *-1;
                while (balca.size() > 0){
                    k = ((int)balca.peek().get(2));
                    balca.poll();
                    saida[k] = ctime;
                    //descarrega
                }
            }
            else if ((int)entrada.get(0).get(1) == lado) {
                ctime = ctime + ((int)entrada.peek().get(0) - ctime);
            }
            else {
                ctime = ctime + ((int)entrada.peek().get(0) - ctime) + t;
                lado = lado *-1;
            }
            //espera
        }
        //resultado
        for (int i = 0; i < saida.length; i++) {
            System.out.println(saida[i]);
        }
    }
}