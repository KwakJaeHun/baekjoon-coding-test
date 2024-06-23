package Week4;

import java.util.*;

public class Day5 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/250136

    public static void main(String[] args) {


        int[][] land =
                {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}
                ;

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {

        int n = land.length;
        int m = land[0].length;
        // 시추관 위치별 석유량
        int[] oil = new int[m];

        // 상, 하, 좌, 우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int count = 1;
                Queue<int[]> q = new LinkedList<>();

                Set<Integer> set = new HashSet<>();

                if(land[i][j] == 1 && !visit[i][j]){
                    q.add(new int[]{i, j});
                    visit[i][j] = true;

                    while(!q.isEmpty()){
                        int[] xy = q.poll();
                        set.add(xy[1]);

                        int x = xy[0];
                        int y = xy[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                                continue;
                            }

                            if(!visit[nx][ny] && land[nx][ny] == 1){
                                q.add(new int[]{nx, ny});
                                visit[nx][ny] = true;
                                count++;
                            }
                        }
                    }

                    for (int index : set) {
                        oil[index] += count;
                    }
                }
            }
        }

        int answer = 0;
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;

    }
}
