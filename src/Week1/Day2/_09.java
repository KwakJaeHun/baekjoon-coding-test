package Week1.Day2;
import java.util.*;
public class _09 {
    public static void main(String[] args){
        // 드디어 전쟁은 전면전이 시작되었고, 서로 땅을 따먹기 시작했다.
        //현재 여러 지역은 한창 전쟁이 벌어지고 있는 상황인데, 어느 지역은 거의 전쟁이 마무리 단계로 가고 있다.
        //하지만 당신은 군대를 보낼 때 적군을 혼란시키기 위해서 우리 나라의 군대라는걸 표시하지 않고, 군대의 번호로 표시했다.
        //어느 땅에서 한 번호의 군대의 병사가 절반을 초과한다면 그 땅은 그 번호의 군대의 지배하에 놓이게 된다.
        //이때, 각 땅들을 지배한 군대의 번호를 출력하여라. 만약, 아직 전쟁이 한창중인 땅이라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.

        // 입력
        // 첫째 줄에는 땅의 개수 n(n<=200)이 주어진다.
        // 그리고 두 번째 줄에서 n+1번째 줄에는 제일 처음에 숫자 Ti(i번째 땅의 병사수, Ti<=100,000)와, Ti개의 숫자 (각각 병사의 군대 번호)가 주어진다.
        // i번째 땅의 j번째 병사 번호 Nij가 주어진다. ( | Nij | <= 2^31 )

        // 출력
        // 첫째 줄에는 각각의 땅의 상태를 순서대로 출력한다. 만약 땅이 지배가 되어있다면 그 지배한 병사의 번호를 출력하고, 아니라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.

        // 예제 입력 1                    // 예제 출력 1
        // 4
        // 10 1 2 3 1 2 3 1 2 3 1       // SYJKGW
        // 5 1 1 1 2 2                  // 1
        // 6 10 10 2 10 10 2            // 10
        // 6 1 1 1 2 2 2                // SYJKGW

        /**
         * * 런타임 numberFormat 발생 -  2^31승이 어느정도 인지 찾아 보니 2,147,483,648 이었고 int 자료형은 -2,147,483,648 ~ 2,147,483,647 까지 표현됨.... 악질새기들...
         * * Long 으로 변경 후 통화
         *
         * 1. 한번호의 군대 병사를 중복되지 않으며 Key, Value 로 구분
         * 2. n+1 번째 줄의 0 번째는 그땅의 병사 수이고 한 번의 군대의 병사가 절반을 초과한다면 승리이다.'
         * 3. 군대별 고유번호와 병사의 수를 Map에 담고 땅의 병사의 절반보다 크면 군대 고유 번호를 출력 후 로직을 종료한다.
         */

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();


        for (int i = 0; i < count; i++) {

            Map<Long, Long> map = new HashMap<>();

            if(i == 0){
                sc.nextLine(); // 첫 개행문자 제거
            }

            String[] arr = sc.nextLine().split(" ");
            int total = Integer.parseInt(arr[0]);

            for (int j = 1; j < arr.length; j++) {

//                if(map.containsKey(Long.parseLong(arr[j]))){
//                    Long add = map.get(Long.parseLong(arr[j])) + 1L;
//                    map.put(Long.parseLong(arr[j]), add);
//                }
//                else{
//                    map.put(Long.parseLong(arr[j]), 1L);
//                }

                Long add = map.getOrDefault(Long.parseLong(arr[j]), 0L);
                map.put(Long.parseLong(arr[j]), add + 1);
            }

            String answer = "SYJKGW";
            for(Long m : map.keySet()){
                if(map.get(m) > total / 2 ){
                    answer = m + "";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
