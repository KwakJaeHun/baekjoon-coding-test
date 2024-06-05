package Week2.Day1;

import java.util.*;

public class _08 {
    public static void main(String[] args) {

         // https://www.acmicpc.net/problem/2346
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCount = sc.nextInt();

        LinkedList<int[]> deque = new LinkedList<>();
        
        // 첫번째는 무조건 터지고 시작
        sb.append("1 ");
        
        // 이동해야 할 횟수
        int move = sc.nextInt();
        
        // 2번째 부터 마지막까지 deque에 넣어주기 - int[]로 몇번 풍선 정보 같이 
        for (int i = 2; i <= testCount; i++) {
            int moveInfo = sc.nextInt();
            deque.add(new int[]{i, moveInfo});
        }
        
        // 풍선이 다 터질때까지
        while (!deque.isEmpty()) {

            // 양수면 맨 앞을 꺼내 뒤로 옮겨준다.
            if (move > 0) {
                
                // move -1 번 이동 
                // ex) 3 : 1,2 옮기고 아래 로직에서 3번째를 꺼내서 터트린다.
                for (int x = 1; x < move; x++) {
                    deque.addLast(deque.pollFirst());
                }
                
                // move번째 풍선을 터트리고 움직일 횟수 저장
                int[] next = deque.pollFirst();
                move = next[1];
                
                // 풍선 번호 추가
                sb.append(next[0]).append(" ");

            }
            // 음수면 맨 뒤를 꺼내 앞으로 옮겨준다.
            else {

                // 양수전환한 move -1 번 이동
                // ex) -3 : 1,2 옮기고 아래 로직에서 3번째를 꺼내서 터트린다.
                for (int x = 1; x < move * -1; x++) {
                    deque.addFirst(deque.pollLast());
                }

                // move번째 풍선을 터트리고 움직일 횟수 저장
                int[] next = deque.pollLast();
                move = next[1];
                sb.append(next[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
