package Week2.Day1;
import java.util.*;
public class _01 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/17608

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        
        // 스택 생성 - 나중에 넣은 막대에서 하나씩 빼가며 높이를 비교해야 하므로
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < count; i++) {
            st.push(sc.nextInt());
        }
        
        // 맨앞의 막대기는 무조건 보이므로 1로 할당
        int showCount = 1;

        // 맨 마지막에 넣은 요소 꺼내며 기준값 정의
        int standardNumber = st.pop();

        int loopCount = st.size();
        // 하나씩 꺼내며 값 비교하고 기준값보다 큰값이면 보이는 갯수를 증가시킨다.
        for (int i = 0; i < loopCount;i++) {

            int nextBar = st.pop();
            if(nextBar > standardNumber){
                showCount++;
                // 다음 막대기가 기준보다 크면 기준을 큰쪽으로 잡아둬야 한다.
                standardNumber = nextBar;
            }
        }

        System.out.println(showCount);
    }
}
