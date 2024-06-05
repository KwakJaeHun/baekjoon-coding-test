package Week2.Day1;

import java.util.*;

public class _06 {
    public static void main(String[] args) {

         // https://www.acmicpc.net/problem/1021

        Scanner sc = new Scanner(System.in);

        int dequeueSize = sc.nextInt();
        int selectCount = sc.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < dequeueSize; i++) {
            deque.add(i+1);
        }


        int count = 0;
        for (int i = 0; i < selectCount; i++) {

            int selectNumber = sc.nextInt();                 // 찾으려 하는 숫자
            int currentIndex = deque.indexOf(selectNumber);  // 찾으려 하는 숫자의 현재 위치
            int halfIndex = deque.size() / 2;               // 중간 지점 index

            // 찾으려는 숫자가 절반 이하이면 2번 로직 수행
            if(currentIndex <= halfIndex){
                for (int j = 0; j <= currentIndex; j++) {
                    if(deque.peekFirst() != selectNumber){
                        deque.addLast(deque.pollFirst()); // 잎을 꺼내서 뒤로 옮겨준다.
                        count++;
                    }
                    else{
                        deque.pollFirst();
                        break;
                    }
                }
            }
            // 찾으려는 숫자가 절반 이상 이면 3번 로직 수행
            else{
                for (int j = 0; j <= currentIndex; j++) {

                    if(deque.peekFirst() != selectNumber){
                        deque.addFirst(deque.pollLast()); // 뒤을 꺼내서 앞로 옮겨준다.
                        count++;
                    }
                    else{
                        deque.pollFirst();
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
