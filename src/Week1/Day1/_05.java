package Week1.Day1;

import java.util.*;
public class _05 {
    public static void main(String[] args) {

        // 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.

        /**
         * 1. 31일과 30일 달 ArrayList 를 각각 만든다
         * 2. ArrayList 에 맞는 값을 넣어 준다.
         * 3. for 문을 통해 입력된 달 미만의 달 일을 합해준다. (1월은 계산되면 안되므로 미만으로 설정)
         * 4. 입력된 일과 위의 달의 합을 더해준다.
         * 5. 1월 1일이 월요일 이며 요일은 7개 이므로 0 index는 SUN으로 시작하여 6 index는 토요일인 배열은 생성한다. (총 일수를 더한 후 7로 나눈 나머지가 요일이기 때문)
         * 6. 총 일수 % 7 의 인덱스가 입력 받은 날짜의 요일이다.
         */
        
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        List<Integer> thirtyOneMonth = new ArrayList<>();
        thirtyOneMonth.add(1);
        thirtyOneMonth.add(3);
        thirtyOneMonth.add(5);
        thirtyOneMonth.add(7);
        thirtyOneMonth.add(8);
        thirtyOneMonth.add(10);
        thirtyOneMonth.add(12);

        List<Integer> thirtyMonth = new ArrayList<>();
        thirtyMonth.add(4);
        thirtyMonth.add(6);
        thirtyMonth.add(9);
        thirtyMonth.add(11);

        int add = 0;
        for (int i = 1; i < month; i++) {
            if(thirtyOneMonth.contains(i)){
                add += 31;
            } else if (thirtyMonth.contains(i)) {
                add += 30;
            }
            else {
                add += 28;
            }
        }

//        이런 방법도 활용 가능할듯?
//        int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
//
//        int add = 0;
//        for (int i = 0; i < month - 1; i++) {
//            add += monthArray[i];
//        }

        String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(weeks[(add + day) % 7]);
    }
}
