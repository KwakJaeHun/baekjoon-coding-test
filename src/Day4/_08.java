package Day4;
import java.util.*;
public class _08 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/5525
        
        // IOI 최소 경우의 수로 로직 설계 후 보완하려 했으나 딱 맞아 떨어짐...
        
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int sLength = sc.nextInt();;
        String s = sc.next();

        int stringCount = 0; // count 최솟값이 1이며 1일때 만들수 있는 단어는 IOI, 문장속 IOI 개수 파악 변수
        int answer = 0;

        // sLength - 1을 하는 경우 3자리 문자열을 찾으려면 i 최대값이 (길이 - 1) 보다 작아야지 index 를 끝까지 확인 가능
        for(int i = 1; i < sLength - 1; i++){

            // 문자열에 IOI 포함시 StringCount 증가
            if(s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I'){
                stringCount++;
                // stringCount 와 IOI 조합의 수가 같은 경우
                // ex) StringCount = 1; count = 1; 인 경우 IOI를 찾은 경우 이고 stringCount를 감소 시킨 후 IOI 개수를 증가 시킨다.
                if(stringCount == count){
                    stringCount--;
                    answer++;
                }

                // IOI 를 찾았으므로 인덱스가 2증가 해야함 / why : count가 2일때 IOIOI 가 나오는데 IOIOI를 찾으려면 IOI 탐색 후 중간 I가 겹치게 하면서 IOI를 한번 더 찾아야한다. 그럼 3개의 문자 반복에서 중간이 겹칠려면 2 증가 필요
                i++;
            }
            else{
                stringCount = 0;
            }
        }

        System.out.println(answer);
    }
}