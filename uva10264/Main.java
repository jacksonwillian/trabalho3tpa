import java.util.*;
import java.util.Set;
/* 
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int p = (int) Math.pow(2, n);
            int[] entrada = new int[p];
            int[] valorVertice = new int[p];
            TreeMap<Integer,LinkedList<Integer> > mapVisinhos = new TreeMap<Integer,LinkedList<Integer> >();

            for (Integer i = 0; i < entrada.length; i++) {
                String bin;
                entrada[i] = scanner.nextInt();

                bin = Integer.toBinaryString(i);
                if (bin.length() < n) bin = addzero( bin, (n-bin.length() ));
                char[] abin = bin.toCharArray();
                
                LinkedList<Integer> visinhos = new LinkedList<Integer>();
                Integer visinho;

                for (int j = 0; j < abin.length; j++) {
                    char[] vabin = abin.clone();
                    if (vabin[j]=='0') vabin[j] = '1';
                    else vabin[j] = '0';
                    String a = new String(vabin);
                    visinho = Integer.parseInt(a, 2);
                    visinhos.add(visinho);
                }
                mapVisinhos.put(i,visinhos);
            }
            for (int i = 0; i < valorVertice.length; i++) {
                for (int j = 0; j < n; j++) {
                    valorVertice[i] = valorVertice[i] + entrada[mapVisinhos.get(i).get(j)];
                }
            }
            int maiorP = -999;
            Set set = mapVisinhos.keySet();
            Iterator itr = set.iterator();

            while(itr.hasNext()){
                int chave = (int) itr.next();
                LinkedList<Integer> opc = mapVisinhos.get(chave);
                for (int j = 0; j < opc.size(); j++) {
                    int bimba = valorVertice[chave] + valorVertice[opc.get(j)];
                    if (bimba > maiorP) maiorP = bimba;
                }
            }
            System.out.println(maiorP);
        }
        scanner.close();
    }

    public static String addzero(String a, int n) {
        for (int i = 0; i < n; i++) {
            a = "0" + a;
        }
        return a;
    }
        
}