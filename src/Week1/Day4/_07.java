package Week1.Day4;
import java.util.*;
public class _07 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2002
        
        // Queue 자료구조 사용 해야됨을 알았으나 Queue 로직 구현을 하기엔 어려움이 있어
        // Queue 자료구조 강의 시청 후 구현

        Scanner sc = new Scanner(System.in);

        int carCount = sc.nextInt();

        // 입구에서 들어온 순서
        Queue<String> inCarQue = new LinkedList<>();
        for (int i = 0; i < carCount; i++) {
            String inCarNumber = sc.next();
            inCarQue.add(inCarNumber);
        }

        // 출구에서 나온 순서
        Queue<String> outCarQue = new LinkedList<>();
        for (int i = 0; i < carCount; i++) {
            String outCarNumber = sc.next();
            outCarQue.add(outCarNumber);
        }

        int count = 0;

        // 나간 자동차 List가 empty가 될때까지 while문 실행
        while (!outCarQue.isEmpty()){
            // 출구에서 나온 자동차를 List에서 완전히 꺼낸다.
            String outCar = outCarQue.poll(); // poll : que 들어온 순서대로 데이터를 List에서 완전히 꺼낸다 (제거됨)

            // 입구에서 들어온 자동차 출구에서 나온 자동차가 같지 않으면
            // 입구에서 들온 자동차 List에서 출구에선 자동차를 제거한 후 추월 카운트를 늘린다.
            if(!inCarQue.peek().equals(outCar)){ // peek : que에 들어온 순서대로 데이터를 List에서 가져옴 (제거되지 않음)
                count++;
                inCarQue.remove(outCar);
            }
            // 입구에서 들어온 자동차 출구에서 나온 자동차가 같으면 제거만 진행
            else{
                inCarQue.poll();
            }
        }

        System.out.println(count);
    }
}
