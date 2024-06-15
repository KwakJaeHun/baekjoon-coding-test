package Week3.Day4;
import java.io.*;

public class _04 {
    static int[] dp = new int[12];
    static int count = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            int n = Integer.parseInt(br.readLine());

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            //fibo(n);

            for (int j = 4; j <= n; j++) {
                count++;
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            //System.out.println(dp[n]);
            System.out.println(count);

        }
    }

    private static int fibo(int n){

        if(dp[n] != 0){
            count++;
            return dp[n];
        }

        return dp[n] = fibo(n-1) + fibo(n-2) + fibo(n-3);
    }
}
