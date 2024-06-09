package Week2.Day4;
import java.util.*;
import java.io.*;

public class DFS {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n +1];

        int[][] graph = new int[n + 1][n +1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(graph, visit, 1);
        int count = 0; // 감염된 컴퓨터 개수
        for (int i = 1; i <= n; i++) {
            if(visit[i]){
                count++;
            }
        }

        System.out.println(count - 1);
    }

    private static void dfs(int[][] graph, boolean[] visit, int start){

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;

        while(!stack.isEmpty()){
            int vertex = stack.pop();

            for (int i = 1; i < graph.length; i++) {
                if(graph[vertex][i] == 1 && !visit[i]){
                    visit[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
