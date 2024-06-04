package Week1.Day4;
import java.util.*;
public class _03 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2745

        Scanner sc = new Scanner(System.in);

        String sentence = sc.next();
        int z = sc.nextInt();

        int sum = 0;
        int count = 1;

        for(int i = sentence.length() - 1; i >= 0; i--){ // 제곱해 나가야 하므로 오른쪽 에서 부터 탐색.. 왼쪽에서 부터 탐색해서 실패함;;
            int c = sentence.charAt(i);

            if((int) 'A' <= c && c <= (int) 'Z'){ // A 가 10으로 표현된다면 다른 알파벳일떈 A를 빼주고 10을 더해주면 된다. A - A = 0 이기 때문
                sum += (c - (int)'A' + 10) * count;
            }
            else{
                // 문자 숫자는 위의 공식처럼 0 (48) 을 빼줘야 원하는 값 출력 / 여기서 절음.... 계속 틀리길래 아스키 코드 참조
                sum += (c - (int)'0') * count;
                System.out.println((c - (int)'0'));
            }

            count *= z;
        }

        System.out.println(sum);
        
        // 추가 정보
        // B진법 수 N을 10진법으로 변환
        // int decimalValue = Integer.parseInt(N, B); // Integer.parseInt 메소드를 사용하여 N을 B진법에서 10진법으로 변환합니다.
    }
}
