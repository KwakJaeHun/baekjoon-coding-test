package Week2.Day3;

import java.io.*;
import java.util.*;

public class _02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int schoolCount = Integer.parseInt(br.readLine());

            Map<Integer, String> map = new TreeMap<>();
            int max = 0;
            for (int j = 0; j < schoolCount; j++) {
                String[] input = br.readLine().split(" ");
                
                // 학교 이름과 술 개수
                String schoolName = input[0];
                int count = Integer.parseInt(input[1]);
                
                // key = 술 개수, value = 학교이름
                map.put(count, schoolName);
                
                // 제일 많이 마신 개수
                max = Math.max(max, count);
            }
            
            // 제일 많이 마신 개수로 학교 이름 찾기
            System.out.println(map.get(max));
        }
    }
}
