package Week2.Day5;
import java.io.*;
import java.util.*;
public class _05 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/18352

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수 
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 최단 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
        }

        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()){
            int[] nowQueue = queue.poll();

            int vertex = nowQueue[0];
            int count = nowQueue[1];

            if(count == K){
                answer.add(vertex);
            }

            int loopCount = graph.get(vertex).size();
            for (int i = 0; i < loopCount; i++) {
                if(!visited[graph.get(vertex).get(i)]){
                    queue.add(new int[]{graph.get(vertex).get(i), count + 1});
                    visited[graph.get(vertex).get(i)] = true;
                }
            }
        }

        if(answer.isEmpty()){
            System.out.print(-1);
        }
        else{
            Collections.sort(answer);
            for (int a : answer){
                System.out.println(a);
            }
        }
    }
}
