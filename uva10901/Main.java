import java.util.Queue;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        //esquerda -1 direita 1
        // input 
        int n = 2;
        int t = 10;
        //int m = linhas de entrada

        Vector<Integer> a = new Vector();
        a.add(0);
        a.add(-1);
        a.add(0);

        Vector<Integer> b = new Vector();
        b.add(10);
        b.add(-1);
        b.add(1);

        Vector<Integer> c = new Vector();
        c.add(20);
        c.add(-1);
        c.add(2);

        LinkedList<Vector> entrada = new LinkedList<>();
        entrada.add(a); 
        entrada.add(b);
        entrada.add(c);
        //input

        Integer[] saida = new Integer[entrada.size()];

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
    Integer a = 0;
}
