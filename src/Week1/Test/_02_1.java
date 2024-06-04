package Week1.Test;

import java.util.Scanner;

public class _02_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 바둑판 상태 입력 받기
        int[][] board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[] result = checkWinner(board);

        // 결과 출력
        System.out.println(result[0]);
        if (result[0] != 0) {
            System.out.println(result[1] + " " + result[2]);
        }
    }

    public static int[] checkWinner(int[][] board) {
        int n = 19;
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    int color = board[i][j];

                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        int count = 1;

                        while (0 <= ni && ni < n && 0 <= nj && nj < n && board[ni][nj] == color) {
                            count++;
                            if (count == 5) {
                                // 여섯 알 이상 연속된 경우 확인
                                if ((0 <= ni + dir[0] && ni + dir[0] < n && 0 <= nj + dir[1] && nj + dir[1] < n && board[ni + dir[0]][nj + dir[1]] == color) ||
                                        (0 <= i - dir[0] && i - dir[0] < n && 0 <= j - dir[1] && j - dir[1] < n && board[i - dir[0]][j - dir[1]] == color)) {
                                    break;
                                }
                                // 가장 왼쪽이나 위쪽 위치 반환
                                return new int[]{color, i + 1, j + 1};
                            }
                            ni += dir[0];
                            nj += dir[1];
                        }
                    }
                }
            }
        }
        return new int[]{0, -1, -1};
    }
}
