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
        a.add(10);
        a.add(1);

        Vector<Integer> b = new Vector();
        b.add(25);
        b.add(-1);

        Vector<Integer> c = new Vector();
        c.add(40);
        c.add(-1);

        LinkedList<Vector> entrada = new LinkedList<>();
        entrada.add(a); 
        entrada.add(b); 
        entrada.add(c);
        //input

        Queue<Integer> balca = new LinkedList<>();

        int ctime = 0;
        int lado =  -1;
        
        while(entrada.peek() != null) {
            int j = 0;
            while ((int)entrada.get(j).get(0) <= ctime) {
                if ((int)entrada.get(j).get(1) == lado){
                    balca.add((int)entrada.get(j).get(0));
                    entrada.remove(j);
                }
                else{
                    j = j+1;
                    if (j == entrada.size()) break;
                }
            }
            if (balca.size() > 0) {
                ctime = ctime + t;
                lado = lado *-1;
                while (balca.size() > 0){
                    //descarrega
                }
            }
            //espera
        }
    }

}

/*
            if ((int)entrada.peek().get(0) > ctime) {
                ctime = ctime + ((int)entrada.peek().get(0) - ctime);
                balca.add((int)entrada.poll().get(0));
            }
            if ((int)entrada.peek().get(1) != lado){
                ctime = ctime + t;
                lado = lado *-1;
            }

            */
