package Day1;

import java.util.Scanner;

public class _01 {
    public static void main(String[] args) {

        // 문제
        // 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

        // 입력
        // 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

        // 출력
        // 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

        // 예제 입력 1
        // 5

        // 예제 출력 1
        // *
        // **
        // ***
        // ****
        // *****

        /**
         * 1. 1번째 줄엔 1개, 2번째 줄에 2개, n번째 줄에 n개 출력
         * 2. for 문을 활용하여 *을 index 만큼 반복하여 출력.
         */
        Scanner sc = new Scanner(System.in);

        int star = sc.nextInt();

        // 문제 답 - 최초 풀이
        for (int i = 1; i <= star; i++) {
            System.out.println("*".repeat(i));
        }

        // 문제 답 - repeat 메소드 미사용 풀이
        for (int i = 1; i <= star; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // 역순 별
        // for (int i = 1; i <= star; i++) {
        //     System.out.print(" ".repeat(star - i));
        //     System.out.println("*".repeat(i));
        // }
    }
}
