package Week3.Day3;
import java.io.*;
import java.util.*;
public class _03 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/14720

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] store = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(store[i] == index){
                index = index == 2 ? 0 : index + 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
