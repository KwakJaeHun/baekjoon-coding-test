package Week2.Day5;
import java.io.*;
import java.util.*;
public class _03 {
    static StringTokenizer st;
    static int answer = -1;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2644

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertex = Integer.parseInt(br.readLine());
        visited = new boolean[vertex+1];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int edge = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(w).add(z);
            graph.get(z).add(w);
        }

        dfs(x,y,0);
        System.out.println(answer);

        // 스택 구현
//        int[] visited = new int[vertex+1];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(x);
//        while(!stack.isEmpty()) {
//            int nowStack = stack.pop();
//            if(nowStack == y) {
//                return;
//            }
//            for(int n : graph.get(nowStack)) {
//                if(visited[n] == 0) {
//                    visited[n] = visited[nowStack]+1;
//                    stack.push(n);
//                }
//            }
//        }
    }
    
    // 재귀함수 구현
    private static void dfs(int x, int y, int count){
        if(x == y){
            answer = count;
        }
        else{
            visited[x] = true;
            int loopCount = graph.get(x).size();
            for (int i = 0; i < loopCount; i++) {
                if(!visited[graph.get(x).get(i)]){
                    dfs(graph.get(x).get(i), y, count + 1);
                }
            }
        }
    }

}
