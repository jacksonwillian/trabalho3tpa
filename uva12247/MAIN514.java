import java.util.Scanner;
import java.util.Stack;

/**
 * MAIN514
 */
class MAIN514 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean b = true;

        while(scanner.hasNext()) {
            int n = scanner.nextInt();

            while (n != 0 ) {

                int[] vet = new int[n];

                for (int i = 0; i < n; i++) {
                    int x = scanner.nextInt();
                    if (x != 0) {
                        vet[i] = x;
                    }
                    else {
                        n = 0;
                        break;
                    }
                }
                valida(vet,n);
            }
        }
        scanner.close();
    }

    public static void valida(int[] in, int n){
        
        Integer k = 1;
        Integer i = 0;

        Stack<Integer> stack = new Stack<>();


        while (k <= n) {
            stack.add(k);
            k=k+1;
            while (stack.peek() < in[i]) {
                stack.add(k);
                k=k+1;
            }

            while (stack.peek() == in[i]) {
                stack.pop();
                i = i+1;
                if (stack.size() == 0) {
                    break;
                }
            }
        }
        if (n == 0){
            System.out.println("");
            return;
        }
        else if (i == n){
            System.out.println("Yes");
            return;
        }
        else{
            System.out.println("No");
            return;
        }
        
    }
}
