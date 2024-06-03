package Day5;
import java.util.*;

public class _02 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2566

        Scanner sc = new Scanner(System.in);


        int maxNum = 0;
        int row = 0;
        int column = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = sc.nextInt();
                if(num >= maxNum){
                    maxNum = num;
                    row = i + 1;
                    column = j + 1;

                    if(maxNum == 99){
                        break;
                    }
                }
            }
        }

        System.out.println(maxNum);

        System.out.print(row + " " + column);
    }
}
