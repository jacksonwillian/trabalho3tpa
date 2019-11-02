import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Uva01062
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha;
        int c = 0;

        while (input.hasNext()){

            linha = input.nextLine();
            linha = linha.replace("\n", "");
            
            if (linha.equals("end")){
                break;
            }

            int t = linha.length();
           // System.out.println(linha);

            char[] in = new char[t];
            in = linha.toCharArray();
            c = c + 1;

            valida(in, t, c);
        }
        input.close();
    }

    public static void valida(char[] in, int t, int c){

        LinkedList<Stack> stacks = new LinkedList<Stack>();

        for (int i = 0; i < in.length; i++) {
            boolean a = false;
            for (int k = 0; k < stacks.size(); k++) {
                if ((Character)stacks.get(k).peek() >= in[i]){
                    stacks.get(k).add(in[i]);
                    a = true;
                    break;
                }
            }
            if (a == false) {
                Stack<Character> nstack = new Stack<>();
                nstack.add(in[i]);
                stacks.add(nstack);
            }
        }
        System.out.printf("Case %d: %d\n",c,stacks.size());
    }
}