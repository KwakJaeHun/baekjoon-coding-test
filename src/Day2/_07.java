package Day2;
import java.util.*;
public class _07 {
    public static void main(String[] args) {
        // 문제
        // 친구로부터 노트북을 중고로 산 스브러스는 노트북을 켜자마자 경악할 수밖에 없었다.
        // 바탕화면에 온갖 파일들이 정리도 안 된 채 가득했기 때문이다.
        // 그리고 화면의 구석에서 친구의 메시지를 확인할 수 있었다.
        //
        // 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
        // 보기 편하게 확장자들을 사전 순으로 정렬해 줘
        // 그럼 보물의 절반을 얻어내기 위해 얼른 스브러스의 노트북 파일 정리를 해줄 프로그램을 만들자!
        //
        // 입력
        // 첫째 줄에 바탕화면에 있는 파일의 개수
        // N이 주어진다.
        // 1 <= N <= 50000
        //
        // 둘째 줄부터
        // N개 줄에 바탕화면에 있는 파일의 이름이 주어진다.
        // 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다.
        // 점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다.
        // 각 파일의 이름의 길이는 최소
        // 3, 최대 100 이다.

        //출력
        //확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.

        // 예제 입력 1
        // 8
        // sbrus.txt
        // spc.spc
        // acm.icpc
        // korea.icpc
        // sample.txt
        // hello.world
        // sogang.spc
        // example.txt

        // 예제 출력 1
        // icpc 2
        // spc 2
        // txt 3
        // world 1

        /**
         * 실행시간 3초, 1 <= N <= 50000
         * 1.ThreeMap 선언
         * 2.반복문을 통해 전달 받은 파일을 배열로 만든뒤 확장자만 Map의 Key로 전달. Key가 있으면 value + 1 아니면 1을 넣어줌
         */

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        Map<String, Integer> fileMap = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String fileExtension = sc.next().split("[.]")[1];

            int fileCount = fileMap.getOrDefault(fileExtension, 0);
            fileMap.put(fileExtension, fileCount + 1);
        }

        for(String f : fileMap.keySet()){
            System.out.println(f + " " + fileMap.get(f) + " ");
        }
    }
}
