package Day2;

import java.util.*;
public class _01 {
    public static void main(String[] args) {
        // 문제
        // 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
        // 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
        // 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

        // 입력
        // 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
        // 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
        // 또한 문자열은 공백으로 시작하거나 끝날 수 있다.

        /**
         * 1. trim과 length를 활용하여 배열 길이 출력 - 실페
         *
         * 2. 백준에서 틀렸다고 나옴
         *    trim으로 제거되지 않는 공백이 있는 문제가 있는것으로 판단됨
         *    for문을 통한 isEmpty 메서드로  실제 단어만 체크하여 length 증가 시켜주기
         *
         * * trim과 split으로만 풀면 된다는 단순한 생각 하지 않고 반례 찾기
         */

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        int length = 0;
        for (String i : input.split(" ")) {
            if(!i.isEmpty()){
                length++;
            }
        }

        System.out.println(length);
    }
}
