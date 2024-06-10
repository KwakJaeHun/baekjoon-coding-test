package Week2.Day5;
import java.io.*;
import java.util.*;

public class _01 {
    // https://www.acmicpc.net/problem/24479

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
    static int[] check; // 방문한 정점을 기록할 배열
    static int count; // 방문 순서

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
        // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
        check = new int[vertex+1];

        // graph의 index를 정점의 개수만큼 만들어줌
        for(int i =0; i < vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        // 오름차순을 위해 정렬
        for(int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        // 시작 정점도 순서에 포함이므로 count 초기값 1 할당
        count = 1;

        // 깊이 우선 탐색 재귀 시작
        dfs(startVertex);

        // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
        for(int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    // 깊이 우선 탐색 메서드
    private static void dfs(int vertex) {
        check[vertex] = count; // 현재 방문하고있는 정점에 순서 저장

        // 현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);

            //다음 갈 정점을 방문했었는지 체크(0일 경우 방문 X)
            if(check[newVertex] == 0){
                count++;
                dfs(newVertex);
            }
        }
    }
}

// 스택 구현
//public class _01 {
//    public static void main(String[] args) throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int dotCount    = Integer.parseInt(st.nextToken());
//        int edgeCount   = Integer.parseInt(st.nextToken());
//        int start       = Integer.parseInt(st.nextToken());
//
//        int[][] arr = new int[dotCount+1][dotCount+1];
//
//
//        for (int i = 0; i < edgeCount; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//
//            arr[x][y] = 1;
//            arr[y][x] = 1;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//
//        boolean[] visit = new boolean[dotCount+1];
//        stack.push(start);
//        visit[start] = true;
//
//        while(!stack.isEmpty()){
//
//            int pop = stack.pop();
//
//            for (int i = 1; i <= dotCount; i++) {
//                if(arr[pop][i] == 1 && !visit[i]){
//                    visit[i] = true;
//                    stack.push(i);
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= dotCount; i++) {
//            if(visit[i]){
//                sb.append(i).append("\n");
//            }
//            else{
//                sb.append("0").append("\n");
//            }
//        }
//
//        System.out.println(sb);
//    }
//}
