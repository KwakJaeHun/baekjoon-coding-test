package Week2.Day3;

import java.io.*;
import java.util.*;

public class _03 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/16466

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ticketCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 2의 31승 -1 은 int 범위의 마지막에 해당됨
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ticketCount; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int min = 1;
        // 작은숫자부터 처례대로 증가. / 조건이 백만번 이므로 최대 백만번 수행 / 1초미만
        while(set.contains(min)){
            min++;
        }

        System.out.println(min);
    }
}
