package Week3.Day3;
import java.io.*;
import java.util.*;
public class _04 {
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1504

        // 다익스트라
        // 1. 정점의 개수만큼 ArrayList 만들기 - 양방향 그래프
        // 2. 정점 방문 배열 만들기 - 양방향이므로 방문배열 없이 모두 최저값 탐색
        // 3. 거리 배열 만들기
        // 4. 거리 우선 순위 PriorityQueue 만들기
        // 5. 비교하여 거리배열에 최단 거리 넣어주기
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 시작
            int b = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 거리

            list.get(a).add(new int[]{b,c});
            list.get(b).add(new int[]{a,c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); // 무조건 방문
        int v2 = Integer.parseInt(st.nextToken()); // 무조건 방문

        long[] dist1 = dijkstra(1); // 1에서 2,3,4 최단 거리
        long[] distV1 = dijkstra(v1); // 2에서 1,3,4 최단거리
        long[] distV2 = dijkstra(v2); // 3에서 1,2,4 최단거리
        
        // 양방향이므로 두개의 조건 탐색
        long result1 = dist1[v1] + distV1[v2] + distV2[N]; // 1 -> 2, 2 -> 3, 3 -> 4
        long result2 = dist1[v2] + distV2[v1] + distV1[N];// 1 -> 3, 3 -> 2, 2 -> 4

        long answer = Math.min(result1, result2);

        if (answer >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static long[] dijkstra(int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[0] - o2[0]));
        long[] distance = new long[N + 1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[start] = 0;
        pq.add(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] nowQueue = pq.poll();
            long current = nowQueue[1];

            if(visited[(int) current]) continue;

            visited[(int) current] = true;

            for (int[] tmp : list.get((int) current)) {
                int next = tmp[0];
                int value = tmp[1];

                if (distance[next] > distance[(int) current] + value) {
                    distance[next] = distance[(int) current] + value;
                    pq.add(new long[]{distance[next], next});
                }
            }
        }
        return distance;
    }
}
