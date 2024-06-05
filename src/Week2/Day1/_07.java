package Week2.Day1;

import java.util.*;

public class _07 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/9012

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {

            // 괄호모양을 입력받는다.
            char[] sentenceArray = sc.next().toCharArray();
            Stack<Character> sentenceStack = new Stack<>();

            for (char c : sentenceArray) {
                
                // 괄호 모양이 ( 이면 스택에 담아준다.
                if(c == '('){
                    sentenceStack.push(c);
                }
                // 괄호모양이 ( 일때
                else{
                    // 스택이 비어 있지 않고 ( 모양 일때 쌍을 이루므로 스택안의 ( 제거
                    if(!sentenceStack.isEmpty() && sentenceStack.peek() == '('){
                        sentenceStack.pop();
                    }
                    // 스택이 비어있으면 )로 시작하므로 스택 채우기
                    else{
                        sentenceStack.push(')');
                    }
                }
            }

            // 스택이 비어있으면 쌍을 이루므로 YES, 스택이 비어있지 않으면 NO
            System.out.println(sentenceStack.isEmpty() ? "YES" : "NO");
        }
    }
}
