package Day1;
import java.util.*;
public class _03 {
    public static void main(String[] args) {
        // 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
        // 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

        // 예제 입력 1
        // 2
        // 3 ABC
        // 5 /HTP

        // 예제 출력 1
        // AAABBBCCC
        // /////HHHHHTTTTTPPPPP

        /**
         * 1. 테스트 케이스를 입력 받는다
         * 2. 반복횟수와 입력될 문자르 입력 받는다.
         * 3. 입력될 문자의 길이만큼 반복문을 실행한다.
         * 4. 입력된 문자를 배열로 변경하여 반복문 인덱스의 문자를 반복 횟수만큼 입력해준다.
         */
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {

            int loop = scanner.nextInt();
            String string = scanner.next();

            String answer = "";
            for (int j = 0; j < string.length(); j++) {
                answer += string.split("")[j].repeat(loop);
            }

            System.out.println(answer);
        }
    }
}
