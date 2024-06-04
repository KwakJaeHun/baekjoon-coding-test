import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                boolean winner = searchBoard(board, i ,j);
                if(winner){
                    return;
                }
            }
        }

        System.out.println(0);
    }

    private static boolean searchBoard(int[][] board, int i, int j) {

        if(board[i][j] != 0){
            int startColor = board[i][j];

            // 가로 탐색 - 가로 인덱스가 14보다 작거나 같아야지 끝까지 탐색가능, 이전 오목 색이 다를때 탐색 시작
            if( (j <= 14 && startColor == board[i][j+1]) && !(j > 0 && startColor == board[i][j-1])){
                // 탐색 시작한 이전 바둑알 탐색
                // 1,2번째 오목알은 같으므로 3,4,5번째 오목알 탐색
                for (int k = 1; k <= 3; k++) {
                    // 탐색중 같지 않으면 반목문 종료
                    if(startColor != board[i][j+1+k] ){
                        break;
                    } else if (k == 3) {
                        // 앞뒤 6번째 오목알이 같지 않거나 바둑판 마지막일때 결과 출력
                        if( !(j+1+k < 18 && board[i][j+1+k+1] == startColor) ){
                            System.out.println(startColor);
                            System.out.println((i+1) + " " + (j+1));
                            return true;
                        }
                    }
                }
            }
            // 세로 탐색 - 세로 인덱스가 14보다 작거나 같아야지 끝까지 탐색 가능
            else if( (i <= 14 && startColor == board[i+1][j]) && !(i > 0 && startColor == board[i-1][j]) ){
                // 1,2번째 오목알은 같으므로 3,4,5번째 오목알 탐색
                for (int k = 1; k <= 3; k++) {
                    // 탐색중 같지 않으면 반목문 종료
                    if(startColor != board[i+1+k][j]){
                        break;
                    } else if (k == 3) {
                        // 앞뒤 6번째 오목알이 같지 않거나 바둑판 마지막일때 결과 출력
                        if(!(i+1+k < 18 && board[i+1+k+1][j] == startColor) ){
                            System.out.println(startColor);
                            System.out.println((i+1-4) + " " + (j+1));
                            return true;
                        }
                    }
                }
            }
            // 대각선 탐색 - 가로, 세로 인덱스가 14보다 작거나 같아야지 끝까지 탐색 가능
            else if( (i <= 14 && j <= 14 && startColor == board[i+1][j+1]) && !(i > 0 && j > 0 && startColor == board[i-1][j-1])){
                // 1,2번째 오목알은 같으므로 3,4,5번째 오목알 탐색
                for (int k = 1; k <= 3; k++) {
                    // 탐색중 같지 않으면 반목문 종료
                    if(startColor != board[i+1+k][j+1+k]){
                        break;
                    } else if (k == 3) {
                        // 앞뒤 6번째 오목알이 같지 않거나 바둑판 마지막일때 결과 출력
                        if( !(i+1+k < 18 && j+1+k < 18 && board[i+1+k+1][j+1+k+1] == startColor) ){
                            System.out.println(startColor);
                            System.out.println((i+1) + " " + (j+1));
                            return true;
                        }
                    }
                }
            }
            // 역대각선 탐색 - 세로 인덱스는 14보다 작거나 같고 가로 인덱스는 4보다 크거나 같아야 끝까지 탐색 가능
            else if( (i <= 14 && j >= 4 && startColor == board[i+1][j-1]) && !(i > 0 && j < 18 && startColor == board[i-1][j+1])){
                // 1,2번째 오목알은 같으므로 3,4,5번째 오목알 탐색
                for (int k = 1; k <= 3; k++) {
                    // 탐색중 같지 않으면 반목문 종료
                    if(startColor != board[i+1+k][j-1-k]){
                        break;
                    } else if (k == 3) {
                        // 엎뒤 목알이 같지 않거나 바둑판 마지막일때 결과 출력
                        if( !(i+1+k < 18 && j-1-k > 0 && board[i+1+k+1][j-1-k-1] == startColor)){
                            System.out.println(startColor);
                            System.out.println((i+1+4) + " " + (j+1-4));
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}