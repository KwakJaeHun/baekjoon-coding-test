package Week3.Day05;
import java.io.*;
import java.util.*;
public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1292

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[B];
        int count = 0;
        int currentNum = 1;
        
        // 수열 배열 만들기
        for (int i = 0; i < B; i++) {
            if(currentNum > count){
                arr[i] = currentNum;
            }
            count++;

            if(count == currentNum){
                count = 0;
                currentNum++;
            }
        }
        
        // 합배열 만들기
        int[] sumArr = new int[B+1];
        for (int i = 1; i <= B; i++) {
            sumArr[i] = arr[i-1] + sumArr[i-1];
        }
        
        // 구간합 계산
        System.out.println(sumArr[B] - sumArr[A-1]);
    }
}
