package Week2.Day1;

import java.util.*;

public class _03 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2153

        Scanner sc = new Scanner(System.in);

        char[] sentence = sc.next().toCharArray();

        int sum = 0;
        for (int i = 0; i < sentence.length; i++) {
            // 대문자
            if(sentence[i] - 'a' + 1 < 0){
                sum += sentence[i] - 'A' + 27;
            }
            // 소문자
            else{
                sum += sentence[i] - 'a' + 1;
            }
        }

        for (int i = 2; i <= 3; i++) {
            // 문제에서 1은 소수로 지정, 2와 3은 소수, 2 와 3으로 나우었을때 나머지가 0이면 소수가 아님
            if(sum != 1 && sum != 2 && sum != 3 && sum % i == 0){
                System.out.println("It is not a prime word.");
                return;
            }
        }

        System.out.println("It is a prime word.");
    }
}
