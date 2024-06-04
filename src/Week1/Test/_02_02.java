package Week1.Test;
import java.util.*;
public class _02_02 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2615
        // 성공

        Scanner sc = new Scanner(System.in);

        int[][] board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 순차 탐색
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if(board[i][j] != 0){

                    int start = board[i][j];

                    // 가로, 세로, 대각선, 역대각선 순차 탐색
                    
                    // 가로 - j + n이 18 이하여야함 , 첫 바둑알과 4개의 바둑알 비교이므로 4번 반복
                    int count = 0;
                    for (int k = 1; k <= 4; k++) {
                        if(j + k <= 18 && start == board[i][j+k]){
                            count++;
                            // 첫 바둑알부터 4개를 탐색했을때 모두 같으면
                            if(count == 4){
                                // 시작의 앞, 끝의 뒤가 같은색이 아닌지 확인
                                if( (0 < j && board[i][j-1] == start) ||  (j + k < 18 && board[i][j+k+1] == start) ){
                                    break;
                                }
                                System.out.println(start);
                                System.out.print((i+1) + " " + (j+1));
                                return;
                            }
                        }   
                    }
                    // 세로 - i + k는 18이하
                    count = 0;
                    for (int k = 1; k <= 4; k++) {
                        if(i + k <= 18 && start == board[i+k][j]){
                            count++;
                            // 첫 바둑알부터 4개를 탐색했을때 모두 같으면
                            if(count == 4){
                                // 시작의 앞, 끝의 뒤가 같은색이 아닌지 확인
                                if( (0 < i && board[i-1][j] == start) ||  (i + k < 18 && board[i+k+1][j] == start) ){
                                    break;
                                }
                                System.out.println(start);
                                System.out.print((i+1) + " " + (j+1));
                                return;
                            }
                        }
                    }
                    // 대각선 - i + k 는 18이하 , j + k 는 18 이하
                    count = 0;
                    for (int k = 1; k <= 4; k++) {
                        if(i + k <= 18 && j + k <= 18 && start == board[i+k][j+k]){
                            count++;
                            // 첫 바둑알부터 4개를 탐색했을때 모두 같으면
                            if(count == 4){
                                // 시작의 앞, 끝의 뒤가 같은색이 아닌지 확인
                                if( (0 < i && 0 < j && board[i-1][j-1] == start) ||  (i + k < 18 && j + k < 18 && board[i+k+1][j+k+1] == start) ){
                                    break;
                                }
                                System.out.println(start);
                                System.out.print((i+1) + " " + (j+1));
                                return;
                            }
                        }
                    }
                    // 역대각선 - i + k 는 18이하 , j - k 는 0 이상
                    count = 0;
                    for (int k = 1; k <= 4; k++) {
                        if(i <= 14 && j >= 4  && start == board[i+k][j-k]){
                            count++;
                            // 첫 바둑알부터 4개를 탐색했을때 모두 같으면
                            if(count == 4){
                                // 시작의 앞, 끝의 뒤가 같은색이 아닌지 확인
                                if( (0 < i && j < 18 && board[i-1][j+1] == start) ||  (i + k < 18 && j - k > 0 && board[i+k+1][j-k-1] == start) ){
                                    break;
                                }
                                System.out.println(start);
                                System.out.print((i+1+4) + " " + (j+1-4));
                                return;
                            }
                        }
                    }
                }

            }
        }

        System.out.println(0);
    }
}
