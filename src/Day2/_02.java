package Day2;
import java.util.*;
public class _02 {

    // 입력
    // 첫 번째 줄에 펼쳐진 카드의 개수 N이 주어집니다.
    // 두 번째 줄부터 N개의 줄에 걸쳐 한 줄에 하나씩 펼쳐진 카드의 정보가 주어집니다.

    // 카드의 정보는 공백으로 구분된, 과일의 종류를 나타내는 문자열 S와 과일의 개수를 나타내는 양의 정수 X로 이루어져 있습니다.
    // S는 STRAWBERRY, BANANA, LIME, PLUM 중 하나입니다.

    //출력
    //한별이가 종을 쳐야 하면 YES을, 아니면 NO를 출력해주세요.

    /**
     * 1. Map 변수 선언
     * 2. 카드 펼저진 카드 개수 받아 for문 작성
     * 3. 카드 종류의 키를 찾고 없으면 새로 등록 있으면 value의 값을 가져와 더해주고 업데이트
     * 4. 저장된 key를 통해 value가 5인 과일이 있으면 로직 종료
     *
     * 몇명이서 카드 게임을 하는지 정해주지 않아 쉽게 풀림
     * 명수가 정해져 있었다면 LinkedHashMap 을 통해 n의 배수일때 순서에 맞게 캬드 초기화 후 재 입력 필요 했을듯
     */



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cardCount = sc.nextInt(); // 펼쳐진 카드 개수
        Map<String, Integer> cardList = new HashMap<>(); // 펼쳐진 카드 목록

        for (int i = 0; i < cardCount; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            // 펼쳐진 과일 모양이 없으면 카드 추가
            if(!cardList.containsKey(type)){
                cardList.put(type, count);
            }
            // 펼쳐진 과일 모양이 있으면 값을 가져와 더해준 후 업데이트
            else{
                int existCount = cardList.get(type); // 기존 과일의 모양 개수
                int addCount = count + existCount; // 펼쳐진 카드의 기존 과일의 모양 개수 합
                
                // 과일 업데이트
                cardList.put(type, addCount);
            }

            // getOrDefault 메서드로 기본값 세팅 가능
//            for (int i = 0; i < cardCount; i++) {
//                String[] split = br.readLine().split(" ");
//                int existValue = fruit.getOrDefault(split[0], 0); // 기존에 저장된 과일 개수를 가져오고 없으면 0 반환
//                fruit.put(split[0], existValue + Integer.parseInt(split[1])); // 가져온 기존 개수에 새로운 개수 더하기
//            }
        }
        if(cardList.containsValue(5)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

//        저장된 key를 통해 value가 5인 과일이 있으면 로직 종료
//        for(String cardListKey : cardList.keySet()){
//            if(cardList.get(cardListKey) == 5){
//                System.out.println("YES");
//                return;
//            }
//        }
//        System.out.println("NO");
    }
}
