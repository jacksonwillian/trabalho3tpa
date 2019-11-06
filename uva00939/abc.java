import java.util.TreeMap;
import java.util.Scanner;
import java.util.Collection;
import java.util.Iterator;

/**
 * abc
 */
public class abc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> map = new TreeMap<>();
        TreeMap<String, String> map_aux = new TreeMap<>();

        int n = scanner.nextInt();
        String nome;
        String value;
        String chave;
        String gene1, gene2, child;
    
        for (int i = 0; i < n; i++) {
            nome = scanner.next();
            nome = nome.replace(" ","");
            value = scanner.next();
            value = value.replace(" ","");
            if (!isNotGene(value)){
                map.put(nome,value);
            }
            else{
                map_aux.put(nome,value);
            }
        }
        scanner.close();

        Collection c = map_aux.keySet();
        Iterator itr = c.iterator();

        while(itr.hasNext()){
            chave = (String) itr.next();
            child = map_aux.get(chave);

            //System.out.println(child);
            if (!map.containsKey(child)) {
                map.put(child, map.get(chave));
            }
            else{
                gene1 = map.get(chave);
                gene2 = map.get(child);
                map.replace(child,qGene(gene1,gene2));
            }
        }
        
    }
    static public Boolean isNotGene(String value) {
        if (value.equalsIgnoreCase("dominant") || value.equalsIgnoreCase("recessive") || value.equalsIgnoreCase("non-existent") ) {
            return false;
        }
        return true;
    }

    static public String qGene(String gene1, String gene2) {
        if (gene1.equalsIgnoreCase("dominant") || gene2.equalsIgnoreCase("dominant")){
            return "dominant";
        }
        if (gene1.equalsIgnoreCase("recessive") || gene2.equalsIgnoreCase("recessive")) {
            return "recessive";
        }
        return "non-existent";
    }
}