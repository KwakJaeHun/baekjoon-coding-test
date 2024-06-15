package Week3.Day3;
import java.io.*;
public class _01 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int payment = Integer.parseInt(br.readLine());
        int change = 1000 - payment;

        int answer = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};
        for (int coin : coins){
            answer += change/coin;
            change %= coin;

            if(change == 0){
                break;
            }
        }

        System.out.println(answer);
    }
}
