import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> map = new TreeMap<>();
        TreeMap<String, Vector> orphans = new  TreeMap<String, Vector>();
 
        int n = scanner.nextInt();
        String nome;
        String value;
        String gene1, gene2;
        String chave;
        
        for (int i = 0; i < n; i++) {
            nome = scanner.next();
            nome = nome.replace(" ","");
            value = scanner.next();
            value = value.replace(" ","");
            if (!isNotGene(value)){
                map.put(nome,value);
            }
            else if (orphans.containsKey(value)){
                orphans.get(value).add(nome);
            }
            else {
                Vector <String> parents = new  Vector <String>();
                parents.add(nome);
                orphans.put(value, parents);
            }
        }
        scanner.close();
        Set set = orphans.keySet();
        Iterator itr_aux;
        int a = 0;
        
        while (a < orphans.size()){
            itr_aux  = set.iterator();
            while (itr_aux.hasNext()) {
                chave = (String) itr_aux.next();
                if (!map.containsKey(chave) && map.containsKey(orphans.get(chave).get(0)) && map.containsKey(orphans.get(chave).get(1)) ){
                    gene1 = map.get(orphans.get(chave).get(0));
                    gene2 = map.get(orphans.get(chave).get(1));
                    map.put(chave, qGene(gene1, gene2));
                    a = a+1;
                }
            }
        }

        Set c = map.keySet();
        Iterator itr = c.iterator();
        while(itr.hasNext()){
            chave = (String) itr.next();
            System.out.printf("%s %s\n", chave, map.get(chave));   
        }
    }  

    static public Boolean isNotGene(String value) {
        if (value.equalsIgnoreCase("dominant") || value.equalsIgnoreCase("recessive") || value.equalsIgnoreCase("non-existent") ) {
            return false;
        }
        return true;
    }

    static public String qGene(String gene1, String gene2) {
        if (( gene1.equalsIgnoreCase("dominant") && gene2.equalsIgnoreCase("non-existent") ) || ( gene1.equalsIgnoreCase("non-existent") && gene2.equalsIgnoreCase("dominant") )){
            return "recessive";
        }
        else if (( gene1.equalsIgnoreCase("recessive") && gene2.equalsIgnoreCase("non-existent") ) || ( gene1.equalsIgnoreCase("non-existent") && gene2.equalsIgnoreCase("recessive") )){
            return "non-existent";
        }
        else if (gene1.equalsIgnoreCase("dominant") || gene2.equalsIgnoreCase("dominant")){
            return "dominant";
        }
        else if (gene1.equalsIgnoreCase("recessive") || gene2.equalsIgnoreCase("recessive")) {
            return "recessive";
        }
        return "non-existent";
    }
}