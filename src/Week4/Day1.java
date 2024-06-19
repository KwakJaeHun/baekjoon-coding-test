package Week4;
import java.util.*;
public class Day1 {
    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/181188

        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        int answer = solution(targets);
        System.out.println(answer);
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int maxLength = 0;
        for(int[] t : targets){
            if(t[0] >= maxLength){
                answer++;
                maxLength = t[1];
            }
        }

        return answer;
    }
}
