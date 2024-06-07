package Week2.Day2;

import java.util.*;
import java.io.*;

public class _04 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1927

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < testCase; i++) {
            long number = Long.parseLong(br.readLine());

            if(number == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(number);
            }
        }
        br.close();
    }
}
