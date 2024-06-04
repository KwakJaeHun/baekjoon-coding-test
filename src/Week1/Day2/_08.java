package Week1.Day2;
import java.util.*;
public class _08 {
    public static void main(String[] args) {
        // 문제
        // 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
        //
        // 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
        //
        // 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
        //
        // 입력
        // 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
        //
        // 출력
        // 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.

        /**
         * 길이는 1000이하, 시간 1초, 이중 반복문 사용해도 시간복잡도에 걸리지 않을듯
         * 서로 다른 문자열을 추출 하려면 set을 사용
         * 이중 반목문을 통하여 인덱스 별로 잘라주며 뒤를 자르는 인덱스는 첫 반복문의 인덱스보다 +1 해주면 문자열 끝까지 자를 수 있을듯
         */

        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();

        Set<String> sentenceMap = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++){
            for (int j = i+1; j <= sentence.length(); j++) {
                sentenceMap.add(sentence.substring(i, j));
                System.out.println(sentenceMap);
            }
        }

        System.out.println(sentenceMap.size());
    }
}
