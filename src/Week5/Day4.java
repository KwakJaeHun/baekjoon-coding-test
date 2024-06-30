package Week5;

public class Day4 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150369 - 택배 배달과 수거하기

    public static void main(String[] args) {


        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = -1;
        int deliver = 0, pickup = 0;
        for(int i = n-1; i >= 0; i--){
            deliver += deliveries[i];
            pickup += pickups[i];
            while (deliver > 0 || pickup > 0){
                deliver -= cap;
                pickup -= cap;
                answer += ((i+1) * 2);
            }

        }
        return answer + 1;
    }

}
