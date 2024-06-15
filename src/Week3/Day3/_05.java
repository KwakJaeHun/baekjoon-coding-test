package Week3.Day3;
import java.io.*;
import java.util.*;
public class _05 {
    static int n;

    public static void main(String[] args) throws IOException{

        // 단방향임
        // dfs 를 통해 감염 개수 체크 - 다익스트라 방문배열에서 갯수 셀 수 있으므로 설계에서 제외
        // 다익스트라를 통해 감염시간 체크

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹 당한 컴퓨터 번호
            
            // 다익 배열 추가 - 반복문 종료 후 초기화 되야함
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();  // 다익스트라
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // dfs
            
            // 배열 추가
            for (int j = 0; j < n + 1; j++) {
                // dfs
                // graph.add(new ArrayList<>());

                // 다익
                list.add(new ArrayList<>());
            }
            
            // 컴퓨터 의존성 추가

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // a 가
                int b = Integer.parseInt(st.nextToken()); // b 를 의존하며
                int s = Integer.parseInt(st.nextToken()); // b가 감연되면 a가 감염되는 시간

                // dfs
                // graph.get(b).add(a);

                // 다익
                list.get(b).add(new int[]{a, s});
            }

            // int resultDfs = dfs(c, graph); - 방문 배열이 있으므로 한곳에서 찾을 수 있겠다는 생각이 들었음.
            int[] resultDijk = dijk(c, list);
            System.out.println(resultDijk[0] + " " + resultDijk[1]);
        }
        
    }

    private static int[] dijk(int start, ArrayList<ArrayList<int[]>> list) {
        boolean[] visitedDijk = new boolean[n+1];
        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, start});
        distance[start] = 0;

        while (!pq.isEmpty()){
            int[] nowQueue = pq.poll();
            int current = nowQueue[1];

            if(visitedDijk[current]){
                continue;
            }
            visitedDijk[current] = true;

            for(int[] l : list.get(current)){
                int next = l[0];
                int value = l[1];

                if(distance[next] > distance[current] + value){
                    distance[next] = distance[current] + value;
                    pq.add(new int[]{distance[next], next});
                }
            }
        }

        int count = 0;
        int second = 0;
        for (int i = 0; i < n+1; i++) {
            if(visitedDijk[i]){
                count++;
                second = Math.max(second, distance[i]);
            }
        }

        return new int[]{count, second};
    }

    // private static int dfs(int start, ArrayList<ArrayList<Integer>> graph) {
    //        boolean[] visitedDfs;
    //        visitedDfs = new boolean[n+1];
    //
    //        Stack<Integer> stack = new Stack<>();
    //        stack.add(start);
    //        visitedDfs[start] = true;
    //
    //        while(!stack.isEmpty()){
    //            int nowStack = stack.pop();
    //
    //            for(int g : graph.get(nowStack)){
    //                if(!visitedDfs[g]){
    //                    stack.add(g);
    //                    visitedDfs[g] = true;
    //                }
    //            }
    //        }
    //
    //        int answer = 0;
    //        for (int i = 1; i < visitedDfs.length; i++) {
    //            if(visitedDfs[i]){
    //                answer++;
    //            }
    //        }
    //
    //        return answer;
    //    }
}
