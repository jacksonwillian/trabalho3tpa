/* Main.java
 * UVa 10130 -- SuperSale
 */

import java.util.Vector;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static class Pair<A,B> {

        public Pair(A x1, B x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        override public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair<A,B> that = (Pair)other;
                return (this.x1.equals(that.x1)) && (this.x2.equals(that.x2));
            }
            else return false;
        }

        override public int hashCode() {
            return 13*x1.hashCode() + 17*x1.hashCode() + 11;
        }

        override public String toString() {
            return String.format("(%s, %s)", x1, x2);
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buf = scanner.nextLine();
        int t = Integer.parseInt(buf);
        int t_orig = t;
        // System.out.printf("Casos de teste => %d.\n", t_orig - t + 1);
        while (t > 0) {
            // System.out.printf("Lendo caso de teste %d...\n", t);
            buf = scanner.nextLine();
            int n = Integer.parseInt(buf);
            // System.out.printf("Quantidade de produtos => %d.\n", n);
            Vector<Integer> prices = new Vector(n);
            Vector<Integer> weights = new Vector(n);
            for (int i = 0; i < n; i++) {
                String prod = scanner.nextLine();
                // System.out.printf("Linha lida para produto %d => %s.\n", i+1, prod);
                String[] pair = prod.split("\\s+");
                // System.out.printf("split => %s", Arrays.toString(pair));
                prices.add(Integer.parseInt(pair[0]));
                weights.add(Integer.parseInt(pair[1]));
            }
            // System.out.printf("Preços dos produtos => %s.\n", prices.toString());
            // System.out.printf("Pesos dos produtos => %s.\n", weights.toString());
            buf = scanner.nextLine();
            int g = Integer.parseInt(buf);
            // System.out.printf("Quantidade de pessoas no grupo => %d.\n", g);
            Vector<Integer> loads = new Vector(n);
            for (int i = 0; i < g; i++) {
                buf = scanner.nextLine();
                loads.add(Integer.parseInt(buf));
            }
            // System.out.printf("Carga de cada pessoa => %s.\n", loads.toString());
            int acc = 0;
            for (int load: loads) {
                acc += solve(load, prices, weights);
            }
            System.out.printf("%d\n", acc);

            --t;
        }
    }

    public static int solve(int load, Vector<Integer> prices, Vector<Integer> weights) {
        Vector<Integer> revenues = new Vector();
        for (int i = 0; i < prices.size(); i++) {
            if (weights.get(i) <= load) {
                Vector<Integer> prices1 = (Vector<Integer>)prices.clone();
                Vector<Integer> weights1 = (Vector<Integer>)weights.clone();
                prices1.remove(i);
                weights1.remove(i);
                int restRevenue = solve(load - weights.get(i), prices1, weights1);
                int itemRevenue = prices.get(i) + restRevenue;
                revenues.add(itemRevenue);
            }
        }
        if (revenues.size() == 0) return 0;
        else return Collections.max(revenues);
    }

}