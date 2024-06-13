package Week3.Day2;
import java.io.*;
import java.util.*;
public class _04 {
    static int n;  // 바닥의 카드 개수
    static int k; // 뽑아야되는 카드
    static String[] arr;
    static Set<String> result = new HashSet();
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/5568

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        permutation(new StringBuilder(), 0);

        System.out.println(result.size());
    }

    private static void permutation(StringBuilder sb, int start) {
        if(start == k){
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
           if(!visited[i]){
               visited[i] = true;
               sb.append(arr[i]);
               permutation(sb, start + 1);
               sb.delete(sb.length() - arr[i].length(), sb.length());
               visited[i] = false;
           }
        }
    }
}
