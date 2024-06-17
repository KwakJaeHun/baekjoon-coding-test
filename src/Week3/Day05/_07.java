package Week3.Day05;
import java.io.*;
import java.util.*;
public class _07 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/13305

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N-1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0; // 자료형...
        int standardPrice = price[0];
        for (int i = 0; i < N-1; i++) {
            if(price[i] < standardPrice){
                standardPrice = price[i];
            }

            answer += (long)standardPrice * distance[i];
        }

        System.out.print(answer);
    }
}
