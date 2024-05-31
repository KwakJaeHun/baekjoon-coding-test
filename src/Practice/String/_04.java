package Practice.String;

import java.util.*;
public class _04 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/3003

        Scanner sc = new Scanner(System.in);

        int[] chessStandard = {1,1,2,2,2,8};
        int[] chessHave = new int[6];

        for (int i = 0; i < chessHave.length; i++) {
            chessHave[i] = sc.nextInt();
        }

        for (int i = 0; i < chessHave.length; i++) {

            System.out.print(chessStandard[i] - chessHave[i] + " ");
        }

    }
}
