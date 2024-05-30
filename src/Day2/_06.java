package Day2;
import java.util.*;
public class _06 {
    public static void main(String[] args) {
        // 상근이는 세계적인 소프트웨어 회사 기글에서 일한다.
        // 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다.
        // 따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.
        // 각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.
        //
        //상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다.
        // 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다.
        // 로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.
        //
        // 입력
        // 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다.
        // (2 ≤ n ≤ 106) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다. "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
        //
        // 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다.
        // 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
        //
        // 출력
        // 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.

        /**
         * 1. List 선언
         * 2. 반복문을 통해 출퇴근 정보 입려 받기
         * 3. 출근한 사람만 list에 추가
         * 4. sort와 reverse로 오름차순 정렬 후 역 정렬
         * 4-1. List.sort() 파라미터로 Collections.reverseOrder()를 사용하면 간결하게 정렬 후 역정렬 가능
         *
         * 1차 시간초과로 실패
         * 시간 복잡도를 고려 안하여 발생한거 같음 (2 ≤ n ≤ 106)
         * set을 통하여 재 풀이
         */

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        Set<String> humanSet = new HashSet<>();

        for (int i = 0; i < count; i++) {
            String name = sc.next();
            String record = sc.next();

            if(record.equals("enter")){
                humanSet.add(name);
            }
            else{
                humanSet.remove(name);
            }
        }

        // Set은 순서를 보장하지 않기 때문에 ArrayList로 변환
        List<String> humanList = new ArrayList<>(humanSet);
        Collections.sort(humanList);
        Collections.reverse(humanList);
        
        // List.sort 파라미터로 Collections.reverseOrder()를 사용하면 간결하게 쓸 수 있다.
        // humanList.sort(Collections.reverseOrder());

        for(String name : humanList){
            System.out.println(name);
        }
    }
}
