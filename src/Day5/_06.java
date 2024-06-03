package Day5;
import java.util.*;
public class _06 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1051

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();

        // 한줄일 경우 정사각형의 최대 크기는 1*1이므로 1 출력 후 로직 종료
        if(N == 1 || M == 1){
            System.out.println(1);
            return;
        }

        int[] numbersArray = new int[51];
        int[][] rectangleArray = new int[N][M];


        for (int i = 0; i < N; i++) {
            String numbers = sc.next();
            for (int j = 0; j < M; j++) {
                numbersArray[Integer.parseInt(numbers.charAt(j) + "")]++; // 숫자별 개수 입력
                rectangleArray[i][j] = Integer.parseInt(numbers.charAt(j) + "");
            }
        }

        // 동일 숫자가 4개이상 없는 경우 1*1 이므로 1 출력 후 로직 종료
        int numberCount = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            if(numbersArray[i] >= 4){
                numberCount++;
            }
        }
        if(numberCount == 0){
            System.out.println(1);
            return;
        }
        
        // 최대값 까지만 탐색하기 2 - 배열 줄이기
        int length = Math.min(M,N); // 구할 수 있는 변 최대값
        while(true){
            // 첫번째 줄부터 탐색, 최소 1줄은 탐색해야 하므로 +1 해줌
            for (int i = 0; i < N-length + 1; i++) {
                for (int j = 0; j < M-length + 1; j++) {
                    int first = rectangleArray[i][j];
                    if
                    (
                        first == rectangleArray[i][j+length-1] &&
                        first == rectangleArray[i+length-1][j] &&
                        first == rectangleArray[i+length-1][j+length-1]
                    )
                    {
                        System.out.println(length*length);
                        return;
                    }
                }
            }
            length--;
        }

        
//        제일 큰 경우의 수 부터 줄여 나가다 찾으면 break --너무 비효율 적인 로직이었다... ㅠ
//        4차워 for문 제외 생각
//        제일 큰 경우의 수 부터 줄여 나가다 찾으면 break
//        int maxLength = 1;
//        int limitArea = Math.min(M,N) * Math.min(M,N);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                for (int k = N - 1; k >  i; k --) {
//                    for (int l = M -1; l > j; l--) {
//                        if(
//                            // [0,2] [0,4]  [i,j] [i,l]
//                            // [2,2] [2,4]  [k,j] [k,l]
//                                rectangleArray[i][j] == rectangleArray[i][l] &&
//                                rectangleArray[i][j] == rectangleArray[k][j] &&
//                                rectangleArray[i][j] == rectangleArray[k][l] &&
//                                // 조건문 2개 보완
//                                // 1, 변1 X 변2 이 최대 변 길이 보다 작거나 같은지
//                                // 2, 변1 X 변2 이 변1으로 나누었을때 변1의 값과 같은지
//                                (k - i + 1) * (l - j + 1) <=  limitArea &&
//                                (k - i + 1) * (l - j + 1) / (k - i + 1) == (k - i + 1)
//                        )
//                        {
//                            maxLength = Math.max(maxLength, (k - i + 1) * (l - j + 1));
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(maxLength);
        
    }
}
