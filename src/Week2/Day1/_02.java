package Week2.Day1;
import java.util.*;
public class _02 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/12605

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        
        // 스택을 담을 List 생성
        List<Stack> stackList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Stack<String> stack = new Stack<>();

            if(i == 0) sc.nextLine();

            String sentence = sc.nextLine();

            // split 말고 tokenizer 쓰는 연습하기
            StringTokenizer st = new StringTokenizer(sentence, " ");
            
            // 스택에 문장 요소 push
            while (st.hasMoreTokens()){
                stack.push(st.nextToken());
            }

            // List에 스택추가
            stackList.add(stack);
        }

        for (int i = 0; i < stackList.size(); i++) {

            System.out.print("Case #"+(i+1)+": ");
            
            // loop 횟수
            int stackSize = stackList.get(i).size();
            
            // 출력
            for (int j = 0; j < stackSize; j++) {
                System.out.print(stackList.get(i).pop());

                if(j != stackSize-1) System.out.print(" ");
            }

            System.out.println();
        }
    }
}
