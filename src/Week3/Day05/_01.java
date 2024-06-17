package Week3.Day05;
import java.io.*;
import java.util.*;
public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1145

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = arr[0];
        while(true){

            int count = 0;
            for (int i = 0; i < 5; i++) {
                if(answer % arr[i] == 0) count++;
            }
            if(count >= 3) break;

            answer++;
        }

        System.out.println(answer);
    }
}
