package Day5;
import java.util.*;
public class _05 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1018

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 보드 생성
        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) + "";
            }
        }
        
        // 최소 경우의 수
        // 1. 8 X 8일 경우 1번의 경우의 수만 탐색
        // 2. 10 X 13일 경우 3 * 6 = 18번의 경우의 수 탐색
        // 이유 : 가로가 10일경우 1번째 ~ 8번째, 2번째 ~ 9번째, 3번째 ~ 10번째 를 탐색하기 때문
        // 규칙 : N -7 * M-7
        // 탐색 : N -7 * M-7 안에서 1번째 ~ 8번째, 2번째 ~ 9번째, 3번째 ~ 10번째 탐색을 진행 해야함


        int minCount = 64;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                
                // 탐색할 board의 첫번째값 가져오기
                String condition = board[i][j];

                int count = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {

                        // conditon과 블록이 같지 않으면 count 증가
                        if(!condition.equals(board[k][l])){
                            count++;
                        }

                        // 교차로 출력 되어야 하므로 한개의 탐색이 끝나면 condition을 반대의 색으로 변경해준다.
                        if(condition.equals("B")){
                            condition = "W";
                        }
                        else{
                            condition = "B";
                        }
                    }

                    // 한줄 탐색 마무리 후 교차 비교를 위해 condtion을 반대의 색상으로 변경
                    // 이유 : condition은 짝수번(8) 변경됨, board가 W로 시작시 condtion은 W로 마무리 되기떄문
                    if(condition.equals("B")){
                        condition = "W";
                    }
                    else{
                        condition = "B";
                    }
                }

                // 1. 색칠 경우의 수와 최대 경우의수 - 색칠 경우의수를 빼서 더 작은 값을 도출
                // 이유 : 위의 로직에선 board에 첫번째 값 기준으로 경우의 수를 카운팅함
                //       만약 첫번째값이 변경 되었을때 칠해야 되는 경우의 수가 더 적을 수 있으므로 1번의 로직을 수행
                // 2. 경우의 수의 최솟값이 현재 칠해야되는 최소값보다 작을 경우 변수 값 변경
                minCount = Math.min(minCount, Math.min(count, 64-count));

            }
        }

        System.out.println(minCount);
    }
}
