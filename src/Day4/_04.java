package Day4;
import java.util.*;
public class _04 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/28432

        Scanner sc = new Scanner(System.in);

        int questionCount = sc.nextInt();

        List<String> questionList = new ArrayList<>();

        for (int i = 0; i < questionCount; i++) {
            String questionWord = sc.next();
            questionList.add(questionWord);
        }

        // ? 위치
        int index = questionList.indexOf("?");

        // ?의 index가 0보다 크면 -> 정답의 시작 알파벳은 ? 이전의 마지막 알파벳, 작으면 값 없음
        String start = index > 0  ? questionList.get(index - 1).charAt(questionList.get(index - 1).length() -1) + "" : "";

        // ?의 index + 1이 끝말잇기 질문 개수보다 작으면 -> 정답의 끝 알파 벳은 ? 이후의 첫번째 알파벳, 크면 값 없음
        String end = index + 1 < questionCount ? questionList.get(index + 1).charAt(0) + "" : "";

        int answerCount = sc.nextInt();

        for (int i = 0; i < answerCount; i++) {
            String answerWord  = sc.next();

            // 정답이 ArrayList에 포함되지 않을때
            if(!questionList.contains(answerWord)){
                /**
                 * ? 만 존재 했을 경우의 수를 따지지 못하여 조건문 보완
                 */

                // 조건 1. 정답의 첫 알파벳이 ? 이전의 끝 알파벳과 일치 또는 값이 없을때 true
                // 조건 2. 정답의 마지막 알파벳이 ? 이후의 첫 알파벳과 일치 또는 값이 없을때 true

                // 경우의 수
                // 1. 정답의 첫 알파벳이 ? 이전의 끝 알파벳과 일치 && 값이 없음 -> ? 가 맨 마지막에 옴
                // 2. 값이 없음 && 정답의 끝 알파벳이 ? 이후의 첫 알파벳과 일치 -> ? 가 맨 첫번째에 옴
                // 3. 값이 없음 && 값이 없음 -> ?만 존재. 첫번째 단어 출력

                if( ( (answerWord.charAt(0) + "").equals(start) || start.isEmpty()) && ((answerWord.charAt(answerWord.length() - 1) + "").equals(end) || end.isEmpty())) {
                    System.out.println(answerWord);
                    break;
                }
            }
        }
    }
}
