package Day3;
import java.util.*;
public class _04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print(fib(n) + " " + fibonacci(n));

    }

    public static int fib(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        else{
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static int fibonacci(int n){
        int[] fibonacci = new int[n+1];
        fibonacci[1] = fibonacci[2] = 1;

        int count = 0;
        for (int i = 3; i <= n; i++) {
            count++;
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return count;

    }
}
