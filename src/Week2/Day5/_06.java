package Week2.Day5;
import java.util.*;
import java.io.*;
public class _06 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2606

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[vertex+1];
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visited[1] = true;

        while(!stack.isEmpty()){
            int nowStack = stack.pop();

            int loopCount = graph.get(nowStack).size();
            for (int i = 0; i < loopCount; i++) {
                int visit = graph.get(nowStack).get(i);
                if(!visited[visit]){
                    stack.add(visit);
                    visited[visit] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i < visited.length; i++) {
            if(visited[i]){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
