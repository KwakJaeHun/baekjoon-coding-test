package Week3.Day1;
import java.util.*;
import java.io.*;
public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1440

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int[] time = new int[3];
        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == j || j == k || i == k) continue;
                    if (time[i] > 0 && time[i] < 13 && time[j] < 60 && time[k] < 60) cnt++;
                }
            }
        }

        System.out.println(cnt);
        
    }
}
