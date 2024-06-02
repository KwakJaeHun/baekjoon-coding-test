package Day4;
import java.util.*;
public class _01 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2902

        Scanner sc = new Scanner(System.in);

        String[] sentence = sc.next().split("[-]");

        for (int i = 0; i < sentence.length; i++) {
            System.out.print(sentence[i].charAt(0));
        }
    }
}
