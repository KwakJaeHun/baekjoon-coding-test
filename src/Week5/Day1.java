package Week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day1 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/154540

    private static int m;
    private static int n;
    private static boolean visited[][];

    public static void main(String[] args) {


        String[] maps = {
                "XXXXX",
                "XXXXX",
                "XXXXX",
                "XXXXX"
        };

        System.out.println(Arrays.toString(solution(maps)));
    }

    public static int[] solution(String[] maps) {

        m = maps.length;
        n = maps[0].length();
        visited = new boolean[m][n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    pq.add(bfs(i,j, maps));
                }
            }
        }
        if(pq.size() > 0 ){
            int[] answer = new int[pq.size()];
            int loopCount = pq.size();
            for (int i = 0; i < loopCount; i++) {
                int p = pq.poll();
                answer[i] = p;

            }

            return answer;
        }
        else{
            return new int[]{-1};
        }
    }
    
    public static int bfs(int i, int j, String[] maps){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        while (!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            sum += Integer.parseInt(maps[x].charAt(y) + "");
            
            int[] dx = {-1, 1,  0, 0}; // 상하좌우
            int[] dy = {0,  0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || maps[nx].charAt(ny) == 'X'){
                    continue;
                }

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return sum;
    }

}
