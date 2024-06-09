package Week2.Day4;
import java.io.*;
import java.util.*;

public class _07 {

    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1072

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long X = Integer.parseInt(st.nextToken());   // 게임수
        long Y = Integer.parseInt(st.nextToken());   // 승리수
        long Z = (int) ((Y * 100 / X) ); // 승률

        if(Z >= 99){
            System.out.println(-1);
            return;
        }

        long answer = -1;
        long start = 1;
        long end = X;
        
        while(start <= end){
            long middle = (start + end) / 2; // 해야될 게임 수
            if( ((Y + middle) * 100 / (X + middle)) > Z){
                answer = middle;
                // 최소 게임수를 찾아야 하므로 중간 이후를 없애준다.
                end = middle - 1;            
            }
            // 판수를 늘려야 하므로 시작값 상승
            else{
                start = middle + 1;
            }
        }

        System.out.println(answer);
    }
}
