package Practice.Loop;
import java.util.*;
public class _04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print(" ".repeat(count - i));
            System.out.println("*".repeat(i));
        }

        for (int i = 1; i < count; i++) {
            for (int j = count - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
