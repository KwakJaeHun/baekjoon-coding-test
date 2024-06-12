package Week3.Day1;
import java.io.*;

public class _04 {
    public static void main(String[] args) throws IOException{
        // https://www.acmicpc.net/problem/10419

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCase; i++) {
            int time = Integer.parseInt(br.readLine());

            int count = 0;
            for (int j = 1; j <= time; j++) {
                if(j + (j * j) <= time){
                    count++;
                }
                else{
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
