package Practice.Queue;
import java.util.*;
public class _01 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2164

        Scanner sc = new Scanner(System.in);
        int cardCount = sc.nextInt();


        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= cardCount ; i++) {
            que.add(i);
        }

        while (que.size() > 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.poll());
    }
}
