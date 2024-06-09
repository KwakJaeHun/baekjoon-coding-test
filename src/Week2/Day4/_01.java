package Week2.Day4;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2441

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            System.out.print(" ".repeat(i));
            System.out.print("*".repeat(N-i));
            System.out.println();
        }

    }
}
