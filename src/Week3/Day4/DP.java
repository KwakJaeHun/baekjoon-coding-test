package Week3.Day4;
import java.io.*;
import java.util.*;

public class DP {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/11726

        // bottom-up dp
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] result = new long[N+1];
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= N; i++) {
            result[i] = (result[i-1] + result[i-2]) % 10007;
        }

        System.out.println(result[N]);
    }
}

class DP2 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/11053

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];
        Arrays.fill(memo, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}
