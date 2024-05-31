package Practice.String;
import java.util.*;
public class _05 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2444
        // 별 찍기 - 7 : 브론즈 3

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < 2 * i -1; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n-1; i > 0; i--) {
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i -1; j++) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}
