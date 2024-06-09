package Week2.Day4;
import java.io.*;
import java.util.*;
public class _06 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1417

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine());
        
        // 내리차순 우선순위 Que
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a );
        for (int i = 0; i < testCase - 1; i++) {
            pq.add(Integer.parseInt(br.readLine())); 
        }
        
        int answer = 0;
        while(!pq.isEmpty() && pq.peek() >= first){
            int maxTicket = pq.poll();
            first++;
            answer++;
            
            // 제일 많은 티켓에 -1 후 내림차순 정렬 pq에 넣어주기
            pq.add(maxTicket -1);
        }

        System.out.println(answer);
    }
}
