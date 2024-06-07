package Practice.SumArray;

import java.util.*;
public class _01 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/11659

        // 합배열 공식 : S[i] = s[i - 1] + A[i]
        // 합배열 구간함 공식 : S[j] - S[i-1] - i번째 부터 j번째까지

        Scanner sc = new Scanner(System.in);

        int ArrayCount = sc.nextInt();
        int sumCount = sc.nextInt();

        int[] sumArray = new int[ArrayCount + 1];
        for (int i = 1; i <= ArrayCount; i++) {

            int number = sc.nextInt();

            sumArray[i] = number + sumArray[i-1];
        }

        for (int i = 0; i < sumCount; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(sumArray[end] - sumArray[start - 1]);
        }

    }
}
