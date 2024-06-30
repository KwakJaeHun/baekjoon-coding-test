package Week5;

import java.util.*;

public class Day5 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/155651 - 호텔 대실
    public static void main(String[] args) {


        String[][] book_time = {
                {"09:10", "10:10"},
                {"10:20", "12:20"}
        };

        System.out.println(solution(book_time));
    }

    public static int solution(String[][] book_time) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < book_time.length; i++) {
            String[] startArr = book_time[i][0].split(":");
            int start = (Integer.parseInt(startArr[0]) * 60) + Integer.parseInt(startArr[1]);

            String[] endArr = book_time[i][1].split(":");
            int end = (Integer.parseInt(endArr[0]) * 60) + Integer.parseInt(endArr[1]);

            pq.add(new int[]{start, end});
        }
        
        int[] first = pq.poll();
        List<int[]> useRoom = new ArrayList<>();
        useRoom.add(first);
        while (!pq.isEmpty()){
            boolean addStatus = true;
            for (int i = 0; i < useRoom.size(); i++) {
                if(pq.peek()[0] >= useRoom.get(i)[1] + 10){
                    useRoom.remove(i);
                    useRoom.add(pq.poll());
                    addStatus = false;
                    break;
                }
            }
            if (addStatus){
                useRoom.add(pq.poll());
            }
        }
        
        return useRoom.size();
    }
}
