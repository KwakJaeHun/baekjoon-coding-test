package Week2.Day1;

import java.util.*;

public class _04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // https://www.acmicpc.net/problem/7567

        char[] sentence = sc.next().toCharArray();

        Queue<Character> dishQueue = new LinkedList<>();

        for (int i = 0; i < sentence.length; i++) {
            dishQueue.add(sentence[i]);
        }   
        
        // 맨 아래의 접시 꺼내서 저장
        char standard = dishQueue.poll();
        
        // 맨아래 접시를 꺼냇으므로 10으로 지정
        int sum = 10;
        int loopCount = dishQueue.size();
        for (int i = 0; i < loopCount; i++) {
            char outDish = dishQueue.poll();

            if(standard == outDish){
                sum += 5;
            }
            else{
                sum += 10;
                standard = outDish;
            }
        }

        System.out.println(sum);
    }
}
