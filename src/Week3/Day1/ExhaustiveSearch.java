package Week3.Day1;
import java.util.*;
import java.io.*;
public class ExhaustiveSearch {

    static int N ,answer;
    static int[][] matrix;
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        // https://www.acmicpc.net/problem/14889
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, N/2);
    }

    private static void combination(int start, int r) {
        if(r == 0){
            answer = Math.min(answer, calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static int calculate() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += matrix[i][j];
                    startTeam += matrix[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    linkTeam += matrix[i][j];
                    linkTeam += matrix[j][i];
                }
            }
        }
        return Math.abs(startTeam - linkTeam);
    }
}

class ExhaustiveSearch2{
    public static void main(String[] args) throws IOException{
        // https://www.acmicpc.net/problem/2468
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, matrix[i][j]);
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 , -1, 1};

        int answer = 0;
        for (int h = 0; h < maxHeight; h++) {
            boolean[][] visited = new boolean[N + 1][N + 1];
            int count = 0; // 현재 높이에서의 안전영역의 개수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 특정 좌표에서 안전영역 확인
                    if (!visited[i][j] && matrix[i][j] > h) {
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{i, j});
                        visited[i][j] = true;

                        while (!stack.isEmpty()) {
                            int[] now = stack.pop();

                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];

                                if (nx < 0 || ny < 0 || nx >= N || ny >=N) {
                                    continue;
                                }

                                if (visited[nx][ny]) {
                                    continue;
                                }

                                // 새로운 지점의 높이가 물높이보다 높은 경우
                                if (matrix[nx][ny] > h) {
                                    visited[nx][ny] = true;
                                    stack.push(new int[]{nx, ny});
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}