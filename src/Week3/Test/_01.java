package Week3.Test;
import java.io.*;
import java.util.*;
public class _01 {

    static int count;
    static ArrayList<ArrayList<Integer>> arrays;

    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/9465

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            count = Integer.parseInt(br.readLine());
            arrays = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                arrays.add(new ArrayList<>());
                for (int k = 0; k < count; k++) {
                    arrays.get(j).add(Integer.parseInt(st.nextToken()));
                }
            }

            int answer = bfs();

            System.out.println(answer);
        }
    }
    private static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,arrays.get(0).get(0)});
        queue.add(new int[]{1,0,arrays.get(1).get(0)});

        int sum = 0;

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int y = info[0];
            int x = info[1];
            int score = info[2];

            if(x == count - 1){
                sum = Math.max(sum, score);
                continue;
            }

            if(x+1 < count){
                int nextY = y == 1 ? 0 : 1;
                int nextX = x + 1;
                queue.add(new int[]{nextY, nextX, score + arrays.get(nextY).get(nextX)});
            }
            if(x+2 < count){
                int nextX = x + 2;
                queue.add(new int[]{0, nextX, score + arrays.get(0).get(nextX)});
                queue.add(new int[]{1, nextX, score + arrays.get(1).get(nextX)});
            }
        }

        return sum;
    }
}
