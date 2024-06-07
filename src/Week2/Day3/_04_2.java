package Week2.Day3;
import java.io.*;
import java.util.*;
public class _04_2 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1654

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lanArray = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            int length = Integer.parseInt(br.readLine());
            lanArray[i] = length;
            max = Math.max(max, length);
        }

        long answer = 0;
        long start = 1;
        long end = max;

        while(start <= end){
            long middle = (start + end) / 2;

            long getLan = 0;
            for(int l : lanArray){
                if(l >= middle){
                    getLan += l / middle;
                }
            }

            if(getLan >= n){
                answer = middle;
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
