package Week2.Day4;
import java.io.*;
import java.util.*;
public class _05 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/11561

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int textCase = Integer.parseInt(br.readLine());

        
        for (int i = 0; i < textCase; i++) {
            long total = Long.parseLong(br.readLine());
            long start = 0; // 시작
            long index = 1; // 뛰는 칸수
            long count = 0;
            
            // 시작과 뛰어야되는 칸수를 더했을때 입력받은 갑보다 크면 로직 종료
            while(start + index <= total){
                start += index; // ex) 1칸 뛰었으면 start는 1
                index++; // ex) 다음 칸 + 1 = 2
                count++; // 뛰는 횟수 ++
            }

            System.out.println(count);
        }
    }
}
