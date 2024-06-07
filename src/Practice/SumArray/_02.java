package Practice.SumArray;
import java.util.*;
public class _02 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2018
        // 투포인터 개념 이해

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;

        while(endIndex != N){
            if(sum < N){
                endIndex++;
                sum += endIndex;
            }
            else if(sum > N){
                sum -= startIndex;
                startIndex++;
            }
            else if(sum == N){
                count++;
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(count);
    }
}
