import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int line = 1;
        while(x > line){
            x -= line;
            line++;
        }

        int a = 0; // 분자
        int b = 0; // 분모

        if(line % 2 == 0){
            a = x;
            b = line - x + 1;
        }
        else{
            a = line - x +1;
            b = x;
        }

        System.out.print(a+"/"+b);

    }
}