package Week2.Test;
import java.util.*;
import java.io.*;

public class _01 {
    private static int answer = 0;
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1697

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()){

            int[] nowQueue = queue.poll();
            int x = nowQueue[0];
            int count = nowQueue[1];

            if(x != K){
                if(x * 2 <= 100000 && !visited[x*2]){
                    if(x * 2 == K){
                        answer = count + 1;
                        break;
                    }
                    queue.add(new int[]{x*2, count+1});
                    visited[x  * 2] = true;
                }

                if(x + 1 <= 100000 && !visited[x+1]){
                    if(x + 1 == K){
                        answer = count + 1;
                        break;
                    }
                    queue.add(new int[]{x+1, count+1});
                    visited[x  + 1] = true;

                }

                if(x -1 >= 0 && !visited[x-1]){
                    if(x - 1 == K){
                        answer = count + 1;
                        break;
                    }
                    queue.add(new int[]{x-1, count+1});
                    visited[x  - 1] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
