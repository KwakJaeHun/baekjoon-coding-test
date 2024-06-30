package Week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day7 {
// https://school.programmers.co.kr/learn/courses/30/lessons/159993

    public static  int n;
    public static  int m;

    public static  int[] start = new int[2];
    public static  int[] lever = new int[2];
    public static  int[] end = new int[2];

    public static void main(String[] args) {


        String[] board= {
                "SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"
        };

        System.out.println(solution(board));
    }

    public static int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();


        ArrayList<ArrayList<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                String square = maps[i].charAt(j) + "";
                board.get(i).add(square);
                if(square.equals("S")){
                    start = new int[]{i, j};
                }
                else if(square.equals("L")){
                    lever = new int[]{i, j};
                }
                else if(square.equals("E")){
                    end = new int[]{i, j};
                }
            }
        }

        int startToLever = bfs(board, start, lever);
        int leverToEnd = bfs(board, lever, end);

        if(startToLever == -1 || leverToEnd == -1){
            return -1;
        }

        return startToLever + leverToEnd;
    }

    private static int bfs(ArrayList<ArrayList<String>> board, int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] xyc = q.poll();

            int x = xyc[0];
            int y = xyc[1];
            int c = xyc[2];

            if(x == end[0] && y == end[1]){
                return c;
            }

            int[] dx = {-1, 1,  0, 0}; // 상 하 좌 우
            int[] dy = {0,  0, -1, 1};
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || board.get(nx).get(ny).equals("X")){
                    continue;
                }

                q.add(new int[]{nx, ny, c + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }


}
