package Week3.Day05;
import java.io.*;
public class _03 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/21313

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if(i == N && N % 2 == 1){
                System.out.print("3");
                return;
            }

            if(i % 2 == 1){
                System.out.print("1" + " ");
            }
            else{
                System.out.print("2" + " ");
            }
        }

    }
}
