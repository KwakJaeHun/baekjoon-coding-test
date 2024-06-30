package Week5;

public class Day3 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/152996 - 시소 짝꿍

    public static void main(String[] args) {


        int[] board= {100,180,360,100,270};

        System.out.println(solution(board));
    }

    public static long solution(int[] weights) {

        Long answer = Long.valueOf(0);

        int[] w = new int[1001]; // 기존 몸무게별 사람수 카운팅 배열
        int[] wd = new int[4001]; // 가중치 몸무게별 카운팅 배열, 짝꿍의 수

        for(int i = 0; i < weights.length; i++)
        {
            int d2 = weights[i]*2;
            int d3 = weights[i]*3;
            int d4 = weights[i]*4;

            answer += wd[d2]; // 해당 가중치 무게와 동일한 짝꿍의 수 더하기
            answer += wd[d3];
            answer += wd[d4];

            if(w[weights[i]] > 0) // 같은 몸무게가 이전에 있었다면
                answer -= w[weights[i]] * 2; // answer에 3배가 저장되었기 때문에 2배를 빼주어야함

            w[weights[i]]++; // 현재 탐색하는 무게 카운팅
            wd[d2]++;
            wd[d3]++;
            wd[d4]++;
        }
        return answer;
    }

}
