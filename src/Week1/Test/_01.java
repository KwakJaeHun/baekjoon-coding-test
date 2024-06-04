package Week1.Test;
import java.util.*;
public class _01 {

    // https://www.acmicpc.net/problem/1244
    
    static int[] arr;
    
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1244

        Scanner sc = new Scanner(System.in);

        // 전구 배열
        arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 학생 수
        int studentCount = sc.nextInt();

        for (int i = 0; i < studentCount; i++) {
            int gender = sc.nextInt();  // 성별
            int index = sc.nextInt();  // 조작해야 할 스위치 위치
            
            changeSwitchState(gender, index); // 전구 스위치 조작
            
        }

        for(int a : arr){
            System.out.print(a + " ");
        }
    }

    private static void changeSwitchState(int gender, int index) {

        // 남자일때
        if(gender == 1){
            for (int i = 1; i <= arr.length / index; i ++) {
                arr[index * i -1] = arr[index * i -1] == 1 ? 0 : 1;
            }
        }
        // 여자일때
        else{
            int start = 0;
            int end = 0;
            for (int i = 0; i < arr.length / 2; i ++) {
                // 시작이 0보다 크거나 같고 끝은 배열 사이즈 - 1 보다 작거나 같으며 대칭 숫자가 같으면 시작, 끝 index 할당
                if(index - 2 - i >= 0 && index + i <= arr.length - 1 && arr[index - 2 - i] == arr[index + i]){
                    start = index - 2 - i;
                    end = index + i;
                }
                else{
                    // 처음 탐색부터 같지 않으면 전달받은 위치만 변경 후 로직 종료
                    if(i == 0){
                        arr[index -1] = arr[index -1] == 1 ? 0 : 1;
                        return;
                    }
                    else{
                        for (int j = start; j < end - start + 1; j++) {
                            arr[j] = arr[j] == 1 ? 0 : 1;
                        }
                        return;
                    }
                }
            }
        }
    }
}
