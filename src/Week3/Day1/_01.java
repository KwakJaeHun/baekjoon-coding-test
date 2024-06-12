package Week3.Day1;
import java.util.*;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2798

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            if(arr[i] > M) continue;

            for (int j = i + 1; j < N - 1; j++) {
                if(arr[j] > M) continue;

                for (int k = j + 1; k < N; k++) {
                    if(arr[k] > M) continue;

                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == M){
                        answer = sum;
                        System.out.println(answer);
                        return;
                    }
                    else if(M > sum && sum > answer){
                        answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
