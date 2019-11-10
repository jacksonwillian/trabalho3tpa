import java.util.Scanner;
import java.util.Stack;

/**
 * Vinicius Freitas Rocha
    00514
 */
    class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int n = scanner.nextInt();

            while (n != 0) {

                int[] in = new int[n];

                for (int i = 0; i < n; i++) {
                    int x = scanner.nextInt();
                    if (x != 0) {
                        in[i] = x;
                    }
                    else {
                        n = 0;
                        break;
                    }
                }
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
                }
                else if (i == n){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");              
                }
            }
        }
        scanner.close();
    }
}
