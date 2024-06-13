package Week3.Day2;
import java.io.*;
import java.util.*;
public class _03 {
    static int answer = 0;
    static int[] N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // https://www.acmicpc.net/problem/30821

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        N = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = i+1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        combination(list, 0);

        System.out.println(answer);
    }

    private static void combination(ArrayList<Integer> list, int start) {

        if(list.size() == 5){
            answer++;
            return;
        }

        for (int i = start; i < N.length; i++) {
            list.add(N[i]);
            combination(list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
