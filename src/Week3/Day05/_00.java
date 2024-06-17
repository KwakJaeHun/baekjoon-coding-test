package Week3.Day05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _00 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/81302

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(solution(places)));;

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            
            String[] room = places[i];
            boolean check = true;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(room[j].charAt(k) == 'P'){
                        if(!bfs(j, k, room)){
                            check = false;
                        }
                    }
                }
            }

            answer[i] = check ? 1 : 0;

        }
        return answer;
    }

    private static boolean bfs(int x, int y, String[] room) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int[] dx = {0,  0, -1, 1}; // 상, 하, 좌, 우
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y)){
                    continue;
                }

                int distance = Math.abs(x - nx) + Math.abs(y - ny);
                if(room[nx].charAt(ny) == 'P' && distance <= 2){
                    return false;
                }

                if(room[nx].charAt(ny) == 'O' && distance < 2){
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return true;
    }

}
