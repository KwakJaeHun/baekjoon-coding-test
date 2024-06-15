package Week3.Day3;

import java.io.*;
import java.util.*;

public class Greedy {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11047

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if(coin[i] > K){
                continue;
            }

            count += K / coin[i];
            K = K % coin[i];
        }

        System.out.println(count);
    }
}

class Greedy2 {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/16953

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        while(A != B){

            if(A > B){
                count = -1;
                break;
            }

            if (B % 10 == 1) {
                B /= 10;
                count++;
            }
            else if(B % 2 == 0){
                B /= 2;
                count++;
            }
            else{
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}

class Greedy3 {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1946

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] rank = new int[N+1];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int itv = Integer.parseInt(st.nextToken());

                rank[doc] = itv; 

            }
            
            int count = 1;
            int standard = rank[1];

            for (int j = 2; j <= N; j++) {
                // 기준보다 등수가 높은지 비교
                if(rank[j] < standard){
                    count++;
                    standard = rank[j];
                }
            }

            System.out.println(count);

        }

    }
}

