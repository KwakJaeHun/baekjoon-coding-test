package Practice.Loop;
import java.util.*;
public class _01 {
    public static void main(String[] args) {
        // 구구단
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 1; i <= 9 ; i++) {
            System.out.println(num + " * " + i + " = " + num * i);
        }
    }
}
