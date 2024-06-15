package Week3.Day3;

import java.io.*;
import java.util.*;

public class Dijkstra {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1753

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine());

        List<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 도착 정점
            int w = Integer.parseInt(st.nextToken()); // 이동 가중치

            list.get(u).add(new int[]{v, w});
        }

        boolean[] visited = new boolean[V+1]; // 방문 배열
        int[] distance = new int[V+1]; // 최단 거리 배열
        for (int i = 0; i < V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        
        // 거리를 기준으로 우선순위 Queue 를 생성해야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        pq.add(new int[]{0, start});
        distance[start] = 0;

        while(!pq.isEmpty()){
            int[] nextQue = pq.poll();
            int current = nextQue[1];

            if(visited[current]){
                continue;
            }
            visited[current] = true;
            for(int[] tmp : list.get(current)){
                int next = tmp[0]; // 다음 정점
                int value = tmp[1]; // 이동 가중치

                if(distance[next] > distance[current] + value){
                    distance[next] = distance[current] + value;
                    pq.add(new int[]{distance[next], next});
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if(visited[i]){
                System.out.println(distance[i]);
            }
            else{
                System.out.println("INF");
            }
        }
    }
}
