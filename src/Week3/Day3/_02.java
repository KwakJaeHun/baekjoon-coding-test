package Week3.Day3;
import java.io.*;
import java.util.*;
public class _02 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/14659

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        
        // Queue는 그리디 하지 못한가 ? 라는 의문
        /*Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while(!queue.isEmpty() && arr[i] > queue.peek()){
                queue.poll();
            }
            queue.add(arr[i]);

            maxCount = Math.max(maxCount, queue.size() -1);
        }*/
        
        // 그리디? 한 로직? 만들어보기
        int maxHeight = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] > maxHeight){
                maxHeight = arr[i];
                count = 0;
            }
            else{
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(maxCount);
    }
}
