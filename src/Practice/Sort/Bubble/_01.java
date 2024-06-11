package Practice.Sort.Bubble;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{
        // https://www.acmicpc.net/problem/2750

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        
        int[] arr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 버블정렬 시작
        for (int i = 0; i < testCase - 1; i++) {
            for (int j = 0; j < testCase - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int a : arr){
            System.out.println(a);
        }
    }
}
