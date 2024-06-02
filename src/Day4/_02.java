package Day4;
import java.util.*;
public class _02 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/11721

        Scanner sc = new Scanner(System.in);

        String sentence = sc.next();

        for(int i = 0; i < sentence.length(); i += 10){
            System.out.println(sentence.substring(i, Math.min( i + 10, sentence.length())));
        }
    }
}
