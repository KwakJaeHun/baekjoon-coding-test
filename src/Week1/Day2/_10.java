package Week1.Day2;
import java.util.*;
public class _10 {
    public static void main(String[] args) {
        // 문제
        // 79를 영어로 읽되 숫자 단위로 하나씩 읽는다면 "seven nine"이 된다.
        // 80은 마찬가지로 "eight zero"라고 읽는다. 79는 80보다 작지만, 영어로 숫자 하나씩 읽는다면 "eight zero"가 "seven nine"보다 사전순으로 먼저 온다.
        //
        // 문제는 정수 M, N(1 ≤ M ≤ N ≤ 99)이 주어지면 M 이상 N 이하의 정수를 숫자 하나씩 읽었을 때를 기준으로 사전순으로 정렬하여 출력하는 것이다.

        // 입력
        // 첫째 줄에 M과 N이 주어진다.

        //출력
        //M 이상 N 이하의 정수를 문제 조건에 맞게 정렬하여 한 줄에 10개씩 출력한다.

        /**
         * 1. 반복문을 통해 입력 받은 숫자를 저장한다.
         * 2. TreeMap (sorting Map) 을 선언하고  numberStringReplace 메서드를 통해 숫자를 문자로 치환 한 값을 key, 기존 숫자를 value 로 저장한다.
         * 3. 반복문을 통해 value를 출력한다.
         * 4. 10번째 마다 줄바꿈을 해야되므로 10으로 나눴을때 나머지가 0이면 줄바꿈을 해준다.
         */

        Scanner sc = new Scanner(System.in);

        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        Set<Integer> numberSet = new HashSet<>();

        for (int i = firstNumber; i <= secondNumber; i++) {
            numberSet.add(i);
        }

        Map<String, Integer> numberMap = new TreeMap<>();
        for(int s : numberSet){
            String numberString = numberStringReplace(String.valueOf(s));

            numberMap.put(numberString, s);
        }

        int count = 1;
        for(String n : numberMap.keySet()){
            System.out.print(numberMap.get(n) + " ");
            if(count % 10 == 0){
                System.out.println("");
            }
            count++;
        }
    }

    private static String numberStringReplace(String numberString) {

        numberString = numberString.replace("0", "zero");
        numberString = numberString.replace("1", "one");
        numberString = numberString.replace("2", "two");
        numberString = numberString.replace("3", "three");
        numberString = numberString.replace("4", "four");
        numberString = numberString.replace("5", "five");
        numberString = numberString.replace("6", "six");
        numberString = numberString.replace("7", "seven");
        numberString = numberString.replace("8", "eight");
        numberString = numberString.replace("9", "nine");

        return numberString;
    }
}
