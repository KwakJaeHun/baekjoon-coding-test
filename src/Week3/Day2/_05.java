package Week3.Day2;
import java.util.*;
import java.io.*;

public class _05 {

    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1213

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - (int)'A';
            alphabet[index]++;
        }


        StringBuilder sb = new StringBuilder();

        int oddCont = 0;
        int oddIndex = 0;
        for (int i = 0; i < 26; i++) {
            if(alphabet[i] != 0){
                if(alphabet[i] % 2 != 0){
                    oddCont++;
                    oddIndex = i;
                }

                if(oddCont > 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                for (int j = 0; j < alphabet[i] / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
        }

        String reverse = new StringBuilder(sb).reverse().toString();

        if(oddCont > 0){
            sb.append((char) (oddIndex + 'A'));
        }

        sb.append(reverse);

        System.out.println(sb);
    }
}
