package Week4;

import java.util.*;

public class Day6 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/250136

    public static void main(String[] args) {


        String[] board= {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
        };

        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 0;

        int[] start = new int[3];
        ArrayList<ArrayList<String>> boardArr = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            char[] charArr = board[i].toCharArray();
            boardArr.add(new ArrayList<>());
            for (int j = 0; j < charArr.length; j++) {
                boardArr.get(i).add(charArr[j] + "");
                if(charArr[j] == 'R'){
                    start = new int[]{i, j, 0};
                }
            }
        }

        int n = boardArr.size();
        int m = boardArr.get(0).size();
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        int[] dx = {1, -1, 0, 0}; // 상 하 좌 우
        int[] dy = {0,  0, -1, 1};
        while(!q.isEmpty()){

            int[] nowQ = q.poll();
            int x = nowQ[0];
            int y = nowQ[1];
            int count = nowQ[2];

            if(boardArr.get(x).get(y).equals("G")){
                answer = count;
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while(nx >= 0 && nx < n && ny >= 0 && ny < m && !boardArr.get(nx).get(ny).equals("D")){
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];

                if(!visited[nx][ny] || (x != nx && y != ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        answer = -1;
        return answer;
    }

}
