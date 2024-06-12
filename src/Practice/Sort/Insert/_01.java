package Practice.Sort.Insert;
import java.io.*;
import java.util.StringTokenizer;

public class _01 {
    public static void main(String[] args) throws IOException {

        // https://www.acmicpc.net/problem/11399

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int insertPoint = i;
            int inserValue = A[i];
            for (int j = i-1; j >= 0; j--) {
                if(A[i] > A[j]){
                    insertPoint = j;
                    break;
                }

                if(j == 0){
                    insertPoint = 0;
                }
            }

            for (int j = i; j > insertPoint; j--) {
                A[j] = A[j-1];
            }

            A[insertPoint] = inserValue;
        }
        
        // 합배열
        int[] S = new int[N];
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }

        int answer = 0;
        for(int s : S){
            answer += s;
        }

        System.out.println(answer);
    }
}
