package Practice.Loop;
import java.util.*;
public class _03 {
    public static void main(String[] args) {
        // 영수증 합 계산
        Scanner sc = new Scanner(System.in);

        int totalPrice = sc.nextInt();

        int sumPrice = 0;

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int eachPrice = sc.nextInt();
            int eachCount = sc.nextInt();

            sumPrice += eachPrice * eachCount;
        }

        if(totalPrice == sumPrice) System.out.println("Yes");
        else System.out.println("No");
    }
}
