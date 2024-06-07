package Week2.Day2;
import java.util.*;
public class _02 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/27160

        Scanner sc = new Scanner(System.in);

        int testCount = sc.nextInt();

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < testCount; i++) {
            String fruit = sc.next();
            int fruitCount = sc.nextInt();

            int addCount = hm.getOrDefault(fruit, 0) + fruitCount;
            hm.put(fruit, addCount);
        }

        for(String f : hm.keySet()){
            if(hm.get(f) == 5){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }
}
