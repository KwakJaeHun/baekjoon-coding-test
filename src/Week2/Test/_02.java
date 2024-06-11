package Week2.Test;
import java.util.*;
import java.io.*;
public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/13975

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            PriorityQueue<Long> pq = new PriorityQueue<>();

            int fileCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < fileCount; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while(pq.size() >= 2){
                long x = pq.poll();
                long y = pq.poll();
                sum += x + y;
                pq.add(x + y);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
