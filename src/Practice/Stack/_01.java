package Practice.Stack;
import java.util.*;
public class _01 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1874

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        boolean result = true;
        for (int i = 0; i < testCase; i++) {
            int number = sc.nextInt();

            if(number >= count){
                while (number >= count){
                    stack.push(count);
                    count++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int n = stack.pop();
                if(n > number){
                    System.out.println("NO");
                    result = false;
                    return;
                }
                else{
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb);
    }
}
