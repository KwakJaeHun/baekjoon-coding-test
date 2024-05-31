package Day3;
import java.util.*;
public class _03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Long n = sc.nextLong();

        Long answer = (n^ +(22*n) + 100) / 10;

        System.out.println(answer + "\n" + 3);
    }
}
