package Week3.Test;
import java.io.*;
import java.util.*;

public class _02 {
    public static void main(String[] args) throws IOException {

        // https://www.acmicpc.net/problem/2212

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // N-1개의 거리 배열
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(distance);

        int answer = 0;
        // 예제 2 : N-1개의 거리배열에 센서를 수용할 최소거리 기지국 5개를 세우면 4개의 큰 공간이 생김
        for (int i = 0; i < (N - 1) - (K - 1); i++) {
            answer += distance[i];
        }

        System.out.println(answer);
    }
}