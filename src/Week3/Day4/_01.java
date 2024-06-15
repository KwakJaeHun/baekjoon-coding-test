package Week3.Day4;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/17202

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");

        int[] answer  = new int[16];
        for (int i = 0; i < 8; i ++) {
            answer[i * 2] = Integer.parseInt(A[i]);
            answer[(i * 2) + 1] = Integer.parseInt(B[i]);
        }

        while(answer.length > 2){
            int[] sum = new int[answer.length - 1];
            for (int i = 0; i < answer.length - 1; i++) {
                sum[i]= (answer[i] + answer[i+1]) % 10;
            }
            answer = sum;
        }

        System.out.print(answer[0]+ "" +answer[1]);
    }
}
