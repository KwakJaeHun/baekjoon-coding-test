package Day5;
import java.util.*;
public class _04 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1652

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] room = new String[N][N];
        
        // 입력받은 문자열 2차원 배열로 생성
        for (int i = 0; i < N; i++) {
            String sentence = sc.next();
            for (int j = 0; j < N; j++) {
                room[i][j] = sentence.charAt(j) + "";
            }
        }

        int rowPossibleCount = 0;
        int columnPossibleCount = 0;

        String rowPossible = ""; // 가로로 누울 수 잇는 경우 비교 변수
        String columnPossible = ""; // 세로로 누울 수 잇는 경우 비교 변수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 가로를 탐색하면 .일 경우 . 추가 / X면 초기화
                if(room[i][j].equals(".")){
                    rowPossible += room[i][j];
                }
                else{
                    rowPossible = "";
                }

                // 세로를 탐색하면 .일 경우 . 추가 / X면 초기화
                if(room[j][i].equals(".")){
                    columnPossible += room[j][i];
                }
                else{
                    columnPossible = "";
                }
                
                // 두칸이상 확보 될 경우 경우의 수 증가
                if(rowPossible.equals("..")) rowPossibleCount++;
                if(columnPossible.equals("..")) columnPossibleCount++;
            }
            
            // 각 줄 탐색 후 비교 변수 초기화
            rowPossible = "";
            columnPossible = "";
        }

        System.out.println(rowPossibleCount + " " + columnPossibleCount);

    }
}
