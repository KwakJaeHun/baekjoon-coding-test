package Day1;

import java.util.*;

public class _04 {
    public static void main(String[] args) {
        // 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
        // 5
        // 예제 출력 1

        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *

        /**
         * 1. n을 입력 받는다.
         *
         * 2. 첫번째 반목문을 통해 인덱스가 n + 1보다 작을때 까지 반복
         * 2-1. 인덱스만큼 *을 출력 / 공백은 n에서 인덱스를 뺀 후 2배 만큼 출력 / 인덱스만큼 *을 출력
         *
         * 3. 두번째 반복문을 통해 인덱스가 n보다 작을때 까지 반복
         * 3-1. n-인덱스 만큼 * 출력, 공백은 인덱스의 두배만큼 출력
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n+1; i++) {
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(2 * (n-i)));
            System.out.print("*".repeat(i));
            System.out.println();
        }

        for (int j = 1; j < n; j++) {
            System.out.print("*".repeat(n-j));
            System.out.print(" ".repeat(2*j));
            System.out.print("*".repeat(n-j));
            System.out.println();
        }
    }
}
