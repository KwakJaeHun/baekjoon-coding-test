package Week2.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04 {
    static StringTokenizer st;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1939
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(x).add(new int[]{y, weight});
            graph.get(y).add(new int[]{x, weight});
            
            maxWeight = Math.max(weight, maxWeight);
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int left = 1;
        int rigth = maxWeight;
        
        while (left <= rigth){
            // bfs 탐색 후 방문 배열 초기화 헤줘야 중복 X
            visited = new boolean[N+1];
            int middle = (left + rigth) / 2;
            
            if(bfs(start, end, middle)){
                answer = middle;
                left = middle + 1;
            }
            else{
                rigth = middle -1;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(int start, int end, int w) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int nowQueue = queue.poll();

            for(int[] e : graph.get(nowQueue)){
                if(!visited[e[0]] && e[1] >= w){
                    if(e[0] == end){
                        return true;
                    }
                    queue.add(e[0]);
                    visited[e[0]] = true;
                }
            }
        }
        
        return false;
    }
}
