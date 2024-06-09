package Week2.Day4;
import java.io.*;
import java.util.*;
public class _02 {

    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1292

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        int index = 0;
        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= i; j++) {

                index++;

                if(index >= A && index <= B){
                    answer += i;
                }

                if(index == B){
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
