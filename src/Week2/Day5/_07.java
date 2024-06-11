package Week2.Day5;
import java.util.*;
import java.io.*;
public class _07 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/21937

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(y).add(x);
        }

        int start = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vertex + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int answer = 0;
        while (!queue.isEmpty()){
            int nowQueue = queue.poll();

            int loopCount = graph.get(nowQueue).size();
            for (int i = 0; i < loopCount; i++) {
                int index = graph.get(nowQueue).get(i);
                if(!visited[index]){
                    queue.add(index);
                    visited[index] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
