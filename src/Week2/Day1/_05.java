package Week2.Day1;

import java.util.*;

public class _05 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1966

        Scanner sc = new Scanner(System.in);

        int testCount = sc.nextInt();       // 테스트 케이스 개수

        for (int i = 0; i < testCount; i++) {

            int documentCount = sc.nextInt();   // 문서 출력 개수
            int documentIndex = sc.nextInt();   // 몇번째로 출력되는지 궁금한 index

            // Queue로만 풀고 있었는데 for문에서 탐색하려면 LinkedList로 변경해줘야했음....
            LinkedList<int[]> documentQueue = new LinkedList<>();
            
            // 인덱스 비교가 필요하므로 인덱스와 문서 중요도 저장
            for (int j = 0; j < documentCount; j++) {
                int document = sc.nextInt();
                documentQueue.add(new int[]{j, document});
            }
            
            // 순서 보장 출력 로직
            int outCount = 0;
            while (!documentQueue.isEmpty()){

                // 첫번째 문서를 List에서 완전히 꺼낸다.
                int[] first = documentQueue.poll();

                // 아래의 반목문의 if 조건에 만족하지 않으면 first가 제일 큰값이 된다.
                boolean maxCheck = true;

                for (int j = 0; j < documentQueue.size(); j++) {
                    if(documentQueue.get(j)[1] > first[1]){
                        documentQueue.add(first);

                        // 첫번째 큐 제거 후 첫번째보다 큰 숫자의 앞의 요소들을 뒤로 넘긴다.
                        // ex) first = 3, 2,1,4 이라고 가정하면 4 앞의 2,1도 뒤로 넘겨주는 로직
                        for (int k = 0; k < j; k++) {
                            documentQueue.add(documentQueue.poll());
                        }
                        
                        // 첫번째 꺼낸 요소보다 큰 요소가 있으므로 maxCheck는 false로 변경해준다.
                        maxCheck = false;
                        break;
                    }
                }
                
                // 제일 큰 숫자가 아니면 처음부터 정렬 다시 시작
                if(!maxCheck) continue;

                // 제일큰 숫자일 경우 출력 count를 증가시킨다.
                outCount++;
                
                // 입력 받은 인덱스와 출력된 인덱스가 같을시 while문 종료
                if(first[0] == documentIndex){
                    System.out.println(outCount);
                    break;
                }
            }

        }
    }
}
