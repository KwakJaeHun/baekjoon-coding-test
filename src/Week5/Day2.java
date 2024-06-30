package Week5;

import java.util.Arrays;
import java.util.Stack;

public class Day2 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/154539 - 뒤에 있는 큰 수 찾기

    public static void main(String[] args) {


        int[] numbers= {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer, -1);

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }

}
