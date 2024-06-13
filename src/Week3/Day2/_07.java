package Week3.Day2;
import java.io.*;
import java.util.*;

public class _07 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/13335

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭수, 트럭은 1초에 다리길이 1만큼 이동 가능
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 최대 하중

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        // 다리 만들기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        int time = 0;
        int index = 0;
        int weight = 0;

        while(index < n || weight > 0){
            time++;

            // 맨앞 트럭 빼줌
            weight -= queue.poll();

            if(index < n){
                // 다음 트럭 추가 했을때 무게 넘지 않으면 다리에 트럭 추가
                if(truck[index] + weight <= L){
                    queue.add(truck[index]);
                    weight += truck[index];
                    index++;
                }
                else{
                    // 최대 하중을 넘어가면 0으로 다리 채워주기
                    queue.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
