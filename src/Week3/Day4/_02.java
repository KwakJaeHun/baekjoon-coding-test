package Week3.Day4;
import java.io.*;
public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2775

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[k+1][n+1];

        // 0층 값 넣어주기
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                // ex ) 1층의 3호 : 1층의 2호 (0층의 1호 + 0층의 2호) + 0층의 3호로 계단식 상승?
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }


        for (int i = 0; i < T; i++) {
            System.out.println(dp[k][n]);
        }


    }

}
