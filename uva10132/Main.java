import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int c = 0;
        int n = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        while (c < n){

            TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
            int menor = 99999; 
            int maior = 0;
            while(scanner.hasNext()) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("")) {
                    break;
                }
                else {
                    if (linha.length() < menor) menor = linha.length();
                    if (linha.length() > maior) maior = linha.length();
                    if (map.containsKey(linha.length())){
                        if(!map.get(linha.length()).contains(linha)) map.get(linha.length()).add(linha);
                    }
                    else {
                        ArrayList<String> lst_in = new ArrayList<String>();
                        lst_in.add(linha);
                        map.put(linha.length(), lst_in);
                    }
                }
            }
            Set set = map.keySet();
            Object[] chaves = set.toArray();
            int v = 0;
            ArrayList<String> solucao = new ArrayList<String>();
            ArrayList<String> vet1;
            ArrayList<String> vet2;
            while(true) {
                vet1 = map.get(chaves[v]);
                vet2 = map.get(chaves[set.size()-v-1]);
                for (int i = 0; i < vet1.size(); i++) {
                    ArrayList<String> isolucao = new ArrayList<String>();
                    for (int j = 0; j < vet2.size(); j++) {
                        String in1 = vet1.get(i) + vet2.get(j);
                        String in2 = vet2.get(j) + vet1.get(i);
                        if (!isolucao.contains(in1)) isolucao.add(in1);
                        if (!isolucao.contains(in2)) isolucao.add(in2);
                    }
                    if (solucao.isEmpty()) {
                        solucao = isolucao;
                    }
                    else {
                        solucao.retainAll(isolucao);
                    }
                    if (solucao.size() == 1) {
                        System.out.println(solucao.get(0));
                        break;
                    }
                }
                if (solucao.size() == 1) {
                    break;
                }
                v++;
            }
            c++;
            if (c < n) System.out.println("");
        }
        scanner.close();
    }
}