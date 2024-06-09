package Week2.Day4;
import java.util.*;
import java.io.*;
public class _03 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int[] answer = new int[testCase];
        for (int i = 0; i < testCase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] last = new int[5];
            int firstMax = 0;
            int lastSum = 0;

            firstMax = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int j = 0; j < 5; j++) {
                last[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(last);
            lastSum = last[4] + last[3];

            answer[i] = firstMax + lastSum;
        }

        Arrays.sort(answer);

        System.out.println(answer[testCase - 1]);
    }
}
