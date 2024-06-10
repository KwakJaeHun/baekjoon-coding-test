package Week2.Day5;
import java.io.*;
import java.util.*;

public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/24444

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[vertex+1];
        int[] visitedOrder = new int[vertex+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int visitCount = 1;
        visitedOrder[start] = visitCount++;

        while(!queue.isEmpty()){
            int nowQueue = queue.poll();

            for(int v : graph.get(nowQueue)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                    visitedOrder[v] = visitCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= vertex; i++){
            sb.append(visitedOrder[i]).append("\n");
        }

        System.out.println(sb);
    }
}
