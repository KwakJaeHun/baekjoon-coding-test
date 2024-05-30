package Day2;

import java.util.*;

public class _04 {
    public static void main(String[] args) {
        // 문제
        // 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
        //
        // 입력
        // 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
        //
        // 출력
        // 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

        /**
         * 오늘 푼 2번 문제와 비슷하게 풀이
         * 
         * 1. 입력받은 문자를 대문자로 치환 후 배열 생성
         * 2. Map 생성
         * 3. Map에 문자가 없으면 데이터 신규 생성, 있으면 업데이트
         * 4. Map에서 많이 사용된 문자 변수에 할당 후 출력
         */

        Scanner sc = new Scanner(System.in);
        String sentence = sc.next().toUpperCase();
        String[] sentenceArray = sentence.split("");

        Map<String, Integer> inputList = new HashMap<>();

        for (int i = 0; i < sentenceArray.length; i++) {
            // map에 문자가 없으면 추가
            if(!inputList.containsKey(sentenceArray[i])){
                inputList.put(sentenceArray[i], 1);
            }
            else{
                int add = inputList.get(sentenceArray[i]) + 1;
                inputList.put(sentenceArray[i], add);
            }
        }

        int maxCount = 0;
        String maxAlphabet = "";
        for(String i : inputList.keySet()){
            // 첫 반복문 시작에는 첫번쨰 요소 할당
            if(maxAlphabet.isEmpty()){
                maxAlphabet = i;
                maxCount = inputList.get(i);
            }
            // 최대 카운트보다 가져온 value의 값이 큰 경우 해당 요소 할당
            else if(inputList.get(i) > maxCount){
                maxAlphabet = i;
                maxCount = inputList.get(i);
            }
            // 최대 카운트와 가져온 value가 같으면 ?와 value 할당
            else if(inputList.get(i) == maxCount){
                maxAlphabet = "?";
                maxCount = inputList.get(i);
            }
        }

        System.out.println(maxAlphabet);
    }
}
