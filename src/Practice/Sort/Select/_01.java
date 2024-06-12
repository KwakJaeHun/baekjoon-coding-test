package Practice.Sort.Select;
import java.io.*;

public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1427

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");

        int count = N.length;
        int [] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(N[i]);
        }

        for (int i = 0; i < count; i++) {
            int max = i;
            for (int j = i+1; j < count; j++) {
                if(arr[j] > arr[max]){
                    max = j;
                }
            }

            if(arr[max] > arr[i]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for(int a : arr){
            System.out.print(a);
        }
    }
}
