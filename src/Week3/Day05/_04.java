package Week3.Day05;
import java.io.*;
import java.util.*;
public class _04 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/17202

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            arrayList.add(Integer.parseInt(A.charAt(i) + ""));
            arrayList.add(Integer.parseInt(B.charAt(i) + ""));
        }

        while(true){
            int loopCount = arrayList.size();
            if (loopCount == 2) break;
                for (int i = 0; i < loopCount - 1; i++) {
                arrayList.set(i, (arrayList.get(i) + arrayList.get(i+1)) % 10);
            }
            arrayList.remove(loopCount - 1);
        }

        System.out.print(arrayList.get(0) + "" + arrayList.get(1));
    }
}
