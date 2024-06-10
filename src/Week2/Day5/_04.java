package Week2.Day5;

import java.io.*;
import java.util.*;
public class _04 {
    // 나이트 이동 좌표
    static int[] moveX = {2,   1,  -2,  -1,  2,  1,  -2,  -1};
    static int[] moveY = {-1, -2,  -1,  -2,  1,  2,   1,   2} ;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int answer = bfs(length, startX, startY, endX, endY);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int length, int startX, int startY, int endX, int endY){

        boolean[][] visited = new boolean[length][length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] nowQueue = queue.poll();
            int x = nowQueue[0];
            int y = nowQueue[1];
            int count = nowQueue[2];
            
            // 움직일 수 있는 좌표 모두 검색
            for (int i = 0; i < 8; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if(x == endX && y == endY){
                    return count;
                }

                // 0,0 보다 크거나 같고 length 보다 작을때 queue에 추가
                if(nx >= 0 && nx < length && ny >= 0 && ny < length && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1;
    }
}
