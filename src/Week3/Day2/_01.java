package Week3.Day2;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2851
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());

            if(answer + score <= 100){
                answer += score;
            }
            else{
                int x = 100 - answer;
                int y = (answer + score) - 100;

                if(x > y || x == y){
                    answer += score;
                }
                break;
            }
        }

        System.out.println(answer);
    }
}
