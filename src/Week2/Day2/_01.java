package Week2.Day2;
import java.util.*;
public class _01 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/9933

        Scanner sc = new Scanner(System.in);

        int testCount = sc.nextInt();

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i <testCount; i++) {
            String input = sc.next();

            hs.add(input);

            String s = new StringBuilder(input).reverse().toString();

            if(hs.contains(s)){
                int halfLength = s.length() / 2;
                System.out.println(s.length() + " " + s.charAt(halfLength));

                break;
            }
        }
    }
}
