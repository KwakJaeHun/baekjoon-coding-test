package Week3.Day05;
import java.io.*;
import java.util.*;

public class _06 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2512

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] costs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;
        }

        Arrays.sort(costs);

        int totalCost = Integer.parseInt(br.readLine());

        int start = 1;
        int end = costs[N-1];
        int answer = 0;

        while(start <= end){
            int middle = (start + end) / 2;

            int sum = 0;
            for(int c : costs){
                if(c > middle){
                    sum += middle;
                }
                else{
                    sum += c;
                }
            }

            // 총 비용보다 위의 계산이 작거나 같으면 맞춰야하는 평균값이 더 커질 수 있으므로 start 증가
            // 작거나로 했다가 실패... 이분탐색때 비교연산자 주의!
            if(totalCost >= sum){
                start = middle + 1;
                answer = middle;
            }
            else{
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
